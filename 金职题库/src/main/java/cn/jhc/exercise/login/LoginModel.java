package cn.jhc.exercise.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by CLD1994 on 2016/5/27.
 */
@Module
public class LoginModel {
    private final LoginContract.View mLoginView;

    public LoginModel(LoginContract.View loginView) {
        mLoginView = loginView;
    }

    @Provides
    LoginContract.View provideLoginView(){
        return mLoginView;
    }
}
