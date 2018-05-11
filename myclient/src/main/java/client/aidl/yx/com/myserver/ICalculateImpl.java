package client.aidl.yx.com.myserver;

import android.os.RemoteException;

import client.aidl.yx.com.myserver.ICalculate;

/**
 * Created by yangxiong on 2018/5/11/011.
 */

public class ICalculateImpl extends ICalculate.Stub {
    @Override
    public int add(int first, int second) throws RemoteException {
        return 0;
    }

    @Override
    public int sub(int first, int second) throws RemoteException {
        return 0;
    }
}
