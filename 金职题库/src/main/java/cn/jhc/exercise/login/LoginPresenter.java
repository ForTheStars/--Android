package cn.jhc.exercise.login;

import javax.inject.Inject;

import cn.jhc.exercise.data.DataRepository;
import cn.jhc.exercise.data.model.Student;
import cn.jhc.exercise.utils.Utils;
import rx.Subscriber;

/**
 * Created by CLD1994 on 2016/5/27.
 */
public class LoginPresenter implements LoginContract.Presenter {

    private final DataRepository mDataRepository;
    private final LoginContract.View mLoginView;

    @Inject
    public LoginPresenter(DataRepository dataRepository, LoginContract.View loginView) {
        mDataRepository = dataRepository;
        mLoginView = loginView;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void register(Student student) {
        mDataRepository.register(student)
                .subscribe(new Subscriber<Student>() {
                    @Override
                    public void onCompleted() {
                        //Empty
                    }

                    @Override
                    public void onError(Throwable e) {
                        Utils.handleError(e);
                    }

                    @Override
                    public void onNext(Student student) {
                        mLoginView.showToast("注册成功");
                    }
                });
    }

    @Override
    public void login(String username, String password){
        mDataRepository.login(username,password)
                .subscribe(new Subscriber<Student>() {
                    @Override
                    public void onCompleted() {
                        //Empty
                    }

                    @Override
                    public void onError(Throwable e) {
                        Utils.handleError(e);
                    }

                    @Override
                    public void onNext(Student student) {
                        mLoginView.showToast("登录成功");
                    }
                });
    }

    @Inject
    void setupListeners() {
        mLoginView.setPresenter(this);
    }
}
