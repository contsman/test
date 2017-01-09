package test;


import java.io.ByteArrayInputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtc
 * Date: 2016/3/14
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
public class TestMain1 {
    private static Map<Integer,String> test = new HashMap<Integer, String>();
    public static final String TEST = null;

    private static volatile int testvolatile = 0;
    public static void main(String[] args) {
        System.out.println("0x10000===="+0x10000);
        System.out.println("0x10FFFF===="+0x10FFFF);
        char[] test = new char[]{0x0,0x9,0xA,0xD,0x20,0xE000,0xD7FF,0xFFFD};
        for (char item:test){
            System.out.println(item);
        }
        System.out.println(URLEncoder.encode("%EF%BB%BF"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date("2016-06-21 07:13:08"));
        System.out.println(calendar.getTimeInMillis());
//        return ;

//        TEST = "11";
//        FinalTest finalTest = new FinalTest();
//        finalTest.setAaa("aaaaaaa");
//        System.out.println(finalTest.aaa);
//        finalTest.aaa="bbbbb";
//        System.out.println(finalTest.getAaa());
//        HashSet set = new HashSet();
//        set.add("aa");
//        LinkedList list=  new LinkedList();
//        list.add("aa");
//        ArrayList list1 = new ArrayList();
//        list1.add("asdf");
//        Hashtable hashtable = new Hashtable();
//        hashtable.put("a","a");
//        HashMap hashMap = new HashMap();
//        hashMap.put("a", null);
//        hashMap.put(null, "aa");
//        hashMap.put("a", "");
//        hashMap.put("", "ccc");
//        System.out.println(hashMap.get(null));
//        System.out.println(hashMap.get(""));
//        Collections.synchronizedMap(hashMap);
//
//        HashSet hashSet = new HashSet();
//        hashSet.add("aaaa");
//        TreeSet treeSet = new TreeSet();
//        System.out.println(treeSet.add(2));
//        System.out.println(treeSet.add(1));
//        System.out.println(treeSet.add(4));
//        System.out.println(treeSet.add(3));
//        System.out.println(treeSet.add(10));
//        System.out.println(treeSet.add(8));
//        System.out.println(treeSet.add(6));
//        System.out.println(treeSet.add(7));
//        System.out.println(treeSet.add(9));
//        System.out.println(treeSet.first());
//        String aaa = "aaa";
//        System.out.println(aaa.compareTo("bbb"));
//
//        System.out.println(java.lang.Math.round(java.lang.Math.random() * 10));
//        Integer[] mTemporaryMatrix = new Integer[16];
//        for (int i = 0; i < mTemporaryMatrix.length; i++) {
//            mTemporaryMatrix[i]=i;
//        }
//        Integer[] mAccumulatedRotation = new Integer[16];
//        System.arraycopy(mTemporaryMatrix, 0, mAccumulatedRotation, 0, 16);
//        for (int i = 0; i < mAccumulatedRotation.length; i++) {
//            System.out.println(mAccumulatedRotation[i]+"***");
//        }
//
//        System.out.println(15>>2);
//        for (int i = 0; i < 10; i++) {
//            test.put(i,Thread.currentThread().getName()+i);
//        }
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                if(test.size()==0){
//                    System.out.println("map size ==0 *************");
//                }else {
//                    for(Integer integer:test.keySet()){
//                        System.out.println("ThreadName:"+Thread.currentThread().getName()+"[key==="+integer+":value==="+test.get(integer)+"]");
//                    }
//                }
//            }
//        }).start();

//        aaa:{
//
//            for(int i = 0;i<3;i++){
//                System.out.println("i======="+i);
//                    for(int j=0;j<3;j++){
//                        System.out.println("j======="+j);
//                        for(int k=0;k<3;k++){
////                            if(k==2) break aaa;
//                            if(k==2) continue ;
//                            System.out.println("k======="+k);
//                        }
//                    }
//
//            }
//        }

//        System.out.println(mAccumulatedRotation);
//        SortedSet sortedSet =

//        HashMap<Integer,String> hashMap = new HashMap<Integer, String>();
//        hashMap.put(1,"map1");
//        hashMap.put(2,"map2");
//        hashMap.put(3,"map3");
//        hashMap.put(4,"map4");
//        hashMap.put(5,"map5");
//        hashMap.put(6,"map6");
//        hashMap.put(7,"map7");
//        hashMap.put(8,"map8");
//        hashMap.put(9,"map9");
//        hashMap.put(10,"map10");
//        hashMap.put(11,"map11");
//
//        for(Map.Entry entry:hashMap.entrySet()){
//            System.out.println(entry.getKey()+"==="+entry.getValue());
//            try {
//                Thread.currentThread().sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        TestBean testBean = null;
//        Set<TestBean> testSet = new HashSet<TestBean>();
//        ArrayList<TestBean> list = new ArrayList<TestBean>();
//        for (int i = 0; i <10; i++) {
//            testBean = new TestBean(1,"testBean1","11111111");
//            if(list.contains(testBean)) continue;
//            list.add(testBean);
//        }
//        System.out.println(list.size());
//        System.out.println(8%3);
        System.out.println(uniduration("-1"));
        String tpl = "<a href=\"topic?tid={0}&topicname={1}&frm=mfollow\"><span class=\"share\" onclick=\"followToggle(''{2}'',''{3}'',''{4}'');;return false;\"><img src=\"/androidv4/images/addWhite.png\" alt=\"Add Topic\"></span><span class=\"tag caps bgoff\">{5}</span><img src=\"{6}\"></a>";
        System.out.println(MessageFormat.format(tpl, "1", "1".replace("'", "\'"), "1", "1", "1", "1", "1"));
        TreeMap map = new TreeMap();
        map.put("aa","bb");
//        skipListMap.subMap()
        int num = 1500000;
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            hashMap.put(i,i);
        }
        System.out.println("insert "+num+" record to hasmap cost time : "+(System.currentTimeMillis()-start));

        ConcurrentSkipListMap<Integer,Integer> skipListMap = new ConcurrentSkipListMap<Integer,Integer>();
        start = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            skipListMap.put(i,i);
        }
        System.out.println("insert "+num+" record to ConcurrentSkipListMap cost time : "+(System.currentTimeMillis()-start));

        TreeMap<Integer,Integer> treeMap = new TreeMap<Integer, Integer>();
        start = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            treeMap.put(i,i);
        }
        System.out.println("insert "+num+" record to TreeMap cost time : "+(System.currentTimeMillis()-start));
        start = System.currentTimeMillis();
        ConcurrentNavigableMap<Integer,Integer> subMap = skipListMap.subMap(500000,1000000);
        System.out.println("subMap 50W data cost time: "+(System.currentTimeMillis() - start));



