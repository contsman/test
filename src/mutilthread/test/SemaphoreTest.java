package mutilthread.test;

import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtc
 * Date: 2016/4/20
 * Time: 16:10
 * To change this template use File | Settings | File Templates.
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        int N = 8;            //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目
        for(int i=0;i<N;i++)
            new Worker(i,semaphore).start();
    }

    static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;
        public Worker(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人" + this.num + "占用一个机器在生产...");
                Thread.sleep(3000);
                System.out.println("工人" + this.num + "释放出机器");
                semaphore.release();
                System.out.println("availablePermits : "+semaphore.availablePermits());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
