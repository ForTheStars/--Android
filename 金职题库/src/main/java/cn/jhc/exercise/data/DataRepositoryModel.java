package cn.jhc.exercise.data;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import cn.jhc.exercise.data.api.GlobalApi;
import cn.jhc.exercise.data.api.StudentApi;
import dagger.Module;
import dagger.Provides;
import okhttp3.Authenticator;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CLD1994 on 2016/5/25.
 */

@Module
public final class DataRepositoryModel {

    private static final String baseUrl = "https://api.bmob.cn/";
    private static final String authenticationUrl = "";

    /**
     * 提供一般拦截器,为请求添加请求头信息
     */
    @Provides
    @Singleton
    Interceptor provideInterceptor(){
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
                        .addHeader("Content-type","application/json")
                        .addHeader("X-Bmob-Application-Id", "8845ec4683e05cfa0b5fa77f7a3d1feb")
                        .addHeader("X-Bmob-REST-API-Key", "17f133f2b68a3333945d42b535c75578")
                        .build();
                return chain.proceed(request);
            }
        };
    }

    /**
     * 提供OkHttp客户端,为Retrofit提供支持
     */
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Interceptor interceptor){
        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(interceptor)
                .build();
    }

    /**
     * 提供认证器,为OkHttp提供认证功能
     */
    @Provides
    @Singleton
    Authenticator provideAuthenticator(OkHttpClient okHttpClient){
        return new Authenticator() {
            @Override
            public Request authenticate(Route route, Response response) throws IOException {
                return null;
            }
        };
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Authenticator authenticator){
        OkHttpClient client = okHttpClient.newBuilder().authenticator(authenticator).build();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    GlobalApi provideGlobalApi(Retrofit retrofit){
        return retrofit.create(GlobalApi.class);
    }

    @Provides
    @Singleton
    StudentApi provideStudentApi(Retrofit retrofit){
        return retrofit.create(StudentApi.class);
    }


}
