package test;

/**
 * �Զ���һ��������������ڽ��ֽ���ת��Ϊclass���� 
 * @author louluan 
 */  
public class MyClassLoader extends ClassLoader {  
  
    public Class<?> defineMyClass( byte[] b, int off, int len)   
    {  
        return super.defineClass(b, off, len);  
    }  
      
}  