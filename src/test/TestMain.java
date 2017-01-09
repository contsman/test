package test;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtiecai
 * Date: 2015/12/10
 * Time: 11:52
 * To change this template use File | Settings | File Templates.
 */
public class TestMain {
    public static TestJavaGC testJavaGC = new TestJavaGC();
    static volatile int num = 0;
    static AtomicInteger counter = new AtomicInteger(0);
    public static void main(String[] args) {
        String a = "ab";
        String bb = "b";
        String b = "a"+bb;
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println("testReturn===="+testReturn());
        System.out.println("health & fitness".contains("&"));
        System.out.println(UserHobbyEnum.getHobby("health & fitness".toLowerCase()).getValue()+"===========");
//        System.out.println(uniduration("02:11"));
//        for(int i = 0;i<20;i++){
//            System.out.println("******"+i+"start*******");
////            System.out.println(i%1);
//            System.out.println(i%4);
//            System.out.println("*******"+i+"end******");
//        }
        System.out.println(Integer.parseInt("-1")+"======");
        testJavaGC.testGC();
        testJavaGC = null;
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(testJavaGC!=null){
            testJavaGC.testGC();
        }else{
            System.out.println("object is die.");
        }
        /***
         * class finalize() only call one time
         * Java 类中的finalize只被执行一次，并且在调用GC 垃圾回收之前调用
         */

        testJavaGC = null;
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(testJavaGC!=null){
            testJavaGC.testGC();
        }else{
            System.out.println("object is die.");
        }
//        long startTime = System.currentTimeMillis();
//        boolean flag = true;
//        int num = 0;
//        while (flag){
//                if((System.currentTimeMillis()-startTime)%60000==0){
//                    System.out.println("currently over18Cids.size==================="+num+",all time:"+(System.currentTimeMillis()-startTime));
//                    num++;
//                    if(num==5){
//                        flag = false;
//                    }
//                    try {
//                        Thread.sleep(200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//        }
        ArrayList<String> list = new ArrayList<String>();
        int aaa = 0;
        for (int i = 0; i < 1000; i++) {
            list.add(String.valueOf(i));
            if(list.size()>=100){

                ArrayList<String> other = new ArrayList<String>();
                other.addAll(list);
                list.clear();
                aaa++;
                if(aaa==5){
                    list.addAll(other);
                }
                System.out.println("other list size==" + other.size() + ",other = " + other);
                System.out.println(list);
            }
        }

        ArrayList<Integer> term = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            term.add(Integer.valueOf(i));
        }
        System.out.println(term.size()+"==================");
        System.out.println(term);
        Set<Integer> set = new HashSet<Integer>();
        if(term!=null&&term.size()>9){
            Random random = new Random();
            for(int i = 0;i<term.size();i++){
                set.add(term.get(random.nextInt(term.size())));
                if(set.size()==9){
                    break;
                }
            }
        }
        if(set.size()>0){
            term.clear();
            Iterator<Integer> iterator = set.iterator();
            while(iterator.hasNext()){
                term.add(iterator.next());
            }
        }
        System.out.println(term);
        String[] aac = new String[]{"1","2"};
        System.out.println(Arrays.asList(aac));
        String aa1 =  "aa";
        String bb2 = aa1;
//        bb2 = "aaa";
        aa1 = "aa1";
//        new TestMain().changeValue(aa1);
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        list1.add(9);
        System.out.println(list1.size());
        list1.remove(3);
        System.out.println(list1.size());
        List<Integer> list2 = new ArrayList<Integer>();
        new TestMain().changeValue(list1, list2);
        System.out.println(list2.size());
        System.out.println(aa1+"  "+bb2);
        Set<Integer> backSet = new HashSet<Integer>();
        while(backSet.size()<2){
            System.out.println(backSet.size()+"backSet.size()");
            int c1 = new Random().nextInt(list1.size() - 1);
            backSet.add(list1.get(c1));
        }
        Iterator<Integer> it = backSet.iterator();
        while (it.hasNext()){
            Integer content = it.next();
            System.out.println("it.next().getContentId()==" + content);
        }
        Long l1 = 1l;
        Long l2 = 1l;
        ArrayList<Long> cis = new ArrayList<Long>();
        cis.add(1l);
        TestBean bean = new TestBean();
        bean.setCid("1");
        System.out.println(Long.valueOf(bean.getCid()) == cis.get(0));

