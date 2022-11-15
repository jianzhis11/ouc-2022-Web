package com.system.controller;

import com.system.pojo.*;
import com.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller("teacherController")
@SessionAttributes({"tc_course_list", "Tno"})
public class teacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TCService tcService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private SuserService suserService;

    // 返回主页
    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public String returnToIndex() {
        return "teacher";
    }

    // 教师信息
    @RequestMapping(value = "/teacher/info/{Tno}", method = RequestMethod.GET)
    public String goToTeacherInfo(@PathVariable("Tno") String Tno, Model model) {
        // 获取教师信息
        model.getAttribute("Tno");
        System.out.println(Tno);
        Teacher teacher = teacherService.getTeacherInfoByTno(Tno);
        System.out.println(teacher);
        model.addAttribute("teacher", teacher);
        // 获取学生选课信息
        List<TC> tcList = tcService.getTeacherTC(Tno);
        List<Course> courseList = new ArrayList<>();
        for (TC tc: tcList) {
            Course course = courseService.selectCourseByCno(tc.getCno());
            courseList.add(course);
        }
        List<TC_Course> tc_course_list = new ArrayList<>();
        for (TC tc: tcList) {
            for (Course course: courseList) {
                if (Objects.equals(tc.getCno(), course.getCno())) {
                    TC_Course tc_course = new TC_Course(tc.getCno(), course.getCname(), course.getCpno(), course.getCcredit());
                    tc_course_list.add(tc_course);
                    break;
                }
            }
        }
        model.addAttribute("tc_course_list", tc_course_list);
        return "teacherInfo";
    }

    @RequestMapping(value = "/teacher/tcprocess/{Tno}", method = RequestMethod.GET)
    public String goToSCProcess(@PathVariable("Tno") String Tno, Model model) {
        model.addAttribute("Tno", Tno);
        return "teacher_tc_process";
    }

    @RequestMapping(value = "/teacher/to/select/course", method = RequestMethod.GET)
    public String TeacherTCCourse(String Cno, String Cname, Model model) {
        Object tno = model.getAttribute("Tno");
        System.out.println(Cno + Cname);
        List<Course> list =  courseService.teacherSelectCourse(Cno, Cname);
        model.addAttribute("Tno", tno);
        model.addAttribute("list", list);
        return "teacher_tc_info";
    }

    @RequestMapping(value = "/teacher/update/{Cno}", method = RequestMethod.GET)
    public String TeacherTCResult(@PathVariable("Cno") String Cno, Model model) {
        String tno = Objects.requireNonNull(model.getAttribute("Tno")).toString();
        tcService.insertTCInfo((String) tno, Cno);
        // 获取学生信息
        Teacher teacher = teacherService.getTeacherInfoByTno(tno);
        model.addAttribute("teacher", teacher);
        // 获取学生选课信息
        List<TC> tcList = tcService.getTeacherTC(tno);
        List<Course> courseList = new ArrayList<>();
        for (TC tc: tcList) {
            Course course = courseService.selectCourseByCno(tc.getCno());
            courseList.add(course);
        }
        List<TC_Course> tc_course_list = new ArrayList<>();
        for (TC tc: tcList) {
            for (Course course: courseList) {
                if (Objects.equals(tc.getCno(), course.getCno())) {
                    TC_Course tc_course = new TC_Course(tc.getCno(), course.getCname(), course.getCpno(), course.getCcredit());
                    tc_course_list.add(tc_course);
                    break;
                }
            }
        }
        model.addAttribute("tc_course_list", tc_course_list);
        return "teacherInfo";
    }

    // 修改密码
    @RequestMapping(value = "/teacher/gotoupdate/{Tno}", method = RequestMethod.GET)
    public String goToUpdateTeacherPassword(@PathVariable("Tno") String Tno, Model model) {
        model.addAttribute("Tno", Tno);
        return "update_teacher_password";
    }

    // 获取并修改密码
    @RequestMapping(value = "/teacher/updatepassword/{Tno}", method = RequestMethod.POST)
    public String updateStudentPassword(@PathVariable("Tno") String Tno, String fristPass, String secondPass,
                                        HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        if (Objects.equals(fristPass, secondPass) && fristPass != null) {
            suserService.updatePassword(Tno, fristPass);
        }
        response.getWriter().write("<script>alert('修改成功!请重新登录!');window.location='../../'; </script>");
        return null;
    }
}
