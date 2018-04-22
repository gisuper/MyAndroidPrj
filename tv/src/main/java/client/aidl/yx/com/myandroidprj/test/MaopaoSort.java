package client.aidl.yx.com.myandroidprj.test;

import android.util.Log;

import java.util.Arrays;

/**
 * Created by yangxiong on 2018/4/21/021.
 */

public class MaopaoSort {

    private static final String TAG ="MaopaoSort" ;
    static int[] arr = {1,4,2,1,22,33,12,12,41,5,11,2,4214,12412,12,2,2};

    public static void sort(){
        Log.d(TAG, "sort: "+ Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] =arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        Log.d(TAG, "sort: "+ Arrays.toString(arr));
    }
}
