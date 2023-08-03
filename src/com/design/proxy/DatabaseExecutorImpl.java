package com.design.proxy;

/**
 * @author Prasenjit Kumar Das
 */
public class DatabaseExecutorImpl implements DatabaseExecutor {
    @Override
    public void executeDatabase(String query) throws Exception {
        System.out.println("Going to execute Query: " + query);
    }
}
