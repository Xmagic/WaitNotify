public class TestDraw {
    public static void main(String[] args) {
        Account acct = new Account("123456", 0);
        new DrawThread("Son", acct, 800).start();
        new DepositThread("Dad", acct, 800).start();
    }

}