        TreeMap<Integer,Integer> tonavigableMap = new TreeMap<Integer, Integer>();
        for (int i = 10; i > 0; i--) {
            tonavigableMap.put(i,i);
        }
        NavigableMap<Integer,Integer> navigableMap = tonavigableMap.descendingMap();
        navigableMap.put(11, 11);
        System.out.println("first key="+navigableMap.firstEntry().getKey()+",first value="+navigableMap.firstEntry().getValue());
        for (Map.Entry entry:tonavigableMap.entrySet()) {
            System.out.println("key=" + entry.getKey() + ",value=" + entry.getValue());
        }
        System.out.println(uniduration("-1"));

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        testvolatile++;
                    }
                }
            }).start();
        }
        try {
            Thread.currentThread().sleep(5000);
            System.out.println("testvolatile==="+testvolatile);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static String uniduration(String dur) {
        if (dur == null || "-1".equals(dur)) return "";
        if (dur.length() == 0) return dur;
        if (dur.indexOf(":") >= 0) {
            if(dur.split(":").length==2){
                StringBuffer buffer = new StringBuffer();
                String[] minSec = dur.split(":");
                String time = minSec[0];
                if (Integer.parseInt(time) < 10) time = "0"+Integer.parseInt(time);
                buffer.append(time);
                buffer.append(":");
                time = minSec[1];
                if (Integer.parseInt(time) < 10) time = "0"+Integer.parseInt(time);
                buffer.append(time);
                return buffer.toString();
            }else{
                return dur;
            }
        }
        try {
            int ts = Integer.parseInt(dur);
            //vulogger.debug("processing dur:" + dur + " ts:" + ts);
            StringBuffer sb = new StringBuffer();
            int h = ts / 3600;
            int m = (ts - h * 3600) / 60;
            int s = (ts - h * 3600 - m * 60);
            if (h > 0) {
                if (h < 10) sb.append("0");
                sb.append(h);
                sb.append(":");
            }
            if (m < 10) sb.append("0");
            sb.append(m);
            sb.append(":");
            if (s < 10) sb.append("0");
            sb.append(s);

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
