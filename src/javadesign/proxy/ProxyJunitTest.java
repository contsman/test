package javadesign.proxy;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtc
 * Date: 2016/10/25
 * Time: 11:31
 * To change this template use File | Settings | File Templates.
 */
public class ProxyJunitTest {
    @Test
    public void testProxy(){
        Sourceable proxy = new SourceProxy();
        proxy.method();

        Sourceable sourceable = new Source();
        sourceable.method();
    }
}
