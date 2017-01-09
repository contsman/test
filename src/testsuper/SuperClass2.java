package testsuper;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtc
 * Date: 2016/3/25
 * Time: 10:56
 * To change this template use File | Settings | File Templates.
 */
public class SuperClass2 extends SuperClass1 {
    public SuperClass2(){
        super();
    }
    public static void main(String[] args) {
        new SuperClass2().testSuper();
    }

    private void testSuper(){
        super.testFunc();
        super.testFunc2("aaaa");
    }
}
