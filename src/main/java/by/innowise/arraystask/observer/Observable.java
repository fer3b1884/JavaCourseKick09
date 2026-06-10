package by.innowise.arraystask.observer;

import by.innowise.arraystask.exception.ArrayTaskException;

public interface Observable {
    void attachObserver(ArrayObserver arrayObserver) throws ArrayTaskException;
    void detachObserver();
    void notifyObserver();
}
