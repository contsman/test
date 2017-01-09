package test;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtiecai
 * Date: 2016/1/11
 * Time: 15:09
 * To change this template use File | Settings | File Templates.
 */
public class TestJavaGC {
    public void testGC(){
        System.out.println("call testgc function......");
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("exec finalize function..............");
        TestMain.testJavaGC = this;
    }
}
