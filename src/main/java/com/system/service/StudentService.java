package com.system.service;

import com.github.pagehelper.PageInfo;
import com.system.pojo.Student;
import com.system.pojo.StudentExample;

import java.util.List;

public interface StudentService {

    PageInfo<Student> getStudentPage(Integer pageNum);

    void updateStudentByExample(Student student);

    void deleteStudentBySno(String sno);

    void addStudednt(Student student);

    PageInfo<Student> selectStudent(Student student, Integer pageNum);

    Student getStuInfoBySno(String Sno);
}
