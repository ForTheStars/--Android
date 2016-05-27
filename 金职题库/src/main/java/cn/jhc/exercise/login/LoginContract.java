package cn.jhc.exercise.login;

import cn.jhc.exercise.BasePresenter;
import cn.jhc.exercise.BaseView;
import cn.jhc.exercise.data.model.Student;

/**
 * Created by CLD1994 on 2016/5/27.
 */
public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void showToast(String msg);
    }

    interface Presenter extends BasePresenter {
        void register(Student student);
        void login(String username, String password);
    }
}
