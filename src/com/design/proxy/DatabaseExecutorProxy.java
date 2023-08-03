package com.design.proxy;

/**
 * @author Prasenjit Kumar Das
 */
public class DatabaseExecutorProxy implements DatabaseExecutor {
    boolean ifAdmin;
    DatabaseExecutorImpl dbExecutor;

    public DatabaseExecutorProxy(String name, String password) {
        if(name == "Admin" && password == "12345") {
            ifAdmin = true;
            dbExecutor = new DatabaseExecutorImpl();
        }
    }

    @Override
    public void executeDatabase(String query) throws Exception {
        if(ifAdmin) {
            dbExecutor.executeDatabase(query);
        } else {
            if (query.equals("DELETE")) {
                throw new Exception("DELETE not allowed for non-admin user");
            } else {
                dbExecutor.executeDatabase(query);
            }
        }
    }
}
