package cn.jhc.exercise.data;

import javax.inject.Inject;
import javax.inject.Singleton;

import cn.jhc.exercise.data.api.StudentApi;
import cn.jhc.exercise.data.model.Student;
import io.realm.Realm;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by CLD1994 on 2016/5/25.
 */

@Singleton
public class DataRepository {

    private final StudentApi mStudentApi;

    private final Realm mRealm;

    private Student mStudent;

    @Inject
    public DataRepository(StudentApi studentApi, Realm realm) {
        mStudentApi = studentApi;
        mRealm = realm;
    }

    public Observable<Student> register(final Student student) {

        return mStudentApi.register(student)
                .subscribeOn(Schedulers.io())
                .map(new Func1<Student, Student>() {
                    @Override
                    public Student call(Student temp) {
                        student.setObjectId(temp.getObjectId());
                        student.setCreatedAt(temp.getCreatedAt());
                        student.setSessionToken(temp.getSessionToken());
                        return student;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<Student, Student>() {
                    @Override
                    public Student call(Student student) {
                        mRealm.beginTransaction();
                        mStudent = mRealm.copyToRealm(student);
                        mRealm.commitTransaction();
                        return mStudent;
                    }
                });
    }

    public Observable<Student> login(String username, String password) {
        return mStudentApi.login(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<Student, Student>() {
                    @Override
                    public Student call(Student student) {
                        mRealm.beginTransaction();
                        mStudent = mRealm.copyToRealmOrUpdate(student);
                        mRealm.commitTransaction();
                        return mStudent;
                    }
                });
    }

}
