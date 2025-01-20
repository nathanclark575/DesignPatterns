package observer;

public class DoubleObserver implements Observer<Double>, Runnable {
    final Subject<Double> subject;
    final String name;
    private Boolean hasChanged;
    private Double message;

    public DoubleObserver(Subject<Double> subject, String name) {
        subject.registerObserver(this);
        this.subject = subject;
        this.name = this.getClass().getSimpleName() + "-" + name;
        this.hasChanged = false;
        this.message = null;
    }

    @Override
    public void update(Double message) {
        this.message = message;
        hasChanged();
    }

    private void hasChanged() {
        hasChanged = true;
    }

    @Override
    public void run() {
        if (hasChanged) {
            System.out.println("Message : " + message + " recived by " + name);
        }
    }
}
