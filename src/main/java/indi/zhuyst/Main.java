package indi.zhuyst;

import indi.zhuyst.dao.StudentDao;
import indi.zhuyst.pojo.Student;

import java.sql.SQLException;

/**
 * Created by zhuyst on 2017/5/31.
 */
public class Main {
    public static void main(String args[]) throws SQLException {
        StudentDao studentDao = new StudentDao();

        //Insert Test
        Student student = new Student();
        student.setId("1311030134");
        student.setName("zhuyst");
        student.setPhone("110");
        studentDao.insertStudent(student);

        //Query Test
        Student student2 = studentDao.getStudent("1311030134");
        System.out.println(student2.getId() + ":" + student2.getName() + ":" + student2.getPhone());

        //Update Test
        Student student3 = new Student();
        student3.setId("1311030134");
        student3.setName("zhuyst2");
        studentDao.updateStudent(student3);
        Student student4 = studentDao.getStudent("1311030134");
        System.out.println(student4.getId() + ":" + student4.getName() + ":" + student4.getPhone());

        //Delete Test
        Boolean ok = studentDao.deleteStudent("1311030134");
        System.out.println(ok);
    }
}
