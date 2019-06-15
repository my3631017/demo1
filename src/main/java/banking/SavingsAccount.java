package banking;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-06-14 10:32
 */
public class SavingsAccount extends Account {
    public SavingsAccount(Double balance) {
        super(balance);
    }

    @Override
    public Boolean deposit(Double deposit) {
        super.deposit(deposit);
        return true;
    }
}
