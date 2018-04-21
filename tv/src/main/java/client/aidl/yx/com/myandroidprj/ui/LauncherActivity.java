package client.aidl.yx.com.myandroidprj.ui;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.lang.ref.WeakReference;

import client.aidl.yx.com.myandroidprj.R;
import client.aidl.yx.com.myandroidprj.base.BaseActivity;

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


    static class MainHandler extends Handler {
        private WeakReference<LauncherActivity> reference;
        private static final String TAG = "MainHandler";

        public MainHandler(LauncherActivity baseActivity) {
            reference = new WeakReference<LauncherActivity>(baseActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (reference.get( ) != null) {
                Log.d(TAG, "handleMessage: msg->" + msg.what);
            } else {
                Log.d(TAG, "handleMessage: Activity is destroy");
            }
        }
    }

}
