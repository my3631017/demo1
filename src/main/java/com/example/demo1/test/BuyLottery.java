package com.example.demo1.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-04-08 15:05
 */
public class BuyLottery {

    // 红球开奖池
    private List<Integer> redIds = null;
    // 篮球开奖池
    private List<Integer> blueIds = null;
    // 随机摇号
    private Random random = new Random();

    // 初始化奖池，放入33个红球，16个篮球
    private void init() {
        redIds = new ArrayList<>();
        for (int i = 0; i < 33; ) {
            redIds.add(++i);
        }
        blueIds = new ArrayList<>();
        for (int i = 0; i < 16; ) {
            blueIds.add(++i);
        }
    }

    // 开一次奖
    private void buyOne() {
        init();
        System.out.print("红球:");
        // 摇出6个红球
        for (int i = 0; i < 6; i++) {
            Integer red = redIds.get(random.nextInt(redIds.size()));
            redIds.remove(red);
            System.out.print(red + " ");
        }
        // 摇出一个篮球
        Integer blue = blueIds.get(random.nextInt(blueIds.size()));
        System.out.print("蓝球:" + blue);
        System.out.println();
    }

    // 开n次奖
    private void buyMore(Integer num) {
        for (int i = 0; i < num; i++) {
            buyOne();
        }
    }

    public static void main(String[] args) {
        BuyLottery buyLottery = new BuyLottery();
        buyLottery.buyMore(5);
    }
}
