package test;

import java.io.File;
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;  
  
public class FileChannelDemo {  
  
    /** 
     * FileChannel是用于读取、写入、映射和操作文件的通道。  
     * 
     *文件通道在其文件中有一个当前 position，可对其进行查询和修改。 
     *该文件本身包含一个可读写的长度可变的字节序列，并且可以查询该文件的当前大小。 
     *写入的字节超出文件的当前大小时，则增加文件的大小；截取 该文件时，则减小文件的大小。 
     * @throws IOException  
     */  
    public static void main(String[] args) throws IOException {  
        File in = new File("D:\\in.txt");
        File out = new File("D:\\out.txt");
        if(in.createNewFile()){  
            System.out.println("in.txt被创建");  
            FileOutputStream is = new FileOutputStream(in);  
            byte[] b = "我一定能行的".getBytes();  
            is.write(b, 0, b.length);  
        }  
        if(out.createNewFile()){  
            System.out.println("out.txt被创建");  
        }  
        FileInputStream is = new FileInputStream(in);  
        FileOutputStream os = new FileOutputStream(out);  
        FileChannel fis = is.getChannel();  
        FileChannel fos = os.getChannel();  
        ByteBuffer bytedata = ByteBuffer.allocate(100);
        while(fis.read(bytedata)!= -1){  
            //通过通道读写交叉进行。  
            bytedata.flip();  
            fos.write(bytedata);  
            bytedata.clear();  
        }  
        fis.close();  
        fos.close();  
        is.close();  
        os.close();  
        }  
} 