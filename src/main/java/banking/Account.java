package banking;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-06-14 10:07
 */
public class Account {
    protected Double balance;

    public Account(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public Boolean deposit(Double deposit) {
        this.balance += deposit;
        return true;
    }

    public Boolean withdraw(Double withdraw) {
        if (this.balance >= withdraw) {
            this.balance -= withdraw;
            return true;
        } else {
            return false;
        }
    }
}
