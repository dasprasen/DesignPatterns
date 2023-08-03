package com.design.proxy;

/**
 * @author Prasenjit Kumar Das
 */
public class ProxyPatternExample {
    public static void main(String[] args) throws Exception {
//        DatabaseExecutor nonAdminExecutor = new DatabaseExecutorProxy("NonAdmin", "12345");
//        nonAdminExecutor.executeDatabase("DELETE");

        DatabaseExecutor adminExecutor = new DatabaseExecutorProxy("Admin", "12345");
        adminExecutor.executeDatabase("DELETE");
    }
}
