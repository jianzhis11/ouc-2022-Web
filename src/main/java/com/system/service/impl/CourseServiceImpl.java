package com.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.tracing.dtrace.Attributes;
import com.system.mapper.CourseMapper;
import com.system.pojo.Course;
import com.system.pojo.CourseExample;
import com.system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("CourseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> teacherSelectCourse(String cno, String cname) {
        CourseExample courseExample = new CourseExample();
        if (!Objects.equals(cno, "")) {
            courseExample.createCriteria().andCnoEqualTo(cno);
        }
        if (!Objects.equals(cname, "")) {
            courseExample.createCriteria().andCnameLike("%"+cname+"%");
        }
        List<Course> list = courseMapper.selectByExample(courseExample);
        return list;
    }

    @Override
    public List<Course> studentSelectCourse(String cno, String cname) {
        CourseExample courseExample = new CourseExample();
        if (!Objects.equals(cno, "")) {
            courseExample.createCriteria().andCnoEqualTo(cno);
        }
        if (!Objects.equals(cname, "")) {
            courseExample.createCriteria().andCnameLike("%"+cname+"%");
        }
        List<Course> list = courseMapper.selectByExample(courseExample);
        return list;
    }

    @Override
    public PageInfo<Course> getCoursePage(Integer pageNum) {
        // 开启分页功能
        PageHelper.startPage(pageNum, 5);
        // 查询所有的学生信息
        List<Course> list = courseMapper.selectByExample(null);
        // 获取分页相关数据
        PageInfo<Course> page = new PageInfo<>(list, 5);

        return page;
    }

    @Override
    public void deleteCourseByCno(String cno) {
        CourseExample courseExample = new CourseExample();
        courseExample.createCriteria().andCnoEqualTo(cno);
        courseMapper.deleteByExample(courseExample);
    }

    @Override
    public void updateCourseByExample(Course course) {
        CourseExample courseExample = new CourseExample();
        courseExample.createCriteria().andCnoEqualTo(course.getCno());
        courseMapper.updateByExampleSelective(course, courseExample);
    }

    @Override
    public void addCourse(Course course) {
        courseMapper.insert(course);
    }

    @Override
    public Course selectCourseByCno(String Cno) {
        CourseExample courseExample = new CourseExample();
        courseExample.createCriteria().andCnoEqualTo(Cno);
        List<Course> list = courseMapper.selectByExample(courseExample);
        return list.get(0);
    }

    @Override
    public PageInfo<Course> selectCourse(Course course, Integer pageNum) {

        PageHelper.startPage(pageNum, 5);
        CourseExample courseExample = new CourseExample();
        if (!Objects.equals(course.getCno(), "")) {
            courseExample.createCriteria().andCnoLike("%"+course.getCno()+"%");
        }
        if (!Objects.equals(course.getCname(), "")) {
            courseExample.createCriteria().andCnameLike("%"+course.getCname()+"%");
        }
        if (!Objects.equals(course.getCpno(), "")) {
            courseExample.createCriteria().andCpnoLike(course.getCpno());
        }
        if (course.getCcredit() != null) {
            courseExample.createCriteria().andCcreditEqualTo(course.getCcredit());
        }
        List<Course> list = courseMapper.selectByExample(courseExample);
        PageInfo<Course> page = new PageInfo<>(list, 5);
        return page;
    }
}
