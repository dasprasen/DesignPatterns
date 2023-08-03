package com.design.observer.Observer;

import com.design.observer.Observable.StockObservable;

/**
 * @author Prasenjit Kumar Das
 */
public class EmailAlertObserverImpl implements NotificationAlertObserver {

    String emailId;
    StockObservable observable;

    public EmailAlertObserverImpl(String emailId, StockObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendEmail(emailId, "product is in stock..");
    }

    private void sendEmail(String emailId, String msg) {
        System.out.println("mail sent to:" + emailId);
    }
}
