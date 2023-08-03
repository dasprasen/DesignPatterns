package com.design.observer;

import com.design.observer.Observable.IphoneObservableImpl;
import com.design.observer.Observable.StockObservable;
import com.design.observer.Observer.EmailAlertObserverImpl;
import com.design.observer.Observer.MobileAlertObserverImpl;
import com.design.observer.Observer.NotificationAlertObserver;

/**
 * @author Prasenjit Kumar Das
 */
public class Store {
    public static void main(String[] args) {
        StockObservable iphoneStockObservable = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("xyz1@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer2= new EmailAlertObserverImpl("xyz2@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("xyz_username", iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.add(observer3);

        iphoneStockObservable.setStockCount(10);
    }
}
