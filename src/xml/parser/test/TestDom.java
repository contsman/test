package xml.parser.test;

import java.io.File;
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.util.Calendar;  
import java.util.Locale;  
import java.util.TimeZone;  
  
import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.ParserConfigurationException;  
import javax.xml.parsers.SAXParser;  
import javax.xml.parsers.SAXParserFactory;  
import javax.xml.transform.Result;  
import javax.xml.transform.Transformer;  
import javax.xml.transform.TransformerConfigurationException;  
import javax.xml.transform.TransformerException;  
import javax.xml.transform.TransformerFactory;  
import javax.xml.transform.dom.DOMSource;  
import javax.xml.transform.stream.StreamResult;  
  
import org.w3c.dom.DOMException;  
import org.w3c.dom.Document;  
import org.w3c.dom.Element;  
import org.w3c.dom.Node;  
import org.w3c.dom.NodeList;  
import org.xml.sax.SAXException;  
  
/** 
 * java自带的dom解析xml文件 
 *  
 * @author abc 
 *  
 */  
public class TestDom {  
    public static void main(String[] args) {  
        builXmlByDom();
        parseXmlByDom();  
    }  
    /** 
     * 生成xml信息 
     */  
    public static void builXmlByDom() {  
        long begintime = System.currentTimeMillis();  
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
        try {  
            //构建Document  
            DocumentBuilder db = dbf.newDocumentBuilder();  
            Document doc=db.newDocument();  
            Element root=doc.createElement("students");  
            root.setAttribute("class", "一班");  
            root.setAttribute("count", "3");  
              
            Element stu=doc.createElement("student");  
            Element name=doc.createElement("name");  
            name.appendChild(doc.createTextNode("小明"));  
            Element age=doc.createElement("age");  
            age.appendChild(doc.createTextNode("10"));  
            stu.appendChild(name);  
            stu.appendChild(age);  
            root.appendChild(stu);  
              
              
             stu=doc.createElement("student");  
             stu.setAttribute("position","班长");  
             name=doc.createElement("name");  
             name.appendChild(doc.createTextNode("小王"));  
             age=doc.createElement("age");  
             age.appendChild(doc.createTextNode("11"));  
             stu.appendChild(name);  
             stu.appendChild(age);  
             root.appendChild(stu);  
  
             stu=doc.createElement("student");  
             name=doc.createElement("name");  
             name.appendChild(doc.createTextNode("小兵"));  
             age=doc.createElement("age");  
             age.appendChild(doc.createTextNode("12"));  
             stu.appendChild(name);  
             stu.appendChild(age);  
             root.appendChild(stu);  
               
             doc.appendChild(root);  
             //将被变换的Document对象封装到一个DOMSource对象中  
             DOMSource xmlSource=new DOMSource(doc);  
             //使用 Transformer对象将一个Document节点变换为一个XML文件  
             TransformerFactory transFactory=TransformerFactory. newInstance();  
             Transformer transformer=transFactory.newTransformer();  
               
             //创建Result  
             File file=new File("d:/students.xml");
             FileOutputStream fos;  
             fos = new FileOutputStream(file);  
             StreamResult result=new StreamResult(fos);  
             transformer.transform(xmlSource, result);  
             if(fos!=null){  
                 fos.close();  
             }  
        }catch (ParserConfigurationException e) {  
            e.printStackTrace();  
        }catch (TransformerConfigurationException e) {  
            e.printStackTrace();  
        }catch (FileNotFoundException e) {  
            e.printStackTrace();  
        }catch (TransformerException e) {  
            e.printStackTrace();  
        }catch (IOException e) {  
            e.printStackTrace();  
        }    
        System.out.println("dom生成时间(毫秒)"  
                + (System.currentTimeMillis() - begintime));  
    }  
    /** 
     * 解析xml信息 
     */  
    public static void parseXmlByDom() {  
        long begintime = System.currentTimeMillis();;  
        try {  
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();  
            DocumentBuilder builder=dbf.newDocumentBuilder();  
            File file=new File("d:/students.xml");
            Document doc=builder.parse(file);  
            NodeList students=doc.getFirstChild().getChildNodes();  
            Node student=null;  
            Node node=null;  
            for(int i=0,len=students.getLength();i<len;i++){  
                student=students.item(i);  
                NodeList childs=student.getChildNodes();  
                System.out.println("第"+(i+1)+"个学生");  
                for(int j=0,size=childs.getLength();j<size;j++){  
                    node=childs.item(j);  
                    if("name".equals(node.getNodeName())){  
                        System.out.println(node.getNodeName()+"---"+node.getTextContent());  
                    }  
                    if("age".equals(node.getNodeName())){  
                        System.out.println(node.getNodeName()+"---"+node.getTextContent());  
                    }  
                }  
            }  
        } catch (DOMException e) {  
            e.printStackTrace();  
        } catch (ParserConfigurationException e) {  
            e.printStackTrace();  
        } catch (SAXException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        System.out.println("dom解析时间(毫秒)"  
                + (System.currentTimeMillis() - begintime));  
    }  
}  