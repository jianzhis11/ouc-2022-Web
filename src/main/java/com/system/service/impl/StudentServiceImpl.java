package com.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.mapper.StudentMapper;
import com.system.pojo.Student;
import com.system.pojo.StudentExample;
import com.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public void addStudednt(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public void updateStudentByExample(Student student) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andSnoEqualTo(student.getSno());
        System.out.println(student);
        studentMapper.updateByExampleSelective(student, studentExample);
    }

    @Override
    public void deleteStudentBySno(String sno) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andSnoEqualTo(sno);
        studentMapper.deleteByExample(studentExample);
    }

    @Override
    public PageInfo<Student> selectStudent(Student student, Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        StudentExample studentExample = new StudentExample();
        if (!Objects.equals(student.getSno(), "")) {
            studentExample.createCriteria().andSnoLike("%"+student.getSno()+"%");
        }
        if (!Objects.equals(student.getSname(), "")) {
            studentExample.createCriteria().andSnameLike("%"+student.getSname()+"%");
        }
        if (!Objects.equals(student.getSsex(), "")) {
            studentExample.createCriteria().andSsexEqualTo(student.getSsex());
        }
        if (!Objects.equals(student.getSdept(), "")) {
            studentExample.createCriteria().andSdeptLike("%"+student.getSdept()+"%");
        }
        if (!Objects.equals(student.getSclass(), "")) {
            studentExample.createCriteria().andSclassLike("%"+student.getSclass()+"%");
        }
        if (student.getSage() != null) {
            studentExample.createCriteria().andSageEqualTo(student.getSage());
        }
        List<Student> list = studentMapper.selectByExample(studentExample);
        PageInfo<Student> page = new PageInfo<>(list, 5);
        return page;
    }

    @Override
    public Student getStuInfoBySno(String Sno) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andSnoEqualTo(Sno);
        List<Student> list = studentMapper.selectByExample(studentExample);
        System.out.println("查询到的结果" + list);
        return list.get(0);
    }

    @Override
    public PageInfo<Student> getStudentPage(Integer pageNum) {
        // 开启分页功能
        PageHelper.startPage(pageNum, 5);
        // 查询所有的学生信息
        List<Student> list = studentMapper.selectByExample(null);
        // 获取分页相关数据
        PageInfo<Student> page = new PageInfo<>(list, 5);

        return page;
    }
}
