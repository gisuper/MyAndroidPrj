package client.aidl.yx.com.myandroidprj.designpattern.mvp.presenter;

import client.aidl.yx.com.myandroidprj.designpattern.mvp.view.ILoginView;

/**
 * present的实现 实现两个接口 一个是登录接口用于检查用户名和密码 一个是检查结果的回调
 * 根据检查这两个接口去操作UI的显示状态
 * 这一层实现的给UI试图界面传递数据和通知UI更新当前状态
 * Created by yangxiong on 2018/4/22/022.
 */

public class LoginPresenterImp implements ILoginPresenter,ILoginInteractor.OnLoginFinishedListener {

    private ILoginView loginView;
    private ILoginInteractor loginInteractor;

    public LoginPresenterImp(ILoginView loginView, ILoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }
    @Override
    public void checkUser(String username, String password) {
        if (loginView != null){
            loginView.showProgress();
        }

        loginInteractor.login(username,password,this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError() {
        if (loginView != null){
            loginView.setUsernameError();
            loginView.hideProgress();
        }

    }

    @Override
    public void onPasswordError() {
        if (loginView != null){
            loginView.setPasswordError();
            loginView.hideProgress();
        }

    }

    @Override
    public void onSuccess() {
        if (loginView != null)
        loginView.navigateToHome( );
    }
}
