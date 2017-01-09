package test;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtc
 * Date: 2016/6/15
 * Time: 12:56
 * To change this template use File | Settings | File Templates.
 */
public class TestLoader {
    public String test(String str)
    {
        System.out.println("The String:" + str);
        return str;
    }

    public static void main(String[] args) {
        new TestLoader().test("test");
    }
}
