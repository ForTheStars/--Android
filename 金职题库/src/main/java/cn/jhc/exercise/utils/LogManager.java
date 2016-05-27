package cn.jhc.exercise.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author CLD
 * Log工具，类似android.util.Log。
 * tag自动产生，格式: customTagPrefix:className.methodName(L:lineNumber),
 * customTagPrefix为空时只输出：className.methodName(L:lineNumber)
 * 生成Log日志保存在本地
 */
public class LogManager {

    public static String customTagPrefix = "CLD_log";

    public static boolean debug =true;

    private static boolean sSaveToFile;
    private static String sSavePath;
    private static Handler sSaveHandler;
    private static SimpleDateFormat sSDF;
    private static FileOutputStream sFOS;
    private static Byte mSaveLock;

    static {
        mSaveLock = Byte.valueOf("0");
    }

    private LogManager() {
    }

    private static String generateTag() {
        StackTraceElement caller = new Throwable().getStackTrace()[2];
        String tag = "%s.%s(L:%d)";
        String callerClazzName = caller.getClassName();
        callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
        tag = String.format(tag, callerClazzName, caller.getMethodName(), caller.getLineNumber());
        tag = TextUtils.isEmpty(customTagPrefix) ? tag : customTagPrefix + ":" + tag;
        return tag;
    }

    public static void d(String content) {
        if (!debug) return;
        String tag = generateTag();
        Log.d(tag, content);
        synchronized(mSaveLock) {
            if(sSaveToFile && null != sSaveHandler) {
                sSaveHandler.post(new SaveRunnable(tag+" "+content));
            }
        }
    }

    public static void d(String content, Throwable tr) {
        if (!debug) return;
        String tag = generateTag();
        synchronized(mSaveLock) {
            if(sSaveToFile && null != sSaveHandler) {
                sSaveHandler.post(new SaveRunnable(tag+" "+content));
            }
        }
        Log.d(tag, content, tr);
    }

    public static void e(String content) {
        if (!debug) return;
        String tag = generateTag();
        synchronized(mSaveLock) {
            if(sSaveToFile && null != sSaveHandler) {
                sSaveHandler.post(new SaveRunnable(tag+" "+content));
            }
        }
        Log.e(tag, content);
    }

    public static void e(String content, Throwable tr) {
        if (!debug) return;
        String tag = generateTag();
        synchronized(mSaveLock) {
            if(sSaveToFile && null != sSaveHandler) {
                sSaveHandler.post(new SaveRunnable(tag+" "+content));
            }
        }
        Log.e(tag, content, tr);
    }

    public static void i(String content) {
        if (!debug) return;
        String tag = generateTag();
        synchronized(mSaveLock) {
            if(sSaveToFile && null != sSaveHandler) {
                sSaveHandler.post(new SaveRunnable(tag+" "+content));
            }
        }
        Log.i(tag, content);
    }

    public static void i(String content, Throwable tr) {
        if (!debug) return;
        String tag = generateTag();
        synchronized(mSaveLock) {
            if(sSaveToFile && null != sSaveHandler) {
                sSaveHandler.post(new SaveRunnable(tag+" "+content));
            }
        }
        Log.i(tag, content, tr);
    }

    public static void v(String content) {
        if (!debug) return;
        String tag = generateTag();
        synchronized(mSaveLock) {
            if(sSaveToFile && null != sSaveHandler) {
                sSaveHandler.post(new SaveRunnable(tag+" "+content));
            }
        }
        Log.v(tag, content);
    }

    public static void v(String content, Throwable tr) {
        if (!debug) return;
        String tag = generateTag();
        synchronized(mSaveLock) {
            if(sSaveToFile && null != sSaveHandler) {
                sSaveHandler.post(new SaveRunnable(tag+" "+content));
            }
        }
        Log.v(tag, content, tr);
    }

    public static void w(String content) {
        if (!debug) return;
        String tag = generateTag();
        synchronized(mSaveLock) {
            if(sSaveToFile && null != sSaveHandler) {
                sSaveHandler.post(new SaveRunnable(tag+" "+content));
            }
        }
        Log.w(tag, content);
    }

    public static void w(String content, Throwable tr) {
        if (!debug) return;
        String tag = generateTag();
        synchronized(mSaveLock) {
            if(sSaveToFile && null != sSaveHandler) {
                sSaveHandler.post(new SaveRunnable(tag+" "+content));
            }
        }
        Log.w(tag, content, tr);
    }

    public static void w(Throwable tr) {
        if (!debug) return;
        String tag = generateTag();
        synchronized(mSaveLock) {
            if(sSaveToFile && null != sSaveHandler) {
                sSaveHandler.post(new SaveRunnable(tag+" "+Log.getStackTraceString(tr)));
            }
        }
        Log.w(tag, tr);
    }


    public static void wtf(String content) {
        if (!debug) return;
        String tag = generateTag();
        synchronized(mSaveLock) {
            if(sSaveToFile && null != sSaveHandler) {
                sSaveHandler.post(new SaveRunnable(tag+" "+content));
            }
        }
        Log.wtf(tag, content);
    }

    public static void wtf(String content, Throwable tr) {
        if (!debug) return;
        String tag = generateTag();
        synchronized(mSaveLock) {
            if(sSaveToFile && null != sSaveHandler) {
                sSaveHandler.post(new SaveRunnable(tag+" "+content));
            }
        }
        Log.wtf(tag, content, tr);
    }

    public static void wtf(Throwable tr) {
        if (!debug) return;
        String tag = generateTag();
        synchronized(mSaveLock) {
            if(sSaveToFile && null != sSaveHandler) {
                sSaveHandler.post(new SaveRunnable(tag+" "+Log.getStackTraceString(tr)));
            }
        }
        Log.wtf(tag, tr);
    }

    public static void setSavePath(String path) {
        File logFile = new File(path);
        if(!logFile.exists()) {
            try {
                sSaveToFile = logFile.createNewFile();
            } catch (IOException var5) {
                setSaveToFile(false);
                e("bug",var5);
            }
        }

        if(!logFile.canWrite()) {
            setSaveToFile(false);
        } else {
            HandlerThread handlerThread = new HandlerThread("save_log");
            handlerThread.start();
            sSaveHandler = new Handler(handlerThread.getLooper());
            sSDF = new SimpleDateFormat("yy-MM-dd HH:mm:ss.S", Locale.CHINA);

            try {
                sFOS = new FileOutputStream(logFile, true);
            } catch (FileNotFoundException var4) {
                setSaveToFile(false);
                e("bug",var4);
                return;
            }

            setSaveToFile(true);
        }
    }

    public static void saveToFile(String msg) {
        if(null != msg && null != sSDF && null != sFOS) {
            String line = sSDF.format(new Date()) + " " + msg;
            if(!line.equals("\n")) {
                line = line + "\n";
            }

            try {
                sFOS.write(line.getBytes());
                sFOS.getFD().sync();
            } catch (IOException var3) {
                setSaveToFile(false);
                e("bug",var3);
            }

        }
    }

    public static void setSaveToFile(boolean saveToFile) {
        Byte var1 = mSaveLock;
        synchronized(mSaveLock) {
            sSaveToFile = saveToFile;
        }
    }

    static class SaveRunnable implements Runnable {
        private String mMsg;

        public SaveRunnable(String msg) {
            this.mMsg = msg;
        }

        public void run() {
            saveToFile(this.mMsg);
        }
    }

}
