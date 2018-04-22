package client.aidl.yx.com.myandroidprj.designpattern.mvp.presenter;

/**
 * Created by yangxiong on 2018/4/22/022.
 */

public interface ILoginInteractor {

    interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess();
    }

    void login(String username, String password, OnLoginFinishedListener listener);

}