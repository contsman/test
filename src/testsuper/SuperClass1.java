package testsuper;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtc
 * Date: 2016/3/25
 * Time: 10:55
 * To change this template use File | Settings | File Templates.
 */
public class SuperClass1 {

    public SuperClass1(){
        System.out.println("superclass1 的构造器");
    }
    public void testFunc(){
        System.out.println("super.testfunc1");
    }
    public void testFunc2(String string){
        System.out.println("super.testfunc2=="+string);
    }
}
