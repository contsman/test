package test;

import java.io.File;
import java.io.FileOutputStream;  
import java.io.IOException;  
  
import org.objectweb.asm.ClassWriter;  
import org.objectweb.asm.MethodVisitor;  
import org.objectweb.asm.Opcodes;

/***
 * ʹ��ASM����ṩ��ClassWriter �ӿڣ�ͨ��������ģʽ���ж�̬����class�ֽ��룬
 */
public class MyGenerator {  
  
    public static void main(String[] args) throws IOException {  
  
        System.out.println();  
        ClassWriter classWriter = new ClassWriter(0);  
        // ͨ��visit����ȷ�����ͷ����Ϣ  
        classWriter.visit(Opcodes.V1_7,// java�汾  
                Opcodes.ACC_PUBLIC,// �����η�  
                "Programmer", // ���ȫ�޶���  
                null, "java/lang/Object", null);  
          
        //�������캯��  
        MethodVisitor mv = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);  
        mv.visitCode();  
        mv.visitVarInsn(Opcodes.ALOAD, 0);  
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>","()V");  
        mv.visitInsn(Opcodes.RETURN);  
        mv.visitMaxs(1, 1);  
        mv.visitEnd();  
          
        // ����code����  
        MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "code", "()V",  
                null, null);  
        methodVisitor.visitCode();  
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out",  
                "Ljava/io/PrintStream;");  
        methodVisitor.visitLdcInsn("I'm a Programmer,Just Coding.....");  
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println",  
                "(Ljava/lang/String;)V");  
        methodVisitor.visitInsn(Opcodes.RETURN);  
        methodVisitor.visitMaxs(2, 2);  
        methodVisitor.visitEnd();  
        classWriter.visitEnd();   
        // ʹclassWriter���Ѿ����  
        // ��classWriterת�����ֽ�����д���ļ�����ȥ  
        byte[] data = classWriter.toByteArray();  
        File file = new File("D://Programmer.class");  
        FileOutputStream fout = new FileOutputStream(file);  
        fout.write(data);  
        fout.close();  
    }  
}  