package producterandcustomer;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 公共常量
 * @author 骆昊
 *
 */
class BlockingQueueConstants {
    public static final int MAX_BUFFER_SIZE = 10;
    public static final int NUM_OF_PRODUCER = 2;
    public static final int NUM_OF_CONSUMER = 3;
}

/**
 * 工作任务
 * @author 骆昊
 *
 */
class BlockingQueueTask {
    private String id;  // 任务的编号

    public BlockingQueueTask() {
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
class BlockingQueueConsumer implements Runnable {
    private BlockingQueue<BlockingQueueTask> buffer;

    public BlockingQueueConsumer(BlockingQueue<BlockingQueueTask> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(true) {
            try {
                BlockingQueueTask task = buffer.take();
                System.out.println("Consumer[" + Thread.currentThread().getName() + "] got " + task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 生产者
 * @author 骆昊
 *
 */
class BlockingQueueProducer implements Runnable {
    private BlockingQueue<BlockingQueueTask> buffer;

    public BlockingQueueProducer(BlockingQueue<BlockingQueueTask> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(true) {
            try {
                BlockingQueueTask task = new BlockingQueueTask();
                buffer.put(task);
                System.out.println("Producer[" + Thread.currentThread().getName() + "] put " + task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}

public class Test07 {

    public static void main(String[] args) {
        BlockingQueue<BlockingQueueTask> buffer = new LinkedBlockingQueue<BlockingQueueTask>(BlockingQueueConstants.MAX_BUFFER_SIZE);
        ExecutorService es = Executors.newFixedThreadPool(Constants.NUM_OF_CONSUMER + Constants.NUM_OF_PRODUCER);
        for(int i = 1; i <= Constants.NUM_OF_PRODUCER; ++i) {
            es.execute(new BlockingQueueProducer(buffer));
        }
        for(int i = 1; i <= Constants.NUM_OF_CONSUMER; ++i) {
            es.execute(new BlockingQueueConsumer(buffer));
        }
    }
}