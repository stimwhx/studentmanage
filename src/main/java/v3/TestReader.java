package v3;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import v2.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestReader {
   /* public static void main(String [] args){
        List<Student> re = TestReader.reader();
        Iterator iterator = re.iterator();
        while(iterator.hasNext()){
            Student student = (Student) iterator.next();
            System.out.println(student.toString()
            );
        }

    }*/
    public   static List<Student> reader(){
        //要读一定有一个文件是你要读入的
        File file = new File("src\\main\\java\\v3\\student.xml");//相对路径
        //用什么读，用SAXReader读取
        SAXReader saxReader = new SAXReader();
        List<Student> studentList = new ArrayList<Student>();
        //用什么取出文件中的元素，用的是Document.将使用SAXReader从文件中读取到的数据都放在Document里
        //我们好对元素，属性做处理
        try {
            Document document = saxReader.read(file);
            //我们从document中取出根元素
            Element rootElement=document.getRootElement();
            //这个根元素包括很多子元素，可以看成一个列表。然后我们去遍历这个列表
            List<Element> elementList = rootElement.elements();
            //列表的遍历一般都用Iterator
            Iterator iterator = elementList.iterator();
            while(iterator.hasNext()){
                //因为我们要把XML中的元素或属性取出来存放 在我们已有类Student里变成它的对象
                //所以要创建一个Student对象 用于存储取出来的属性或元素值
                Student student = new Student();
                //首先我们要取出的是根元素下边的子元素里的属性的ID的值
                //得到根元素下边子元素
                Element childElement = (Element) iterator.next();
                //要得到这个子元素的属性，因为一个元素可能有多个属性我们用list
                List<Attribute> attributeList= childElement.attributes();
                //去遍历这个属性LIST拿出属性，存放在student里
                for(int i=0;i<attributeList.size();i++){
                    //list中取出来的是Attribute对象
                    Attribute attribute = attributeList.get(i);
                    //这个属性的名字等于ID，那么将属性的值存在Student对象的ID里
                    if(attribute.getName().equals("id")){
                        student.setId(attribute.getValue());
                    }
                }
                //我们现在要取出子元素下边 的子元素了。子元素有可能又有很多子元素因此 我们用一个LIST列表
                List<Element> listChildElement = childElement.elements();//子元素下边的孩子
                for(int r=0;r<listChildElement.size();r++){
                    Element element = listChildElement.get(r);
                    if(element.getName().equals("name")){
                        student.setStuName(element.getStringValue());
                    }else if(element.getName().equals("sex")){
                        student.setSex(element.getStringValue());
                    }else if(element.getName().equals("age")){
                        student.setAge(Integer.parseInt(element.getStringValue()));
                    }else if(element.getName().equals("like")){
                        student.setLike(element.getStringValue());
                    }
                }
                //所有元素值都给了student对象，我们完成了一个对象的创建，将这个对象存入List中返回
                //因为我们不会每次循环重新创建一个List,我们是统一放在同一个LIST里进行返回的，所以我们在方法的
                //一开始声明了一个student的list
                studentList.add(student);

            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
