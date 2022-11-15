package com.system.controller;

import com.system.pojo.Course;
import com.system.pojo.SC;
import com.system.pojo.SC_Course;
import com.system.pojo.Student;
import com.system.service.CourseService;
import com.system.service.SCService;
import com.system.service.StudentService;
import com.system.service.SuserService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Controller("Controller")
@SessionAttributes({"sc_course_list", "Sno"})
public class studentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private SCService scService;

    @Autowired
    private SuserService suserService;

    @Autowired
    private CourseService courseService;

    // 返回主页
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String returnToIndex() {
        return "student";
    }

    // 学生信息
    @RequestMapping(value = "/student/info/{Sno}", method = RequestMethod.GET)
    public String goToStuInfo(@PathVariable("Sno") String Sno, Model model) {
        // 获取学生信息
        model.getAttribute("Sno");
        Student student = studentService.getStuInfoBySno(Sno);
        model.addAttribute("student", student);
        // 获取学生选课信息
        List<SC> scList = scService.getStuSC(Sno);
        List<Course> courseList = new ArrayList<>();
        for (SC sc: scList) {
            Course course = courseService.selectCourseByCno(sc.getCno());
            courseList.add(course);
        }
        List<SC_Course> sc_course_list = new ArrayList<>();
        for (SC sc: scList) {
            for (Course course: courseList) {
                if (Objects.equals(sc.getCno(), course.getCno())) {
                    SC_Course sc_course = new SC_Course(sc.getCno(), sc.getGrade(), course.getCname(), course.getCpno(), course.getCcredit());
                    sc_course_list.add(sc_course);
                    break;
                }
            }
        }
        model.addAttribute("sc_course_list", sc_course_list);
        return "studentInfo";
    }

    @RequestMapping(value = "/student/scprocess/{Sno}", method = RequestMethod.GET)
    public String goToSCProcess(@PathVariable("Sno") String Sno, Model model) {
        model.addAttribute("Sno", Sno);
        return "student_sc_process";
    }

    @RequestMapping(value = "/student/to/select/course", method = RequestMethod.GET)
    public String StuSCCourse(String Cno, String Cname, Model model) {
        Object sno = model.getAttribute("Sno");
        List<Course> list =  courseService.studentSelectCourse(Cno, Cname);
        model.addAttribute("Sno", sno);
        model.addAttribute("list", list);
        return "student_sc_info";
    }

    @RequestMapping(value = "/student/update/{Cno}", method = RequestMethod.GET)
    public String StuSCResult(@PathVariable("Cno") String Cno, Model model) {
        String sno = Objects.requireNonNull(model.getAttribute("Sno")).toString();
        scService.insertSCInfo((String) sno, Cno);
        // 获取学生信息
        Student student = studentService.getStuInfoBySno(sno);
        model.addAttribute("student", student);
        // 获取学生选课信息
        List<SC> scList = scService.getStuSC(sno);
        List<Course> courseList = new ArrayList<>();
        for (SC sc: scList) {
            Course course = courseService.selectCourseByCno(sc.getCno());
            courseList.add(course);
        }
        List<SC_Course> sc_course_list = new ArrayList<>();
        for (SC sc: scList) {
            for (Course course: courseList) {
                if (Objects.equals(sc.getCno(), course.getCno())) {
                    SC_Course sc_course = new SC_Course(sc.getCno(), sc.getGrade(), course.getCname(), course.getCpno(), course.getCcredit());
                    sc_course_list.add(sc_course);
                    break;
                }
            }
        }
        model.addAttribute("sc_course_list", sc_course_list);
        return "studentInfo";
    }

    // 修改密码
    @RequestMapping(value = "/student/gotoupdate/{Sno}", method = RequestMethod.GET)
    public String goToUpdateStudentPassword(@PathVariable("Sno") String Sno, Model model) {
        model.addAttribute("Sno", Sno);
        return "update_student_password";
    }

    // 获取并修改密码
    @RequestMapping(value = "/student/updatepassword/{Sno}", method = RequestMethod.POST)
    public String updateStudentPassword(@PathVariable("Sno") String Sno, String fristPass, String secondPass,
                                        HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        if (Objects.equals(fristPass, secondPass) && !Objects.equals(fristPass, "")) {
            suserService.updatePassword(Sno, fristPass);
            response.getWriter().write("<script>alert('修改成功!请重新登录!');window.location='../../'; </script>");
            return null;
        }
        else {
            response.getWriter().write("<script>alert('修改失败!请重新输入!'); </script>");
            return "update_student_password";
        }
    }
}
