package javadesign.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtc
 * Date: 2016/10/25
 * Time: 11:29
 * To change this template use File | Settings | File Templates.
 */
public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("original method...");
    }
}
