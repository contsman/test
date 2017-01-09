package mutilthread.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtc
 * Date: 2016/4/20
 * Time: 15:32
 * To change this template use File | Settings | File Templates.
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        int num = 5;
        CyclicBarrier barrier = new CyclicBarrier(num, new Runnable() {
            @Override
            public void run() {
                System.out.println("arrive given number....thread start.Thread:"+Thread.currentThread().getName());
            }
        });
        for (int i = 0; i < num; i++) {
            new Worker(barrier).start();
        }
    }
    static class Worker extends Thread{
        CyclicBarrier cyclicBarrier;
        Worker(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
            try {
                Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch(BrokenBarrierException e){
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...Thread:"+Thread.currentThread().getName());
        }
    }
}
