package v3;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.dom4j.tree.DefaultAttribute;
import org.dom4j.tree.DefaultDocument;
import org.dom4j.tree.DefaultElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestWriter {
    /*public static void main(String[]args){

        writerXML(1);
    }*/
    //studentNumber这个参数，是用来指定创建子元素的个数的
    public static void writerXML(int studentNumber) {
        //写一定要往一个xml里写，所以要有一个文件
        File file = new File("src\\main\\java\\v3\\student2.xml");
        //我们创建一个根元素
        Element rootElement = new DefaultElement("studentList");
        //我们循环为根元素创建多个子元素
        for(int i =0 ;i<studentNumber;i++){
            //每循环一次就为根元素创建了一个子元素
            Element childElement = new DefaultElement("student");
            //为子元素设备属性，一个元素可以包含多了属性。所以setAttribute里要求传入一个list
            //i+1是因为我从0开始的，我想要ID从1开始
            Attribute attribute = new DefaultAttribute("id",""+(i+1));
            List<Attribute> attributeList = new ArrayList<Attribute>();
            attributeList.add(attribute);
            childElement.setAttributes(attributeList);
            //为子元素设备子元素，别放了设备完了要ADD
            //我们知道学生元素下边应该包含的元素，有姓名 ，性别，年龄3个。
            //但是因为有studentNumber个学生，不可能包含的元素都一样，所以我们动态生成一个例用Scanner
            Scanner scanner = new Scanner(System.in);
            for(int t =0;t<studentNumber;t++){
                //为子元素创建3个子元素
                Element childElementChild1 = new DefaultElement("name");
                System.out.println("姓名");
                String str1 = scanner.next();
                childElementChild1.setText(str1);
                Element childElementChild2 = new DefaultElement("sex");
                System.out.println("性别");
                String str2 = scanner.next();
                childElementChild2.setText(str2);
                Element childElementChild3 = new DefaultElement("age");
                System.out.println("年龄");
                String str3 = scanner.next();
                childElementChild3.setText(str3);

                childElement.add(childElementChild1);
                childElement.add(childElementChild2);
                childElement.add(childElementChild3);
            }
            rootElement.add(childElement);
        }
        //我们把写好的元素添加到Document(文档)对象里
        Document document = new DefaultDocument();
        document.add(rootElement);
        try {
            FileWriter fileWriter = new FileWriter(file);
            OutputFormat outputFormat = OutputFormat.createPrettyPrint();
            XMLWriter xmlWriter = new XMLWriter(fileWriter,outputFormat);
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
