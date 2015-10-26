public class Account {
    private String accountNo;
    private double balance;

    public Account() {
    }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return this.accountNo;
    }

    public double getBalance() {
        return this.balance;
    }

    public synchronized void draw(double drawAmount) {
        try {
            while (balance <= 0) {
                System.out.println("I'm poor, I need more money...");
                wait();
            }
            System.out.println(Thread.currentThread().getName() + " WithDraw:" + drawAmount);
            balance -= drawAmount;
            System.out.println("Balance: " + balance);
            
            notifyAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public synchronized void deposit(double depositAmount) {
        // More money is Good, so no max Amount wait()
        System.out.println(Thread.currentThread().getName() + " Save:" + depositAmount);
        balance += depositAmount;
        System.out.println("Balance: " + balance);
        notifyAll();
    }

    public int hashCode() {
        return accountNo.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == Account.class) {
            Account target = (Account) obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }
}