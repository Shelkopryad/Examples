package src.threads;

import java.util.concurrent.Callable;

/**
 * Created by 16734975 on 30.10.2018.
 */
public class FibonacciTestCallable implements Callable<Integer> {

    private int num;

    public FibonacciTestCallable(int num) {
        this.num = num;
    }

    private int fi(int num) {
        if (num <= 1) {
            return 1;
        }

        return fi(num - 1) + fi(num - 2);
    }

    public Integer call() throws Exception {
        return fi(num);
    }
}
