// ICalculate.aidl
package client.aidl.yx.com.myserver;

// Declare any non-default types here with import statements

interface ICalculate {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    int add(int first, int second);
        int sub(int first, int second);
}
