package threadpooltest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtiecai
 * Date: 2016/3/7
 * Time: 9:42
 * To change this template use File | Settings | File Templates.
 */
public class ThreadPoolTestClass {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i = 0;i<4;i++){
            executorService.execute(new Runnable() {
                boolean flag = true;
                int num = 0;
                @Override
                public void run() {
                    while(flag){
                        System.out.println(Thread.currentThread().getName()+",===="+num);
                        try {
                            Thread.currentThread().sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(num==10){
                            flag = false;
                        }
                        System.out.println("cpu===========" + Runtime.getRuntime().availableProcessors());
                        num++;
                    }
                }
            });
        }
        for(int i = 0;i<10;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 50; j++) {
                        System.out.println(Thread.currentThread().getName() + "," + j);
                        System.out.println("cpu===========" + Runtime.getRuntime().availableProcessors());
                    }
                }
            });
        }
        System.out.println("Main Thread Shutting down.....");
        executorService.shutdown();
        System.out.println("Main Thread Shutting down over.....");


        System.out.println(1720235/10);
    }
}
