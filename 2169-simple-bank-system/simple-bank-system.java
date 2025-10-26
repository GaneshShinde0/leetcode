class Bank {

    private long[] balance;
    private int n;

    public Bank(long[] balance) {
        this.n = balance.length + 1;
        this.balance = new long[this.n];
        for (int i = 0; i < balance.length; i++) {
            this.balance[i + 1] = balance[i];
        }
        // System.out.println(Arrays.toString(this.balance));
    }

    public boolean transfer(int account1, int account2, long money) {
        // System.out.println(Arrays.toString(this.balance));
        if (account1 <= this.n && account2 <= this.n && account1 > 0 && account2 > 0
                && this.balance[account1] >= money) {
            this.balance[account1] -= money;
            this.balance[account2] += money;
            // System.out.println(Arrays.toString(this.balance));
            return true;
        } else {
            return false;
        }
    }

    public boolean deposit(int account, long money) {
        if (account > 0 && account <= this.n) {
            this.balance[account] += money;
            // System.out.println(Arrays.toString(this.balance));
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        if (account > 0 && account <= n && this.balance[account] >= money) {
            this.balance[account] -= money;
            // System.out.println(Arrays.toString(this.balance));
            return true;
        }
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */