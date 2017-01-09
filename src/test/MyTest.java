package test;

import java.io.File;
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
  
public class MyTest {  
  
    public static void main(String[] args) throws IOException {  
        //????????class?????????????????????????  
        File file = new File("D:\\Programmer.class");
        InputStream  input = new FileInputStream(file);
        byte[] result = new byte[1024];  
          
        int count = input.read(result);  
        // ?????????????????? byte??????????????????class????  
        MyClassLoader loader = new MyClassLoader();  
        Class clazz = loader.defineMyClass( result, 0, count);  
        //?????????????????class ????????  
        System.out.println(clazz.getCanonicalName());  
        //??????Programmer????
        Object o= null;
        try {
            o = clazz.newInstance();
            //????Programmer??code????
            clazz.getMethod("code", null).invoke(o, null);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}  