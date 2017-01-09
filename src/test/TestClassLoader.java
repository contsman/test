package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtc
 * Date: 2016/6/15
 * Time: 12:44
 * To change this template use File | Settings | File Templates.
 */
public class TestClassLoader {
    public static void main(String[] args) {
        ClassLoader loader = TestClassLoader.class.getClassLoader();
        try {
            Class<?> clazz = loader.loadClass("test.TestLoader");
            Method method = clazz.getMethod("test",String.class);
            Object object = clazz.newInstance();
            Object o = method.invoke(object, "test loader");
            System.out.println(o+"adfadf");
            if (o instanceof String) {
                System.out.println("param:"+o);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (NoSuchMethodException e) {
            e.printStackTrace();
        }catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
