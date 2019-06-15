package com.example.demo1.thread;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-01-21 15:20
 */
public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    // 有30张票
    private static Integer ticket = 30;

    @Override
    public void run() {
        while (ticket > 0) {
            synchronized ("") {
                System.out.println(getName() + "售票成功,余票:" + --ticket);
            }
//            System.out.println(getName() + "售票成功,余票:" + --ticket);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("票卖完了");
    }

    public static void main(String[] args) {
        MyThread thread1 = new MyThread("窗口1");
        MyThread thread2 = new MyThread("窗口2");
        MyThread thread3 = new MyThread("窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
