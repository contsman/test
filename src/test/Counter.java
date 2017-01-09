package test;

import java.util.concurrent.CountDownLatch;

public class Counter {
 
    public volatile static int count = 0;
 
    public static void inc(CountDownLatch latch) {
 
        //这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
 
        count++;
        latch.countDown();
    }
 
    public static void main(String[] args) throws Exception{
        int count = 1000;
        //同时启动1000个线程，去进行i++计算，看看实际结果
        final CountDownLatch latch=new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Counter.inc(latch);
                }
            }).start();
        }
        latch.await();
        //这里每次运行的值都有可能不同,可能为1000
        System.out.println("运行结果:Counter.count=" + Counter.count);
    }
}