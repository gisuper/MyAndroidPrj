/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: E:\\AndroidPrj\\MyAndroidPrj\\myserver\\src\\main\\aidl\\client\\aidl\\yx\\com\\myserver\\IRect.aidl
 */
package client.aidl.yx.com.myserver;
// Declare any non-default types here with import statements

public interface IRect extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements IRect
{
private static final String DESCRIPTOR = "client.aidl.yx.com.myserver.IRect";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an client.aidl.yx.com.myserver.IRect interface,
 * generating a proxy if needed.
 */
public static IRect asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof IRect))) {
return ((IRect)iin);
}
return new Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_area:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _result = this.area(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_perimeter:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _result = this.perimeter(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements IRect
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public int area(int length, int width) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(length);
_data.writeInt(width);
mRemote.transact(Stub.TRANSACTION_area, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int perimeter(int length, int width) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(length);
_data.writeInt(width);
mRemote.transact(Stub.TRANSACTION_perimeter, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_area = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_perimeter = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
public int area(int length, int width) throws android.os.RemoteException;
public int perimeter(int length, int width) throws android.os.RemoteException;
}
