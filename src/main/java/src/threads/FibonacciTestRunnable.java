package src.threads;

/**
 * Created by 16734975 on 30.10.2018.
 */
public class FibonacciTestRunnable implements Runnable {

    private int num;
    private int id;

    public FibonacciTestRunnable(int num) {
        this.num = num;
        this.id = ++num;
    }

    private int fi(int num) {
        if (num <= 1) {
            return 1;
        }

        return fi(num - 1) + fi(num - 2);
    }


    public void run() {
        System.out.println(this.id + "(" + fi(num) + ")");
    }
}
