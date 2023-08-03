package com.design.observer.Observable;

import com.design.observer.Observer.NotificationAlertObserver;

/**
 * @author Prasenjit Kumar Das
 */
public interface StockObservable {

    public void add(NotificationAlertObserver observer);

    public void remove(NotificationAlertObserver observer);

    public void notifySubscribers();

    public void setStockCount(int newStockAdded);

    public int getStockCount();
}
