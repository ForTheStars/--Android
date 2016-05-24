#优化次数
-optimizationpasses 5
#混淆时不会产生形形色色的类名，不使用大小写混合
-dontusemixedcaseclassnames
#混淆jars中的非public classes
-dontskipnonpubliclibraryclasses
#不预校验
-dontpreverify
#混淆时记录日志
-verbose
#忽略警告，避免打包时某些警告出现
-ignorewarnings
#将包里的类混淆成n个再重新打包到一个统一的package中，后跟一个目录名
-repackageclasses ''
#混淆时所采用的算法
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

-keepattributes Signature,*Annotation*,InnerClasses,EnclosingMethod,Deprecated,Exceptions

#保持R文件不被混淆，否则，你的反射是获取不到资源id的
-keep class **.R
-keep class **.R$* {
    <fields>;
}



-dontwarn android.support.**
-dontwarn org.apache.commons.**

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService

-keep class android.support.test.espresso.IdlingResource { *; }
-keep class com.google.common.base.Preconditions { *; }

# For Guava:
-dontwarn javax.annotation.**
-dontwarn javax.inject.**
-dontwarn sun.misc.Unsafe

#v4包混淆
-keep class android.support.v4.app.** { *; }
-keep interface android.support.v4.app.** { *; }
-keep class android.support.v4.widget.DrawerLayout { *; }

#tuSDK混淆
-keep class org.lasque.tusdk.**{public *; protected *; }
-keep class org.lasque.tusdk.core.utils.image.GifHelper{ *; }
-keep class org.apache.commons.**{ *; }
-keep class com.nostra13.universalimageloader.**{ *; }
-keep class it.sephiroth.android.library.exif2.**{ *; }

#Gson混淆
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.examples.android.model.** { *; }
-keep class com.google.gson.** { *;}

#volley混淆
-keep class com.android.volley.** {*;}
-keep class com.android.volley.toolbox.** {*;}
-keep class com.android.volley.Response$* { *; }
-keep class com.android.volley.Request$* { *; }
-keep class com.android.volley.RequestQueue$* { *; }
-keep class com.android.volley.toolbox.HurlStack$* { *; }
-keep class com.android.volley.toolbox.ImageLoader$* { *; }

#retrofit混淆
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

#butterknife混淆
-dontwarn butterknife.internal.**
-keep class **$$ViewInjector { *; }
-keepnames class * { @butterknife.InjectView *;}

#javaBean不能被混淆
-keep class com.bowhead.gululu.database.** { *;}
-keep class con.bowhead.gululu.model.** { *;}

-keepclasseswithmembernames class * {
    native <methods>;
}

# 保持自定义控件类不被混淆
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}
-keepclasseswithmembers class * {
    void onClick*(...);
}
-keepclasseswithmembers class * {
    *** *Callback(...);
}


#enum混淆规则
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

#Parcelable混淆规则
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

#Serializable混淆规则
-keep public class * implements java.io.Serializable {*;}
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# we need line numbers in our stack traces otherwise they are pretty useless
-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable
