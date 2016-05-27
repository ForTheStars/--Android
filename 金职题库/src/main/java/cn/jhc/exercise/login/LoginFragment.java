package cn.jhc.exercise.login;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import butterknife.OnClick;
import cn.jhc.exercise.BaseFragment;
import cn.jhc.exercise.R;
import cn.jhc.exercise.data.model.Student;

import static com.google.common.base.Preconditions.checkNotNull;

public class LoginFragment extends BaseFragment implements LoginContract.View{

    private LoginContract.Presenter mPresenter;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    protected Integer getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initView(View root, Bundle savedInstanceState) {

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.loginButton)
    void onLoginButtonClick(){
        mPresenter.login("CLD1994", "cgloveting25");
    }

    @OnClick(R.id.signUpButton)
    void onSignUpButtonClick(){

        Student student = new Student();
        student.setUsername("CLD1994");
        student.setPassword("cgloveting25");
        student.setStudentId("201323010730058");
        student.setClassNo("软件131");
        student.setMajor("Android");
        student.setKillCount("0");
        student.setNickname("透眸");
        student.setRealName("陈刚");
        student.setRank("1");
        student.setTeacher("陈尧妃");

        mPresenter.register(student);
    }


}
