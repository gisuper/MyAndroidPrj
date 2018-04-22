package client.aidl.yx.com.myandroidprj.designpattern.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import client.aidl.yx.com.myandroidprj.R;
import client.aidl.yx.com.myandroidprj.base.BaseActivity;
import client.aidl.yx.com.myandroidprj.designpattern.mvp.presenter.ILoginPresenter;
import client.aidl.yx.com.myandroidprj.designpattern.mvp.presenter.LoginInteractorImp;
import client.aidl.yx.com.myandroidprj.designpattern.mvp.presenter.LoginPresenterImp;

public class LoginActivity extends BaseActivity implements ILoginView,View.OnClickListener{

    private ILoginPresenter presenter;
    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initData() {
        presenter = new LoginPresenterImp(this,new LoginInteractorImp());
    }

    @Override
    public void findView() {
        setContentView(R.layout.activity_login);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy( );
        presenter.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {
        //startActivity(new Intent(this, MainActivity.class));
        Toast.makeText(this, "startActivity(new Intent(this, MainActivity.class))", Toast.LENGTH_SHORT).show( );
       // finish();
    }

    @Override
    public void onClick(View v) {
        presenter.checkUser(username.getText().toString(), password.getText().toString());
    }
}
