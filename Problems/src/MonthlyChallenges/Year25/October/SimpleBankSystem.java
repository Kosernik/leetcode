package MonthlyChallenges.Year25.October;

public class SimpleBankSystem {

    /**
     * LeetCode №2043. Simple Bank System.
     */
    class Bank {
        private final long[] balance;

        public Bank(long[] balance) {
            this.balance = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            int idx1 = account1 - 1, idx2 = account2 - 1;

            if (isAccountIdxInvalid(idx1) || isAccountIdxInvalid(idx2)) return false;

            if (balance[idx1] < money) return false;

            balance[idx1] -= money;
            balance[idx2] += money;

            return true;
        }

        public boolean deposit(int account, long money) {
            int idx = account - 1;

            if (isAccountIdxInvalid(idx)) return false;

            balance[idx] += money;

            return true;
        }

        public boolean withdraw(int account, long money) {
            int idx = account - 1;

            if (isAccountIdxInvalid(idx)) return false;

            if (balance[idx] < money) return false;

            balance[idx] -= money;

            return true;
        }

        private boolean isAccountIdxInvalid(int accountIdx) {
            return accountIdx < 0 || accountIdx >= balance.length;
        }
    }
}
