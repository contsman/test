package producterandcustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 公共常量
 * @author 骆昊
 *
 */
class Constants {
    public static final int MAX_BUFFER_SIZE = 10;
    public static final int NUM_OF_PRODUCER = 2;
    public static final int NUM_OF_CONSUMER = 3;
}

/**
 * 工作任务
 * @author 骆昊
 *
 */
class Task {
    private String id;  // 任务的编号

    public Task() {
        id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Task[" + id + "]";
    }
}

/**
 * 消费者
 * @author 骆昊
 *
 */
class Consumer implements Runnable {
    private List<Task> buffer;

    public Consumer(List<Task> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int i = 0;
        long start = System.currentTimeMillis();
        while(true) {
            synchronized(buffer) {
                while(buffer.isEmpty()) {
                    try {
                        buffer.wait();
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Task task = buffer.remove(0);
                buffer.notifyAll();
                System.out.println("Consumer[" + Thread.currentThread().getName() + "] got " + task);
                i++;
                if(i == 10000) {
                    System.out.println("Consumer[" + Thread.currentThread().getName() + "] cost: "+(System.currentTimeMillis()-start));
                    break;
                }
            }
        }
    }
}

/**
 * 生产者
 * @author 骆昊
 *
 */
class Producer implements Runnable {
    private List<Task> buffer;

    public Producer(List<Task> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int i = 0;
        long start = System.currentTimeMillis();
        while(true) {
            synchronized (buffer) {
                while(buffer.size() >= Constants.MAX_BUFFER_SIZE) {
                    try {
                        buffer.wait();
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Task task = new Task();
                buffer.add(task);
                buffer.notifyAll();
                System.out.println("Producer[" + Thread.currentThread().getName() + "] put " + task);
            }
            i++;
            if(i==15000) {
                System.out.println("Producer[" + Thread.currentThread().getName() + "] cost: "+(System.currentTimeMillis() - start));
                break;
            }
        }
    }

}

public class Test06 {

    public static void main(String[] args) {
        List<Task> buffer = new ArrayList<Task>(Constants.MAX_BUFFER_SIZE);
        ExecutorService es = Executors.newFixedThreadPool(Constants.NUM_OF_CONSUMER + Constants.NUM_OF_PRODUCER);
        for(int i = 1; i <= Constants.NUM_OF_PRODUCER; ++i) {
            es.execute(new Producer(buffer));
        }
        for(int i = 1; i <= Constants.NUM_OF_CONSUMER; ++i) {
            es.execute(new Consumer(buffer));
        }
        es.shutdown();
    }
}