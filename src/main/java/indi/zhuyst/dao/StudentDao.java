package indi.zhuyst.dao;

import indi.zhuyst.pojo.Student;
import indi.zhuyst.utils.JDBCUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhuyst on 2017/5/31.
 */
public class StudentDao {
    private static MyQueryRunner queryRunner;

    public StudentDao(){
        queryRunner = JDBCUtils.getQueryRunner();
    }

    public List<Student> listStudent(){
        String sql = "SELECT * FROM Student";
        try {
            return queryRunner.query(sql,new BeanListHandler<Student>(Student.class));
        } catch (SQLException e) {
            return null;
        }
    }

    public Student getStudent(String id){
        String sql = "SELECT * FROM Student WHERE id = ?";
        try {
            return queryRunner.query(sql,new BeanHandler<Student>(Student.class),id);
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean insertStudent(Student student){
        String sql = "INSERT INTO student (id, name, phone, email, dorm, floor, room) VALUES" +
                " (?, ?, ?, ?, ?, ?, ?)";
        try {
            return queryRunner.insertBean(sql,student) > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteStudent(String id){
        String sql = "DELETE FROM student WHERE id = ? ";
        try {
            return queryRunner.update(sql,id) > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateStudent(Student newStudent){
        String sql = "UPDATE student SET name = ?, phone = ?, email = ?, dorm = ?, floor = ?, room = ? WHERE id = ? ";
        Student student = this.getStudent(newStudent.getId());

        try {
            return queryRunner.updateBean(sql,student,newStudent) > 0;
        } catch (SQLException e) {
            return false;
        }
    }
}
