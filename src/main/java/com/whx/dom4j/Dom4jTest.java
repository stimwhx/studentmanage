package com.whx.dom4j;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.SAXWriter;
import org.dom4j.io.XMLWriter;
import org.dom4j.tree.DefaultAttribute;
import org.dom4j.tree.DefaultDocument;
import org.dom4j.tree.DefaultElement;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dom4jTest {

    public static void main(String[] args) {
//        read();
        write();
    }

    private static void read() {
        String path = "src\\main\\java\\com\\whx\\dom4j\\book.xml";
        File file = new File(path);
        List<Book> bookList = getBooks(file);
        Iterator<Book> iterator = bookList.iterator(); // TODO: 要与while配合使用！！！！
//       if(iterator.hasNext()){ // TODO: 要与while配合使用！！！！
//           System.out.println(iterator.next());
//       }
        for (Book book : bookList) {
            System.out.println(book);
        }

        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            System.out.println(book);
        }
    }

    private static void write() {
        File file = new File("src/main/java/com/whx/dom4j/user.xml");
        Document doc= new DefaultDocument();
        Element root = new DefaultElement("users");

        for (int i = 0; i < 10; i++) {
            Element user = new DefaultElement("user");
            List<Attribute> attributes = new ArrayList<Attribute>();
            Attribute attribute = new DefaultAttribute("id", (i+1)+"");
            attributes.add(attribute);
            user.setAttributes(attributes);

            Element name = new DefaultElement("name");
            name.setName("name");
            name.setText("whx " + i);
            user.add(name);

            Element sex = new DefaultElement("sex");
            sex.setName("sex");
            sex.setText("女");
            user.add(sex);

            root.add(user);
        }

        doc.add(root);


        try {
            FileWriter fileWriter = new FileWriter(file);
            //用于格式化xml内容和设置头部标签
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter xmlWriter = new XMLWriter(fileWriter, format);
            xmlWriter.write(doc);
            xmlWriter.close();
            System.out.println("生成xml文件的成功");
        } catch (IOException e) {
            System.out.println("生成xml文件失败");
            e.printStackTrace();
        }
    }

    private static List<Book> getBooks(File file) {
        List<Book> bookList =  new ArrayList<Book>();

        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(file);
            Element rootElement = doc.getRootElement();
            String name = rootElement.getName();
            Iterator iterator = rootElement.elementIterator(); // rootElement.elements();
            while (iterator.hasNext()) {
                Book bookResult = new Book();
                Element book = (Element) iterator.next();
                //System.out.println(book);
                String bookName = book.getName();
                List attributes = book.attributes();
               // System.out.println(bookName + ", 遍历属性---");
                for (Object attribute : attributes) {
                    if (attribute instanceof Attribute) {
                        Attribute bookAttr = (Attribute) attribute;
//                        System.out.println(bookAttr);
                        String bookAttrName = bookAttr.getName();
                        int bookAttrId = Integer.parseInt(bookAttr.getValue());
                        bookResult.setId(bookAttrId);
                        System.out.println("Attribute: name " + bookAttrName + " value " + bookAttrId);
                    }
//                    System.out.println(attribute);
                }
                //System.out.println(bookName + ", 遍历子元素---");
                List bookElements = book.elements();

                for (Object element : bookElements) {
                    if (element instanceof Element) {
                        Element child = (Element) element;
                        //System.out.println(child.getName() + ", " + child.getStringValue());
                        if(child.getName().equals("name")){
                            bookResult.setName(child.getStringValue());
                        }else if(child.getName().equals("author")){
                            bookResult.setAuthor(child.getStringValue());
                        }else if(child.getName().equals("price")){
                            bookResult.setPrice(Integer.parseInt(child.getStringValue()));
                        }
                    }
                }
                System.out.println("book");
                bookList.add(bookResult);
            }
//            System.out.println(name);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return bookList;
    }
}
