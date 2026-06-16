package by.shved.arraytask.observer;

import by.shved.arraytask.exception.ArrayTaskException;

public interface Observable {
    void attachObserver(ArrayObserver arrayObserver) throws ArrayTaskException;
    void detachObserver();
    void notifyObserver();
}
