package cn.jhc.exercise.login;

import android.os.Bundle;

import cn.jhc.exercise.BaseActivity;
import cn.jhc.exercise.R;

public class LoginActivity extends BaseActivity {

    @Override
    protected Integer getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected Integer getFragmentContainerId() {
        return R.id.fragmentContainer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginFragment loginFragment = LoginFragment.newInstance();
        addFragment(loginFragment);
        DaggerLoginComponent.builder()
                .dataRepositoryComponent(mApp.getDataRepositoryComponent())
                .loginModel(new LoginModel(loginFragment))
                .build()
                .getLoginPresenter();
    }
}
