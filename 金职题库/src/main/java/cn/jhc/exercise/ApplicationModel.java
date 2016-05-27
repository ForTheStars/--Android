package cn.jhc.exercise;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

/**
 * Created by CLD1994 on 2016/5/25.
 * 提供应用上下文
 */

@Module
public final class ApplicationModel {

    private final Context mContext;

    public ApplicationModel(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }

    @Provides
    @Singleton
    SharedPreferences providePreferences(){
        return PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    @Provides
    @Singleton
    RealmMigration provideRealmMigration(){
        return new RealmMigration() {
            @Override
            public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
                RealmSchema schema = realm.getSchema();
            }
        };
    }

    @Provides
    @Singleton
    RealmConfiguration provideRealmConfiguration(){
        return new RealmConfiguration.Builder(mContext)
                .name("exercise.realm")
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
    }

    @Provides
    @Singleton
    Realm provideRealm(RealmConfiguration configuration){
        return Realm.getInstance(configuration);
    }

}
