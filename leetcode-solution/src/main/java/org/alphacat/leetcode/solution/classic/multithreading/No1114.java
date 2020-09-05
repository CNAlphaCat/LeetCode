package org.alphacat.leetcode.solution.classic.multithreading;

import java.util.concurrent.Semaphore;

public class No1114 {

    class Foo {

        private Semaphore sp_second;
        private Semaphore sp_third;

        public Foo() {
            sp_second = new Semaphore(0);
            sp_third = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            sp_second.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            sp_second.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            sp_third.release();
            sp_second.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            sp_third.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            sp_third.release();
        }
    }

    //这里也可以用Object lock的方法
    class Foo_2 {

        private boolean isFirstFinished;
        private boolean isSecondFinished;

        public Foo_2() {
            isFirstFinished = false;
            isSecondFinished = false;
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            isFirstFinished = true;
            synchronized (this) {
                notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (!isFirstFinished) {
                synchronized (this) {
                    wait();
                }
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            isSecondFinished = true;
            synchronized (this) {
                notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (!isSecondFinished) {
                synchronized (this) {
                    wait();
                }
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();

        }
    }
}
