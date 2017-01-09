package test;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtc
 * Date: 2016/5/6
 * Time: 11:58
 * To change this template use File | Settings | File Templates.
 */
public class TestCodeBlockExecute {
//    String aaa =getStaticStr();
    public TestCodeBlockExecute(){
        System.out.println("TestCodeBlockExecute  gouzao...");
    }
    {
        System.out.println("code block.");
    }
    public static void main(String[] args) {
        new TestCodeBlockExecute().getStaticStr();
        new TestCodeBlockExecute.ExtendClass().getExtendClassStaticStr();
    }
    public String getStaticStr(){

        {
            System.out.println("getStaticStr code block.");
        }
        return "aa";
    }
    static{
        System.out.println("TestCodeBlockExecute static");
    }
    public static class ExtendClass {
        public ExtendClass(){
            System.out.println("ExtendClass  gouzao...");
        }
        public String getExtendClassStaticStr(){

            {
                System.out.println("getExtendClassStaticStr code block.");
            }
            return "aa";
        }
    }
}
