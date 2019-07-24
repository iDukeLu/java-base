package com.idukelu.java.javabase.concurrency;

import org.junit.Test;

/**
 * 实例变量会出现非线程安全，局部变量不会出现非线程安全
 */
public class ThreadSecurity {

    class Blank {

        private int money = 0; // 实例变量

        public void withdrawMoneyByInstance(String user) {
            try {
                if (user.equals("tom")) {
                    money = 100;

                    Thread.sleep(1000);

                } else {
                    money = 200;
                }
                System.err.println(user + ": " + money);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void withdrawMoneyByLocal(String user) {
            int money = 0; // 局部变量
            try {
                if (user.equals("tom")) {
                    money = 100;

                    Thread.sleep(1000);

                } else {
                    money = 200;
                }
                System.err.println(user + ": " + money);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 实例变量线程不安全
     * @throws InterruptedException
     */
    @Test
    public void testThreadSecurityByInstanceVariable() throws InterruptedException {

        Blank blank = new Blank();

        Thread thread1 = new Thread(() -> {
            blank.withdrawMoneyByInstance("tom");
        });

        Thread thread2 = new Thread(() -> {
            blank.withdrawMoneyByInstance("jack");
        });

        thread1.start();
        thread2.start();

        Thread.sleep(3000);

    }

    /**
     * 实例变量线程安全
     * @throws InterruptedException
     */
    @Test
    public void testThreadSecurityLocalVariable() throws InterruptedException {
        Blank blank = new Blank();

        Thread thread1 = new Thread(() -> {
            blank.withdrawMoneyByLocal("tom");
        });

        Thread thread2 = new Thread(() -> {
            blank.withdrawMoneyByLocal("jack");
        });

        thread1.start();
        thread2.start();

        Thread.sleep(3000);
    }


}
