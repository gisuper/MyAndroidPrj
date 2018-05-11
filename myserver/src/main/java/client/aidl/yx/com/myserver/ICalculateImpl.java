package client.aidl.yx.com.myserver;

import android.os.RemoteException;

/**
 * Created by yangxiong on 2018/5/11/011.
 */

public class ICalculateImpl extends ICalculate.Stub {
    @Override
    public int add(int first, int second) throws RemoteException {
        return 1131;
    }

    @Override
    public int sub(int first, int second) throws RemoteException {
        return 1141;
    }
}
