package com.example.demo1.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-01-21 15:59
 */
@Slf4j
public class Back {
    public Integer balance = 100;
    public Integer store = 0;
    public Integer take = 0;

    public synchronized Boolean withdrawMoney(Integer money) {
        if (balance > money) {
            balance -= money;
            take += money;
            return true;
        } else {
            log.info("余额不足,取钱:{},余额:{}", money, balance);
            return false;
        }
    }

    public synchronized void saveMoney(Integer money) {
        balance += money;
        store += money;
    }

    public Boolean canWithdraw() {
        if (balance <= 10 || balance >= 1000) {
            log.info("存入:{}", store);
            log.info("取出:{}", take);
            log.info("余额:{}", balance);
        }
        return balance > 10 && balance < 1000;
    }
}
