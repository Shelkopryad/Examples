package src.threads;

/**
 * Created by 16734975 on 30.10.2018.
 */
public abstract class IntGenerator {

    private volatile boolean canceled = false;
    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }

}
