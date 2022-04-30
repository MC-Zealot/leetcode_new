package com.leetcode_4th.others;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 我们提供了一个类：

public class Foo {
  public void one() { print("one"); }
  public void two() { print("two"); }
  public void three() { print("three"); }
}
三个不同的线程将会共用一个 Foo 实例。

线程 A 将会调用 one() 方法
线程 B 将会调用 two() 方法
线程 C 将会调用 three() 方法
请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。

示例 1:

输入: [1,2,3]
输出: "onetwothree"
解释: 
有三个线程会被异步启动。
输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
正确的输出是 "onetwothree"。
示例 2:

输入: [1,3,2]
输出: "onetwothree"
解释: 
输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
正确的输出是 "onetwothree"。
 

注意:

尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。

你看到的输入格式主要是为了确保测试的全面性。
 * @author zealot
 * Created on: Feb 23, 2020 5:48:20 PM
 */
public class PrintinOrder {
	private final AtomicInteger i = new AtomicInteger();
    private final Object lock = new Object();
	public PrintinOrder() {
		 i.set(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
        	while(i.get() != 0) {
        		lock.wait();
        	}
        	// printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            i.set(1);
            lock.notifyAll();
		}
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
        	while(i.get()!=1) {
        		lock.wait();
        	}
        	// printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            i.set(2);
            lock.notifyAll();
		}
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
        	while(i.get()!=2) {
        		lock.wait();
        	}
        	// printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        	i.set(3);
		}
    }
}
