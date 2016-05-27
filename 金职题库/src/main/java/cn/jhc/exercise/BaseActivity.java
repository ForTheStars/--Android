package cn.jhc.exercise;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.google.common.base.Preconditions.checkNotNull;
/**
 * Created by CLD1994 on 2016/5/25.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract Integer getLayoutId();

    protected abstract Integer getFragmentContainerId();


    private Unbinder unbinder;

    protected FragmentManager mFragmentManager;
    
    protected MyApplication mApp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        mFragmentManager = getSupportFragmentManager();
        mApp = (MyApplication) getApplication();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbinder.unbind();
    }

    protected void addFragment(BaseFragment fragment){
        checkNotNull(fragment);
        Fragment currentFragment = mFragmentManager.findFragmentById(getFragmentContainerId());
        if (currentFragment == null){
            mFragmentManager.beginTransaction().add(getFragmentContainerId(),fragment).commitAllowingStateLoss();
        }
    }

    protected void replaceFragment(BaseFragment fragment,Boolean needAddToBackStack){

        checkNotNull(fragment);
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(getFragmentContainerId(),fragment);
        if (needAddToBackStack){
            transaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        transaction.commitAllowingStateLoss();
    }

    protected void removeFragment(){
        if (mFragmentManager.getBackStackEntryCount() > 1){
            mFragmentManager.popBackStack();
        }else {
            finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode){
            if (mFragmentManager.getBackStackEntryCount() == 1){
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
