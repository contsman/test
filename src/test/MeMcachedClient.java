package test;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtiecai
 * Date: 2015/12/14
 * Time: 15:24
 * To change this template use File | Settings | File Templates.
 */
public class MeMcachedClient {
    public static void main(String[] args) {
        //64.71.156.230:11211
        String[] server = {"66.160.159.47:11211"};
        //初始化SockIOPool,管理memcached连接池
        SockIOPool pool = SockIOPool.getInstance();
        pool.setServers(server);
        pool.setFailover(true);
        pool.setInitConn(10);
        pool.setMinConn(5);
        pool.setMaxConn(100);
        pool.setMaintSleep(30);
        pool.setNagle(false);
        pool.setSocketTO(3000);
        pool.setAliveCheck(true);
        pool.initialize();

        //建立memcachedclient 对象
        MemCachedClient client = new MemCachedClient();
//        client.set("testmemcachekey","valid");
//        System.out.println(client.get("testmemcachekey"));
        System.out.println(client.get("API_yt_invalid_cid_bcFaPo3Q93I"));
    }
}
