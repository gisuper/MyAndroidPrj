package client.aidl.yx.com.myserver;

import android.os.RemoteException;

import client.aidl.yx.com.myserver.IRect;

/**
 * Created by yangxiong on 2018/5/11/011.
 */

public class IRectImpl extends IRect.Stub {
    @Override
    public int area(int length, int width) throws RemoteException {
        return 0;
    }

    @Override
    public int perimeter(int length, int width) throws RemoteException {
        return 0;
    }
}
