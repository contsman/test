package test;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtc
 * Date: 2016/3/31
 * Time: 14:33
 * To change this template use File | Settings | File Templates.
 */
public class TestAtomicInteger {
    public static AtomicInteger THREAD_COUNT = new AtomicInteger(0);
    public static final Unsafe unsafe = Unsafe.getUnsafe();
    //    public static volatile int THREAD_COUNT = 0;
    public static int num = 1000;


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<num;i++){
                    THREAD_COUNT.incrementAndGet();
                    THREAD_COUNT.decrementAndGet();
//                    THREAD_COUNT++;
//                    THREAD_COUNT--;
                }
                System.out.println("ThreadName==1"+Thread.currentThread().getName()+",THREAD_COUNT=="+THREAD_COUNT);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<num;i++){
                    THREAD_COUNT.incrementAndGet();
                    THREAD_COUNT.decrementAndGet();
//                    THREAD_COUNT++;
//                    THREAD_COUNT--;
                }
                System.out.println("ThreadName==2"+Thread.currentThread().getName()+",THREAD_COUNT=="+THREAD_COUNT);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<num;i++){
                    THREAD_COUNT.incrementAndGet();
                    THREAD_COUNT.decrementAndGet();
//                    THREAD_COUNT++;
//                    THREAD_COUNT--;
                }
                System.out.println("ThreadName==3"+Thread.currentThread().getName()+",THREAD_COUNT=="+THREAD_COUNT);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<num;i++){
                    THREAD_COUNT.incrementAndGet();
                    THREAD_COUNT.decrementAndGet();
//                    THREAD_COUNT++;
//                    THREAD_COUNT--;
                }
                System.out.println("ThreadName==4"+Thread.currentThread().getName()+",THREAD_COUNT=="+THREAD_COUNT);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<num;i++){
                    THREAD_COUNT.incrementAndGet();
                    THREAD_COUNT.decrementAndGet();
//                    THREAD_COUNT++;
//                    THREAD_COUNT--;
                }
                System.out.println("ThreadName==5"+Thread.currentThread().getName()+",THREAD_COUNT=="+THREAD_COUNT);
            }
        }).start();
    }
}
