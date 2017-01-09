package xml.parser.test;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;  
import org.xml.sax.helpers.DefaultHandler;  
import java.util.Stack;  
public class SAXHandler extends DefaultHandler {  
    Stack tags = null;  
    @Override  
    public void startDocument() throws SAXException {  
        tags=new Stack();  
    }  
  
    @Override  
    public void endDocument() throws SAXException {  
        while(!tags.isEmpty()){  
            System.out.println(tags.peek());  
            tags.pop();  
        }  
        tags=null;  
    }  
  
    @Override  
    public void startElement(String uri, String localName, String qName,  
            Attributes attributes) throws SAXException {  
        if("students".equals(qName)){  
            System.out.println(attributes.getValue("class")+"--人数-"+attributes.getValue("count"));  
        }  
        tags.push(qName);//压入栈  
    }  
  
    @Override  
    public void endElement(String uri, String localName, String qName)  
            throws SAXException {  
        tags.pop();//取出栈顶元素  
    }  
  
    @Override  
    public void characters(char[] ch, int start, int length)  
            throws SAXException {  
        String tag=(String) tags.peek();//查看栈顶元素，但不移除  
        if("name".equals(tag)){  
            System.out.println("name==="+new String(ch,start,length));  
        }  
        if("age".equals(tag)){  
            System.out.println("age==="+new String(ch,start,length));  
        }  
    }  
  
}