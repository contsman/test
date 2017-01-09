package mutilthread.test;

import java.util.Comparator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtc
 * Date: 2016/4/20
 * Time: 15:11
 * To change this template use File | Settings | File Templates.
 */

/***
 * 等待多线程执行完毕之后继续执行主线程
 * 1.子线程中调用latch.countDown(),会将定义的总个数减1.
 * 2.latch.await();直到定义的getCount()等于0的时候主线程才能继续执行，否则一直等待。
 * 3.latch.await(timeout,timeutil);在timeout,时间范围内getCount()不为0一直等待，超过timeout时间范围，则不等待，继续执行主线程
 */
public class CountDownLatchTest {
//    private static CountDownLatch countDownLatch = new CountDownLatch(10);
//
//    public static void main(String[] args) {
//        int i=0;
//        while (countDownLatch.getCount()>0){
//            countDownLatch.countDown();
//            i++;
//            System.out.println("countDownLatch --:"+i);
//        }
//    }
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程1"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程1"+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程2"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(5000);
                    System.out.println("子线程2"+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
//            latch.await(20,TimeUnit.SECONDS);
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
