package concurrentcondition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtc
 * Date: 2016/11/10
 * Time: 14:53
 * To change this template use File | Settings | File Templates.
 */
public class ConditionTest {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    public static void main(String[] args){
//        condition.
        short s1 = 1; s1 = (short)(s1 + 1);//s1 + 1 为 int 类型，必须强转为short
        short s2 = 1; s2 += 1;
        System.out.println(s1 + "," + s2);

        short i = 1;
        int j = s1 + i;
//        short s = s1 + i;
        int c = j+'c';
        System.out.println(c);
//        HashSet set = new HashSet();
//        TreeSet treeSet = new TreeSet();
//        HashMap map = new HashMap();
//        map.put("key", "value");
//        Object object = map.put("key", "valuetest");
//        map.put(null,"value1");
//        System.out.println(object.toString());
//        System.out.println(map.size());
//        System.out.println(map.get("key"));
//        System.out.println(map.get(null));
    }
}
