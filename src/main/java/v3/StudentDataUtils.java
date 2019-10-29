package v3;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.dom4j.tree.DefaultAttribute;
import org.dom4j.tree.DefaultDocument;
import org.dom4j.tree.DefaultElement;
import v2.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDataUtils {

    private static List<Student> students = new ArrayList<Student>();
    public static void getStudentsByFile(String pathFile){

    }
    public static List<Student> getStudents() {
        return TestReader.reader();
    }

    //从xml文件中把数据读到程序里来
    public static List<Student> rederStu(String pathFile){

        return TestReader.reader();

    }
    //向文件中保存数据.为添加使用的
    public static void saveStu(Student student) {
        File file = new File("src\\main\\java\\v3\\student.xml");
        Document document = new DefaultDocument();
        Element studentListElement = new DefaultElement("studentList");
        Element studentelement = new DefaultElement("student");
        Element elementName = new DefaultElement("name");
        elementName.setText(student.getStuName());
        Element elementAge=new DefaultElement("age");
        elementAge.setText(student.getAge()+"");
        Element elementSex = new DefaultElement("sex");
        elementSex.setText(student.getSex());
        studentelement.add(elementName);
        studentelement.add(elementAge);
        studentelement.add(elementSex);
        studentListElement.add(studentelement);
        Attribute attribute = new DefaultAttribute("id",student.getId()+"");
        List<Attribute> attributeList = new ArrayList<Attribute>();
        attributeList.add(attribute);

        studentelement.setAttributes(attributeList);
        document.add(studentListElement);
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


    //修改后向文件中从新保存数据
    public static void saveList(List<Student> students1)  {
        //把文件内容清空，重新保存一次Students列表里的内容
        File file = new File("src\\main\\java\\v3\\student.xml");
        Element studentListElement = new DefaultElement("studentList");
        Document document = new DefaultDocument();
        for(int i =0;i<students1.size();i++){
            Student student = students1.get(i);
            Element studentelement = new DefaultElement("student");
            Element elementName = new DefaultElement("name");
            elementName.setText(student.getStuName());
            Element elementAge=new DefaultElement("age");
            elementAge.setText(student.getAge()+"");
            Element elementSex = new DefaultElement("sex");
            elementSex.setText(student.getSex());
            studentelement.add(elementName);
            studentelement.add(elementAge);
            studentelement.add(elementSex);
            studentListElement.add(studentelement);
            Attribute attribute = new DefaultAttribute("id",student.getId()+"");
            List<Attribute> attributeList = new ArrayList<Attribute>();
            attributeList.add(attribute);

            studentelement.setAttributes(attributeList);
        }
        document.add(studentListElement);
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