        long userRate = Math.abs(NumberUtils.toLong("8208036499", 0)%100);
        System.out.println("userRate==========" + userRate);
        String dd = "aa";
        boolean cccc = true,ddddd = false;
        boolean ccc = (cccc||ddddd);
        List oldHobbies = new ArrayList();
        oldHobbies.addAll(Arrays.asList("2".toString().split(",")));
        int ncount = (int) (System.currentTimeMillis() & 0xffff);
        System.out.println("ncount=="+ncount);

//        String[] newHobby = request.getParameter("hobby").split(",");
//        if ("1".equals(newHobby[1])){
//            if (!oldHobbies.contains(newHobby[0]))
                oldHobbies.add("3");
//        }else{
//            oldHobbies.remove(newHobby[0]);
//        }
        System.out.println(StringUtils.join(oldHobbies.toArray(), ","));
//        System.out.println(TestMain.class.getName());
//        System.out.println("***************"+testReturn());
//        List<String> list = new ArrayList<String>();
//        list.add("a");
//        System.out.println(list.contains("a"));
//        ExecutorService executors = Executors.newFixedThreadPool(4);
//        for (int i = 0; i < 1000000; i++) {
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    num = num+1;
//                    num = num-1;
//                    counter.incrementAndGet();
//                    counter.decrementAndGet();
//                }
//            };
//            executors.execute(runnable);
//        }
//        System.out.println(num);
//        System.out.println(counter.get());
//        executors.shutdown();
//        System.out.println(UserHobbyEnum.COMEBY);
//        System.out.println(UserHobbyEnum.COMEBY.name());
//        System.out.println(UserHobbyEnum.COMEBY.value);
//        System.out.println(UserHobbyEnum.getHobby(2).hobbyname);
//        System.out.println(UserHobbyEnum.getHobby(2).name());
//        System.out.println(UserHobbyEnum.getHobby(2).hobbyname);
//        String[] aa = new String[0];
//        System.out.println(aa.length);
//        UserHobbyEnum[] userHobbyEnums = UserHobbyEnum.values();
//        String[] genres = new String[userHobbyEnums.length-1];
//        for (int i = 1; i < userHobbyEnums.length; i++) {
//            genres[i-1] = String.valueOf(userHobbyEnums[i].value);
//        }
//
//        List<String> list = new ArrayList<String>();
//        list.add("111111111");
//        list.add("22222222222");
//        System.out.println(list.toArray(new String[2]).length+"00000000000000000");
//       for(String genre:genres)
//           System.out.println(genre);
//        String sqlTpl = "(contentId like ''%{0}%'' or language like ''%{1}%'' or vv like ''%{2}%'' or insertDate like ''%{3}%'')";
////        String sqlTpl="''%{0}%'' ''%{1}%'' ''%{2}%'' ''%{3}%''";
//        System.out.println(MessageFormat.format(sqlTpl, "570507628", "570507628", "570507628", "570507628"));
//        Map<Integer,String> map = new HashMap<Integer,String>();
//        map.put(-1,"-1s");
//        map.put(0,"0s");
//        map.put(1,"1s");
//        map.put(2,"2s");
//        System.out.println(map.get("0"));
//        System.out.println("2015-12-25 03:55:54".split("."));
        String str1 = "aa";
        String str2 = "aa";
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
    }
    public static int testReturn(){
        for (int i = 0; i < 10; i++) {
            if(i==5){
                return i;
            }
            System.out.println(i);
        }
        return 0;
    }
    public void changeValue(List<Integer> aa1,List<Integer> aa2){
        for(Integer integer:aa1){
            aa2.add(integer);
        }
    }
    public static String uniduration(String dur) {
        if (dur == null) return "";
        if (dur.length() == 0) return dur;
        if (dur.indexOf(":") >= 0) return dur;
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
