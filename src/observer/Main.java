package observer;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello from Observer patter");

        DoubleSubject doubleSubject = new DoubleSubject();

        DoubleObserver doubleObserver = new DoubleObserver(doubleSubject, "1");
        DoubleObserver doubleObserve2 = new DoubleObserver(doubleSubject, "2");
        DoubleObserver doubleObserve3 = new DoubleObserver(doubleSubject, "3");

        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(2);

        executorService.scheduleAtFixedRate(doubleSubject, 1000, 1000, TimeUnit.MILLISECONDS);

        executorService.scheduleAtFixedRate(doubleObserver, 1000, 500, TimeUnit.MILLISECONDS);
        executorService.scheduleAtFixedRate(doubleObserve2, 1000, 2000, TimeUnit.MILLISECONDS);
        executorService.scheduleAtFixedRate(doubleObserve3, 1000, 3000, TimeUnit.MILLISECONDS);

    }
}
