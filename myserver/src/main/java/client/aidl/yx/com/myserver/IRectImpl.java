package client.aidl.yx.com.myserver;

import android.os.RemoteException;

/**
 * Created by yangxiong on 2018/5/11/011.
 */

public class IRectImpl extends IRect.Stub {
    @Override
    public int area(int length, int width) throws RemoteException {
        return 110;
    }

    @Override
    public int perimeter(int length, int width) throws RemoteException {
        return 111;
    }
}
