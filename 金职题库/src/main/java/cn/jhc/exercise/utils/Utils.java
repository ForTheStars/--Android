package cn.jhc.exercise.utils;

import com.google.gson.Gson;

import java.io.IOException;

import cn.jhc.exercise.data.model.ResponseStatus;
import retrofit2.adapter.rxjava.HttpException;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by CLD1994 on 2016/5/18.
 */

public class Utils {

    private static Gson gson;
    static {gson = new Gson();}

    public static void handleError(Throwable throwable){
        LogManager.d(throwable.getMessage());
        if (throwable instanceof HttpException) {
            HttpException error = (HttpException) throwable;
            try {
                ResponseStatus state = gson.fromJson(error.response().errorBody().string(),ResponseStatus.class);
                LogManager.d(checkNotNull(state).getMsg(),new Throwable("没有内容"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throwable.printStackTrace();
        }
    }

}
