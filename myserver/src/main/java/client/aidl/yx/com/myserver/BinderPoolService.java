package client.aidl.yx.com.myserver;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import client.aidl.yx.com.myserver.BinderPool;

/**
 * Created by yangxiong on 2018/5/11/011.
 */

public class BinderPoolService extends Service {
    private Binder mBinderPool = new BinderPool.BinderPoolImpl();

    public BinderPoolService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinderPool;
    }

}
