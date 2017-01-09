package test;

import javassist.ClassPool;
import javassist.CtClass;  
import javassist.CtMethod;  
import javassist.CtNewMethod;

/***
 * Javassist��һ����Դ�ķ������༭�ʹ���Java�ֽ������⡣
 * ���ɶ�����ҵ��ѧ����ѧ�ͼ������ѧϵ�� Shigeru Chiba ��ǧҶ �̣��������ġ�
 * ���Ѽ����˿���Դ����JBoss Ӧ�÷�������Ŀ,ͨ��ʹ��Javassist���ֽ������ΪJBossʵ�ֶ�̬AOP��ܡ�
 * javassist��jboss��һ������Ŀ������Ҫ���ŵ㣬���ڼ򵥣����ҿ��١�ֱ��ʹ��java�������ʽ��������Ҫ�˽������ָ�
 *     ���ܶ�̬�ı���Ľṹ�����߶�̬�����ࡣ
 */
public class MyGeneratorWithJavassist {  
  
    public static void main(String[] args) throws Exception {  
        ClassPool pool = ClassPool.getDefault();  
        //����Programmer��       
        CtClass cc= pool.makeClass("ProgrammerWithJavassist");
        //����code����  
        CtMethod method = CtNewMethod.make("public void code(){}", cc);  
        //���뷽������  
        method.insertBefore("System.out.println(\"I'm a Programmer,Just Coding.....\");");  
        cc.addMethod(method);  
        //�������ɵ��ֽ���  
        cc.writeFile("d://temp");  
    }  
}  