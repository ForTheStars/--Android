package cn.jhc.exercise;

import android.app.Application;

import cn.jhc.exercise.data.DaggerDataRepositoryComponent;
import cn.jhc.exercise.data.DataRepositoryComponent;
import cn.jhc.exercise.data.DataRepositoryModel;

/**
 * Created by CLD1994 on 2016/5/25.
 */

public class MyApplication extends Application{

    private DataRepositoryComponent mDataRepositoryComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mDataRepositoryComponent = DaggerDataRepositoryComponent.builder()
                .dataRepositoryModel(new DataRepositoryModel())
                .applicationModel(new ApplicationModel(getApplicationContext()))
                .build();
    }

    public DataRepositoryComponent getDataRepositoryComponent() {
        return mDataRepositoryComponent;
    }
}
