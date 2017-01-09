//package xml.parser.test;
//
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.List;
//
//import org.jdom.Document;
//import org.jdom.Element;
//import org.jdom.JDOMException;
//import org.jdom.input.SAXBuilder;
//import org.jdom.output.XMLOutputter;
//
//public class TestJDOM {
//
//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//        buildXmlByJDOM();
//        parseXmlByJDOM();
//    }
//
//    public static String buildXmlByJDOM(){
//        Document doc=new Document();
//        Element root=new Element("students");
//        root.setAttribute("count", "3");
//        root.setAttribute("class", "一班");
//        doc.setRootElement(root);
//        root.addContent(new Element("student").addContent(new Element("name").setText("小明"))
//                .addContent(new Element("age").setText("10")));
//        root.addContent(new Element("student").addContent(new Element("name").setText("小汪"))
//                .addContent(new Element("age").setText("11")));
//        root.addContent(new Element("student").addContent(new Element("name").setText("小兵"))
//                .addContent(new Element("age").setText("12")));
//        ByteArrayOutputStream out=new ByteArrayOutputStream();
//        XMLOutputter putter=new XMLOutputter();
//        try {
//            putter.output(doc, out);
//            putter.output(doc, new FileOutputStream("students.xml"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return out.toString();
//    }
//   public static void parseXmlByJDOM(){
//       long begintime=System.currentTimeMillis();
//       File f=new File("students.xml");
//       SAXBuilder builder=new SAXBuilder();
//       try {
//        Document doc=builder.build(new FileInputStream(f));
//        Element root=doc.getRootElement();
//        System.out.println(root.getAttributeValue("class")+"-人数：--"+root.getAttributeValue("count"));
//
//        List list=root.getChildren("student");
//        for(int i=0;i<list.size();i++){
//            Element ele=(Element)list.get(i);
//            System.out.println("第"+(i+1)+"个学生");
//            System.out.println(ele.getChildText("name")+"---"+ele.getChildText("age"));
//        }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (JDOMException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("sax解析时间(毫秒)"+(System.currentTimeMillis()-begintime));
//   }
//}