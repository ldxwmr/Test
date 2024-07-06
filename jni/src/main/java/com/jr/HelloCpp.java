package com.jr;

public class HelloCpp {
    static {
        System.loadLibrary("libhello");
    }
    public native void sayHelloCpp();

    public static void main(String[] args) {
        new HelloCpp().sayHelloCpp();
    }
}
