package fanxing;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtc
 * Date: 2016/10/25
 * Time: 17:14
 * To change this template use File | Settings | File Templates.
 */
public class FxJunitTest {
    @Test
    public void test(){
        FanXing<String> fanXing = new FanXing<String>();
        fanXing.setT("asdfasdf");
        fanXing.print();
    }
}
