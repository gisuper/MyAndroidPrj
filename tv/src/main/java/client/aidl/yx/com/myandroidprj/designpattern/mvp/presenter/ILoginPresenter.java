package client.aidl.yx.com.myandroidprj.designpattern.mvp.presenter;

/**
 * Created by yangxiong on 2018/4/22/022.
 */

public interface ILoginPresenter {
    void checkUser(String username, String password);

    void onDestroy();
}
