package test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtiecai
 * Date: 2015/12/10
 * Time: 15:35
 * To change this template use File | Settings | File Templates.
 */
public class MyMap implements Map {
    static Map map = new HashMap(-1,0.7f);
    @Override
    public int size() {
        map.containsKey("aaa");
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }

    public static void main(String[] args) {
        int capacity = 1;
        while (capacity < 7)
            capacity <<= 1;
        System.out.println(capacity);
    }
}
