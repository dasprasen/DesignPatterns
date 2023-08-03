package com.design.observer.Observer;

import com.design.observer.Observable.StockObservable;

/**
 * @author Prasenjit Kumar Das
 */
public class MobileAlertObserverImpl implements NotificationAlertObserver {

    String username;
    StockObservable observable;

    public MobileAlertObserverImpl(String username, StockObservable observable) {
        this.username = username;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMsgOnMobile(username, "product is in stock");
    }

    private void sendMsgOnMobile(String username, String msg) {
        System.out.println("msg sent to:" + username);
    }
}
