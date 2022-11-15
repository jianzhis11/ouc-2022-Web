package com.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.mapper.TeacherMapper;
import com.system.pojo.*;
import com.system.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public PageInfo<Teacher> getTeacherPage(Integer pageNum) {
        // 开启分页功能
        PageHelper.startPage(pageNum, 5);
        // 查询所有的学生信息
        List<Teacher> list = teacherMapper.selectByExample(null);
        // 获取分页相关数据
        PageInfo<Teacher> page = new PageInfo<>(list, 5);

        return page;
    }

    @Override
    public void updateTeacherByExample(Teacher teacher) {
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andTnoEqualTo(teacher.getTno());
        teacherMapper.updateByExampleSelective(teacher, teacherExample);
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherMapper.insert(teacher);
    }

    @Override
    public PageInfo<Teacher> selectTeacher(Teacher teacher, Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        TeacherExample teacherExample = new TeacherExample();
        if (!Objects.equals(teacher.getTno(), "")) {
            teacherExample.createCriteria().andTnoLike("%"+teacher.getTno()+"%");
        }
        if (!Objects.equals(teacher.getTname(), "")) {
            teacherExample.createCriteria().andTnameLike("%"+teacher.getTname()+"%");
        }
        if (!Objects.equals(teacher.getTsex(), "")) {
            teacherExample.createCriteria().andTsexEqualTo(teacher.getTsex());
        }
        if (!Objects.equals(teacher.getTdept(), "")) {
            teacherExample.createCriteria().andTdeptLike("%"+teacher.getTdept()+"%");
        }
        if (teacher.getTsalary() != null) {
            teacherExample.createCriteria().andTsalaryEqualTo(teacher.getTsalary());
        }
        if (teacher.getTage() != null) {
            teacherExample.createCriteria().andTageEqualTo(teacher.getTage());
        }
        List<Teacher> list = teacherMapper.selectByExample(teacherExample);
        PageInfo<Teacher> page = new PageInfo<>(list, 5);
        return page;
    }

    @Override
    public Teacher getTeacherInfoByTno(String tno) {
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andTnoEqualTo(tno);
        List<Teacher> list = teacherMapper.selectByExample(teacherExample);
        System.out.println("查询到的结果" + list);
        return list.get(0);
    }

    @Override
    public void deleteTeacherByTno(String tno) {
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andTnoEqualTo(tno);
        teacherMapper.deleteByExample(teacherExample);
    }
}
