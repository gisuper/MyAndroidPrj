package client.aidl.yx.com.myclientmusic;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import client.aidl.yx.com.myserver.BinderPool;
import client.aidl.yx.com.myserver.ICalculate;
import client.aidl.yx.com.myserver.ICalculateImpl;
import client.aidl.yx.com.myserver.IRect;
import client.aidl.yx.com.myserver.IRectImpl;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";
    private BinderPool mBinderPool;
    private ICalculate mCalculate;
    private IRect mRect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.add_btn).setOnClickListener(this);
        findViewById(R.id.sub_btn).setOnClickListener(this);
        findViewById(R.id.area_btn).setOnClickListener(this);
        findViewById(R.id.per_btn).setOnClickListener(this);
        getBinderPool();
    }

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()){
                case R.id.add_btn:
                    mCalculate = ICalculateImpl.asInterface(mBinderPool.queryBinder(BinderPool.BINDER_CALCULATE));
                    Log.e(TAG,String.valueOf(mCalculate.add(3,2)));
                    Toast.makeText(MainActivity.this,String.valueOf(mCalculate.add(3,2)),Toast.LENGTH_SHORT).show();
                    break;
                case R.id.sub_btn:
                    mCalculate = ICalculateImpl.asInterface(mBinderPool.queryBinder(BinderPool.BINDER_CALCULATE));
                    Log.e(TAG,String.valueOf(mCalculate.sub(3,2)));
                    Toast.makeText(MainActivity.this,String.valueOf(mCalculate.sub(3,2)),Toast.LENGTH_SHORT).show();
                    break;
                case R.id.area_btn:
                    mRect = IRectImpl.asInterface(mBinderPool.queryBinder(BinderPool.BINDER_RECT));
                    Log.e(TAG,String.valueOf(mRect.area(3,2)));
                    Toast.makeText(MainActivity.this,String.valueOf(mRect.area(3,2)),Toast.LENGTH_SHORT).show();
                    break;
                case R.id.per_btn:
                    mRect = IRectImpl.asInterface(mBinderPool.queryBinder(BinderPool.BINDER_RECT));
                    Log.e(TAG,String.valueOf(mRect.perimeter(3,2)));
                    Toast.makeText(MainActivity.this,String.valueOf(mRect.perimeter(3,2)),Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
        }
    };
    private void getBinderPool(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                mBinderPool = BinderPool.getInstance(MainActivity.this);
                mHandler.obtainMessage().sendToTarget();
            }
        }).start();
    }
}
