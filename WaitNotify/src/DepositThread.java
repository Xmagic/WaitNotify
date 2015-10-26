import java.util.Random;

public class DepositThread extends Thread {
    private Account account;
    private double depositAmount;

    public DepositThread(String name, Account account, double depositAmount) {
        super(name);
        this.account = account;
        this.depositAmount = depositAmount;
    }

    public void run() {
        while (true) {
            account.deposit(depositAmount);
            sleepRandomTime();
        }
    }

    private void sleepRandomTime() {
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}