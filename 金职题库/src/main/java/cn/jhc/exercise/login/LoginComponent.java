package cn.jhc.exercise.login;

import cn.jhc.exercise.data.DataRepositoryComponent;
import cn.jhc.exercise.utils.FragmentScoped;
import dagger.Component;

/**
 * Created by CLD1994 on 2016/5/27.
 */
@FragmentScoped
@Component(dependencies = DataRepositoryComponent.class, modules = LoginModel.class)
public interface LoginComponent {
    LoginPresenter getLoginPresenter();
}
