package javadesign.classadapter;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtc
 * Date: 2016/10/25
 * Time: 11:08
 * To change this template use File | Settings | File Templates.
 */
public class JunitTest {
    @Test
    public void testAdapter(){
        Adapter adapter = new Adapter();
        adapter.method1();
    }
}
