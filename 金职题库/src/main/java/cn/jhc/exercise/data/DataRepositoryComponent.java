package cn.jhc.exercise.data;

import javax.inject.Singleton;

import cn.jhc.exercise.ApplicationModel;
import dagger.Component;

/**
 * Created by CLD1994 on 2016/5/25.
 */

@Singleton
@Component(modules = {DataRepositoryModel.class, ApplicationModel.class})
public interface DataRepositoryComponent {

    DataRepository getDataRepository();
}
