package cn.jhc.exercise.data.api;

import cn.jhc.exercise.data.model.Student;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by CLD1994 on 2016/5/25.
 * 学生API
 */
public interface StudentApi {

    @GET("1/login")
    Observable<Student> login(@Query("username") String username, @Query("password") String password);

    @POST("1/users")
    Observable<Student> register(@Body Student student);

}
