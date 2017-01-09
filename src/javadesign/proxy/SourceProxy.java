package javadesign.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtc
 * Date: 2016/10/25
 * Time: 11:30
 * To change this template use File | Settings | File Templates.
 */
public class SourceProxy implements Sourceable {
    private Source source;

    public SourceProxy(){
        super();
        this.source = new Source();
    }

    @Override
    public void method() {
        before();
        source.method();
        after();
    }

    private void after() {
        System.out.println("after proxy!");
    }
    private void before() {
        System.out.println("before proxy!");
    }
}
