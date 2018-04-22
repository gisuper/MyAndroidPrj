package client.aidl.yx.com.myandroidprj.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.lang.ref.WeakReference;

import client.aidl.yx.com.myandroidprj.R;
import client.aidl.yx.com.myandroidprj.base.BaseActivity;
import client.aidl.yx.com.myandroidprj.designpattern.mvp.view.LoginActivity;

public class LauncherActivity extends BaseActivity {

    private MainHandler mMainHandler;


    @Override
    public void findView() {
        Log.d(TAG, "findView: ");
    }

    @Override
    public void initView() {
        Log.d(TAG, "initView: ");
    }

    @Override
    public void initListener() {
        Log.d(TAG, "initListener: ");
    }

    @Override
    public void initData() {
        Log.d(TAG, "initData: ");
        mMainHandler = new MainHandler(this);
        mMainHandler.sendEmptyMessageDelayed(1000,3000);
    }


    static class MainHandler extends Handler {
        private WeakReference<LauncherActivity> reference;
        private static final String TAG = "MainHandler";

        public MainHandler(LauncherActivity baseActivity) {
            reference = new WeakReference<LauncherActivity>(baseActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            LauncherActivity activity = reference.get( );
            if (activity != null) {
                Log.d(TAG, "handleMessage: msg->" + msg.what);
                if (msg.what == 1000){
                    activity.startActivity(new Intent(activity, LoginActivity.class));
                }
            } else {
                Log.d(TAG, "handleMessage: Activity is destroy");
            }
        }
    }

}
