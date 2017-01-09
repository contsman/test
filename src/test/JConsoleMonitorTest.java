package test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtc
 * Date: 2016/9/7
 * Time: 10:47
 * To change this template use File | Settings | File Templates.
 */
public class JConsoleMonitorTest {
    private BlockingQueue queue;
    private Executor executor;
    public void run() {
        while(true){
            try {
                Object sendMsg = queue.poll();//从队列中取出
//                Object sendMsg = queue.take();//从队列中取出
                if(null != sendMsg) {
                    System.out.println(sendMsg.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
