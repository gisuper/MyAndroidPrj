package client.aidl.yx.com.myandroidprj.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public abstract class BaseActivity extends AppCompatActivity {

    protected String TAG = this.getClass( ).getName( );
    protected Context mAppContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAppContext = GlobalApp.getAppContext( );
        Log.d(TAG, "onCreate: ");
        Log.d(TAG, "mAppContext: " + (mAppContext == null));
        findView( );
        initView( );
        initListener( );
        initData();
    }

    public abstract void initData();

    /**
     * 获取字符串资源
     * @param resId
     * @return
     */
    public String getResString(int resId) {
        return getResources().getString(resId);
    }
    public abstract void findView();

    public abstract void initView();

    public abstract void initListener();


}
