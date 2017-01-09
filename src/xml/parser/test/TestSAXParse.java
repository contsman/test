package xml.parser.test;

import java.io.File;
  
import javax.xml.parsers.SAXParser;  
import javax.xml.parsers.SAXParserFactory;  
  
public class TestSAXParse {  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        sax();  
    }  
  
    public static void sax() {  
        long begintime = System.currentTimeMillis();  
        File f = new File("D:/students.xml");
        SAXParserFactory sf = SAXParserFactory.newInstance();  
        try {  
            SAXParser sp = sf.newSAXParser();  
            SAXHandler handler = new SAXHandler();  
            sp.parse(f, handler);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        System.out.println("sax解析时间(毫秒)"  
                + (System.currentTimeMillis() - begintime));  
  
    }  
}  