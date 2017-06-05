package indi.zhuyst.dbutilslearn.dao;

import indi.zhuyst.dbutilslearn.enums.SqlEnum;
import indi.zhuyst.dbutilslearn.pojo.Student;
import indi.zhuyst.dbutilslearn.utils.JDBCUtils;
import indi.zhuyst.dbutilslearn.utils.PojoUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhuyst on 2017/5/31.
 */
public class StudentDao {
    private static QueryRunner queryRunner;

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
            return queryRunner.update(sql, PojoUtils.getAttributes(student, SqlEnum.INSERT)) > 0;
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

        student = (Student) PojoUtils.updateBean(student,newStudent);
        try {
            return queryRunner.update(sql,PojoUtils.getAttributes(student,SqlEnum.UPDATE)) > 0;
        } catch (SQLException e) {
            return false;
        }
    }
}
