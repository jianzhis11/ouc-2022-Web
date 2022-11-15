package com.system.service;

import com.github.pagehelper.PageInfo;
import com.system.pojo.Course;

import java.util.List;

public interface CourseService {
    PageInfo<Course> getCoursePage(Integer pageNum);

    void deleteCourseByCno(String cno);

    void updateCourseByExample(Course course);

    void addCourse(Course course);

    PageInfo<Course> selectCourse(Course course, Integer pageNum);

    Course selectCourseByCno(String Cno);

    List<Course> studentSelectCourse(String cno, String cname);

    List<Course> teacherSelectCourse(String cno, String cname);
}
