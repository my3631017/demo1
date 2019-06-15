package banking;

import java.util.ArrayList;
import java.util.List;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-06-14 10:46
 */
public class Bank {
    private List<Customer> customerList;
    private Integer numberOfCustomers;

    public Bank() {
        Integer numberOfCustomers = 200;
        this.customerList = new ArrayList<>(numberOfCustomers);
        this.numberOfCustomers = numberOfCustomers;
    }

    public void addCustomer(String f, String l) {
        Customer customer = new Customer(f, l);
        customerList.add(customer);
        this.numberOfCustomers += 1;
    }

    public Integer getNumOfCustomers() {
        return numberOfCustomers;
    }

    public Customer getCustomer(Integer index) {
        return this.customerList.get(index);
    }
}
