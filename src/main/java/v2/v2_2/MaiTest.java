package v2.v2_2;

import v2.Student;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *      版本：V 2.1
 *      修改：1. 提取数据操作到 StudentDataUtils.java
 *            2. 修改时，不需要临时变量存储 name、id、等 变量。直接 存到 Student对象 中即可。
 *            3. 遇到异常，不要惊慌，该catch，就不要抛出！
 */
public class MaiTest {
    public static void main(String[] args) {
        System.out.println("欢迎使用学生管理系统V1.0");
        OprintionStudent.opritionMenu();
    }
    }

