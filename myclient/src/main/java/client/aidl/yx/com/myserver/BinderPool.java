package client.aidl.yx.com.myserver;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by yangxiong on 2018/5/11/011.
 */

public class BinderPool {

    public static final int BINDER_NONE = -1;
    public static final int BINDER_CALCULATE = 0;
    public static final int BINDER_RECT = 1;

    private Context mContext;
    private static IBinderPool mBinderPool;
    private static BinderPool mInstance;
    private CountDownLatch mCountDownLatch;

    private BinderPool(Context context) {
        mContext = context.getApplicationContext();
        connectBinderPoolService();
    }

    public static BinderPool getInstance(Context context){
        if (mBinderPool == null){
            synchronized (BinderPool.class){
                if (mBinderPool == null){
                    mInstance = new BinderPool(context);
                }
            }
        }
        return mInstance;
    }

    private ServiceConnection mBinderPoolConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBinderPool = IBinderPool.Stub.asInterface(service);
            try {
                mBinderPool.asBinder().linkToDeath(mBinderPoolDeathRecipient,0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            mCountDownLatch.countDown();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private IBinder.DeathRecipient mBinderPoolDeathRecipient = new IBinder.DeathRecipient() {
        @Override
        public void binderDied() {
            mBinderPool.asBinder().unlinkToDeath(mBinderPoolDeathRecipient,0);
            mBinderPool = null;
            connectBinderPoolService();
        }
    };

    private synchronized void connectBinderPoolService(){
        mCountDownLatch = new CountDownLatch(1);
        Intent service = new Intent("client.aidl.yx.com.myserver.BINDER_POOL_SERVICE");
        service.setPackage("client.aidl.yx.com.myserver");
        mContext.bindService(service,mBinderPoolConnection,Context.BIND_AUTO_CREATE);


        try {
            mCountDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public IBinder queryBinder(int binderCode){
        IBinder binder = null;
        if (mBinderPool != null){
            try {
                binder = mBinderPool.queryBinder(binderCode);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return binder;
    }

    public static class BinderPoolImpl extends IBinderPool.Stub {

        public BinderPoolImpl(){
            super();
        }
        @Override
        public IBinder queryBinder(int binderCode) throws RemoteException {
            IBinder binder = null;
            switch (binderCode){
                case BINDER_CALCULATE:
                    binder = new ICalculateImpl();
                    break;
                case BINDER_RECT:
                    binder = new IRectImpl();
                    break;
                default:
                    break;
            }
            return binder;
        }
    }

    public static Intent createExplicitFromImplicitIntent(Context context, Intent implicitIntent) {
        // Retrieve all services that can match the given intent
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolveInfo = pm.queryIntentServices(implicitIntent, 0);

        // Make sure only one match was found
        if (resolveInfo == null || resolveInfo.size() != 1) {
            return null;
        }

        // Get component info and create ComponentName
        ResolveInfo serviceInfo = resolveInfo.get(0);
        String packageName = serviceInfo.serviceInfo.packageName;
        String className = serviceInfo.serviceInfo.name;
        ComponentName component = new ComponentName(packageName, className);

        // Create a new intent. Use the old one for extras and such reuse
        Intent explicitIntent = new Intent(implicitIntent);

        // Set the component to be explicit
        explicitIntent.setComponent(component);

        return explicitIntent;
    }
}