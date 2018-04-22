package client.aidl.yx.com.myandroidprj;

import android.app.Application;
import android.test.ApplicationTestCase;

import client.aidl.yx.com.myandroidprj.test.MaopaoSort;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void test(){
        MaopaoSort.sort();
    }

}