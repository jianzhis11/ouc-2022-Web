package com.system.service;

import com.github.pagehelper.PageInfo;
import com.system.pojo.Teacher;

public interface TeacherService {
    PageInfo<Teacher> getTeacherPage(Integer pageNum);

    void deleteTeacherByTno(String tno);

    void updateTeacherByExample(Teacher teacher);

    void addTeacher(Teacher teacher);

    PageInfo<Teacher> selectTeacher(Teacher teacher, Integer pageNum);

    Teacher getTeacherInfoByTno(String tno);
}
