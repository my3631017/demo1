package com.example.demo1.thread;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-01-21 15:45
 */
@Slf4j
public class Depositor extends Thread {
    private Back back;
    private Random random = new Random();
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    private Depositor(String address, Back back) {
        super(address);
        this.back = back;
    }

    @Override
    public void run() {
        while (back.canWithdraw()) {
            Integer money = random.nextInt(10) + 1;
            if (money % 2 == 1) {
                if (back.withdrawMoney(money)) {
                    log.info("{},{},取钱成功,取出:{},余额:{}", dateFormat.format(new Date()), getName(), money, back.balance);
                }
            } else {
                back.saveMoney(money);
                log.info("{},{},存钱成功,存入:{},余额:{}", dateFormat.format(new Date()), getName(), money, back.balance);
            }
//            try {
//                sleep((long) (Math.random() * 1000));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
//        log.info("钱包空空的");
    }

    public void doIt() {
        log.info("-------------");
        run();
    }

    public static void main(String[] args) throws Exception {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        Back back = new Back();
        Depositor depositor1 = new Depositor("春熙路", back);
        Depositor depositor2 = new Depositor("世纪城", back);
        Depositor depositor3 = new Depositor("金融城", back);
        Depositor depositor4 = new Depositor("牛王庙", back);
        Depositor depositor5 = new Depositor("高升桥", back);
        threadPool.submit(depositor1::doIt);
        threadPool.submit(depositor2::doIt);
        threadPool.submit(depositor3::doIt);
        threadPool.submit(depositor4::doIt);
        threadPool.submit(depositor5::doIt);
        threadPool.shutdown();
        log.info("==========================");
//        depositor1.start();
//        depositor2.start();
//        depositor3.start();
//        depositor4.start();
//        depositor5.start();
    }
}
