package client.aidl.yx.com.myandroidprj.designpattern.mvp.presenter;

import android.text.TextUtils;

/**
 * Created by yangxiong on 2018/4/22/022.
 */

public class LoginInteractorImp implements ILoginInteractor {


    @Override
    public void login(String username, String password, OnLoginFinishedListener listener) {
        if (TextUtils.isEmpty(username)){
            listener.onUsernameError();
            return;
        }
        if (TextUtils.isEmpty(password)){
            listener.onPasswordError();
            return;
        }
        listener.onSuccess();
    }
}
