package client.aidl.yx.com.myandroidprj.base;

import android.app.Application;
import android.content.Context;
import android.nfc.Tag;
import android.util.Log;

/**
 * Created by yangxiong on 2018/4/21/021.
 */

public class GlobalApp extends Application {
    private static final String TAG = "GlobalApp";
    private static Context ApplicationContext;

    public GlobalApp() {
        super( );
        Log.d(TAG, "GlobalApp: ");
    }
    public static Context getAppContext(){
       return ApplicationContext;
    }

    @Override
    public void onCreate() {
        super.onCreate( );
        ApplicationContext = getApplicationContext();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onTerminate() {
        super.onTerminate( );
        Log.d(TAG, "onTerminate: ");
    }
}
