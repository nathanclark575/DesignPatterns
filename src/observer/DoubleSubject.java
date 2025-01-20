package observer;

import java.util.concurrent.CopyOnWriteArrayList;

public class DoubleSubject implements Subject<Double>, Runnable {
    final CopyOnWriteArrayList<Observer<Double>> observers;
    private Double message;

    public DoubleSubject() {
        observers = new CopyOnWriteArrayList<>();
        message = 0.0;
    }

    @Override
    public void registerObserver(Observer<Double> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<Double> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer<Double> observer : observers) {
            observer.update(message);
        }
    }

    private void messageHasChanged() {
        notifyObservers();
    }

    public void setMessage(Double message) {
        this.message = message;
        messageHasChanged();
    }

    @Override
    public void run() {
        message++;
        setMessage(message);
    }
}
