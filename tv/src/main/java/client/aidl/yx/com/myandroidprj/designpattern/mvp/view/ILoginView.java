package client.aidl.yx.com.myandroidprj.designpattern.mvp.view;

/**
 * Created by yangxiong on 2018/4/22/022.
 */

public interface ILoginView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
}
