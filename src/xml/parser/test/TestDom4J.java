//package xml.parser.test;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.util.Iterator;
//import java.util.List;
//
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;
//import org.dom4j.Node;
//import org.dom4j.io.OutputFormat;
//import org.dom4j.io.SAXReader;
//import org.dom4j.io.XMLWriter;
//
//public class TestDom4J {
//
//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//        buildXmlByDOM4J();
//        paserXmlByDOM4J();
//    }
//    public static void buildXmlByDOM4J(){
//        Document doc=DocumentHelper.createDocument();
//        doc.setXMLEncoding("UTF-8");
//        Element root=doc.addElement("students");
//        root.addAttribute("class", "һ��").addAttribute("count", "3");
//        Element student=root.addElement("student");
//        student.addElement("name").setText("С��");
//        student.addElement("age").setText("10");
//
//        student=root.addElement("student").addAttribute("position", "�೤");
//        student.addElement("name").setText("С��");
//        student.addElement("age").setText("11");
//
//        student=root.addElement("student");
//        student.addElement("name").setText("С��");
//        student.addElement("age").setText("12");
//
//        String xmlStr=doc.asXML();
//        try {
//            OutputFormat format=OutputFormat.createPrettyPrint();
//            XMLWriter writer=new XMLWriter(new FileWriter(new File("students.xml")),format);
//            writer.setEscapeText(false);
//            writer.write(xmlStr);
//            writer.close();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public static void paserXmlByDOM4J(){
//          long begintime=System.currentTimeMillis();
//          SAXReader reader=new SAXReader();
//          try {
//            Document doc=reader.read(new FileInputStream(new File("students.xml")));
//            Element root=doc.getRootElement();
//            System.out.println(root.attributeValue("class")+"--����--"+root.attributeValue("count"));
//    /*      List<Node> list=root.selectNodes("student");//��Ҫ����jaxen-1.1.1.jar
//            for(int i=0,len=list.size();i<len;i++){
//                Node node=(Node)list.get(i);
//                System.out.println(node.selectSingleNode("name").getText()+"---"+node.selectSingleNode("age").getStringValue());
//            }*/
//            Iterator it=root.elementIterator();
//            Element ele;
//            while(it.hasNext()){
//                ele=(Element)it.next();
//                //System.out.println(ele.selectSingleNode("name").getText()+"---"+ele.selectSingleNode("age").getText());
//                System.out.println(ele.elementText("name")+"---"+ele.elementText("age"));
//            }
//          } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
//
//          System.out.println("sax����ʱ��(����)"+(System.currentTimeMillis()-begintime));
//    }
//}