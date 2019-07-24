package com.idukelu.java.javabase.concurrency;

import org.junit.Test;


public class TestLock {

    class Test01 {

        private int i = 0;

        synchronized public void addI() {
            i++;
            System.err.println(Thread.currentThread().getName()+": "+ i);
            while (true) {
            }
        }

        synchronized public void subtractI() {
            i--;
            System.err.println(Thread.currentThread().getName()+": "+ i);
        }
    }

    /**
     *
     * @throws InterruptedException
     */
    @Test
    public void test() throws InterruptedException {
        Test01 test01 = new Test01();
        Thread thread1 = new Thread(test01::addI, "thread1");
        Thread thread2 = new Thread(test01::subtractI, "thread2");


        thread2.start();
        Thread.sleep(1000);
        thread1.start();

        while (true) {

        }
    }
}
