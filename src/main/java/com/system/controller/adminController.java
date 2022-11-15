package com.system.controller;

import com.github.pagehelper.PageInfo;
import com.system.pojo.*;
import com.system.service.CourseService;
import com.system.service.StudentService;
import com.system.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * 查询所有学生信息-->admin/student-->get
 * 查询学生的分页信息-->/admin/student/page/ -->get
 * 跳转到查询界面-->/admin/student/to/select -->get
 * 查询学生信息-->/admin/student/info --> get
 * 跳转到添加页面-->/admin/student/to/add-->get
 * 添加学生信息-->/admin/student-->post
 * 修改学生信息-->/admin/student/2022103001-->put
 * 删除学生信息-->/admin/student/delete/2022103001-->delete
 */

@Controller
@SessionAttributes({"student", "teacher", "course"})
public class adminController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseService courseService;

    // 返回主页
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String returnToIndex(Model model) {
        return "admin";
    }

    // 分页展示学生列表
    @RequestMapping(value = "/admin/student/page/{pageNum}", method = RequestMethod.GET)
    public String getStudentPage(@PathVariable("pageNum") Integer pageNum, Model model) {
        // 获取分页信息
        PageInfo<Student> page = studentService.getStudentPage(pageNum);
        System.out.println(page);
        // 将分页数据共享到请求域中
        model.addAttribute("page", page);
        return "student_list";
    }

    // 跳转至修改页面
    @RequestMapping(value = "/admin/student/update/{Sno}", method = RequestMethod.GET)
    public String updateStudent(@PathVariable("Sno") String Sno, Model model)
    {
        model.addAttribute("Sno", Sno);
        return "update_student";
    }

    // 修改学生信息
    @RequestMapping(value = "/admin/student/update/{Sno}", method = RequestMethod.POST)
    public String updateStudentDetail(String Sname, String Ssex, Short Sage, String Sdept, String Sclass,
                                      @PathVariable("Sno") String Sno) {
        if (Objects.equals(Sname, "")) Sname = null;
        if (Objects.equals(Sdept, "")) Sdept = null;
        if (Objects.equals(Sclass, "")) Sclass = null;
        Student student = new Student(Sno, Sname, Ssex, Sage, Sdept, Sclass);
        System.out.println("传进来的"+student);
        studentService.updateStudentByExample(student);
        return "redirect:/admin/student/page/1";
    }

    // 删除学生信息
    @RequestMapping(value = "/admin/student/delete/{Sno}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("Sno") String Sno) {
        studentService.deleteStudentBySno(Sno);
        // 在Suser表里删除
        return "redirect:/admin/student/page/1";
    }

    // 跳转到添加页面
    @RequestMapping(value = "/admin/student/to/add", method = RequestMethod.GET)
    public String toAdd() {
        System.out.println("跳转到添加页面");
        return "insert_student";
    }

    // 添加学生信息
    @RequestMapping(value = "/admin/student", method = RequestMethod.POST)
    public String insertInfo(String Sname, String Ssex, Short Sage, String Sdept, String Sclass,
                             String Sno) {
        Student student = new Student(Sno, Sname, Ssex, Sage, Sdept, Sclass);
        studentService.addStudednt(student);
        return "redirect:/admin/student/page/1";
    }

    // 跳转到查询界面
    @RequestMapping(value = "/admin/student/to/select", method = RequestMethod.GET)
    public String toSelect() {
        System.out.println("跳转到查询界面");
        return "select_student";
    }

    // 模糊查询
    @RequestMapping(value = "/admin/student/to/select/student", method = RequestMethod.GET)
    public String selectStuent(String Sno, String Sname, String Ssex, Short Sage, String Sdept, String Sclass,
                               Model model) {
        Student student = new Student(Sno, Sname, Ssex, Sage, Sdept, Sclass);
        System.out.println(student);
        model.addAttribute("student", student);
        return "redirect:/admin/student/select/page/1/";

    }

    // 分页展示查找到的学生列表
    @RequestMapping(value = "/admin/student/select/page/{pageNum}", method = RequestMethod.GET)
    public String selectStudentPage(@PathVariable("pageNum") Integer pageNum, Model model) {
        Object student = model.getAttribute("student");
        PageInfo<Student> page = studentService.selectStudent((Student) student, pageNum);
        System.out.println("查找结果" + page);
        model.addAttribute("page", page);
        return "select_stu_result";
    }

    // 分页展示教师列表
    @RequestMapping(value = "/admin/teacher/page/{pageNum}", method = RequestMethod.GET)
    public String getTeacherPage(@PathVariable("pageNum") Integer pageNum, Model model) {
        // 获取分页信息
        PageInfo<Teacher> page = teacherService.getTeacherPage(pageNum);
        // 将分页数据共享到请求域中
        model.addAttribute("page", page);
        return "teacher_list";
    }

    // 删除教师信息
    @RequestMapping(value = "/admin/teacher/delete/{Tno}", method = RequestMethod.GET)
    public String deleteTeacher(@PathVariable("Tno") String Tno) {
        teacherService.deleteTeacherByTno(Tno);
        // 在Suser表里删除
        return "redirect:/admin/teacher/page/1";
    }

    // 跳转至修改页面
    @RequestMapping(value = "/admin/teacher/update/{Tno}", method = RequestMethod.GET)
    public String updateTeacher(@PathVariable("Tno") String Tno, Model model)
    {
        model.addAttribute("Tno", Tno);
        return "update_teacher";
    }

    // 修改教师信息
    @RequestMapping(value = "/admin/teacher/update/{Tno}", method = RequestMethod.POST)
    public String updateTeacherDetail(String Tname, String Tsex, Short Tage, String Tdept, Integer Tsalary,
                                      @PathVariable("Tno") String Tno) {
        Teacher teacher = new Teacher(Tno, Tname, Tsex, Tage, Tdept, Tsalary);
        teacherService.updateTeacherByExample(teacher);
        return "redirect:/admin/teacher/page/1";
    }

    // 跳转到添加页面
    @RequestMapping(value = "/admin/teacher/to/add", method = RequestMethod.GET)
    public String toTeacherAdd() {
        System.out.println("跳转到添加教师页面");
        return "insert_teacher";
    }

    // 添加教师信息
    @RequestMapping(value = "/admin/teacher", method = RequestMethod.POST)
    public String insertTeacherInfo(String Tname, String Tsex, Short Tage, String Tdept, Integer Tsalary,
                             String Tno) {
        Teacher teacher = new Teacher(Tno, Tname, Tsex, Tage, Tdept, Tsalary);
        System.out.println(teacher);
        teacherService.addTeacher(teacher);
        return "redirect:/admin/teacher/page/1";
    }

    // 跳转到查询界面
    @RequestMapping(value = "/admin/teacher/to/select", method = RequestMethod.GET)
    public String toTeacherSelect() {
        System.out.println("跳转到查询教师界面");
        return "select_teacher";
    }

    // 模糊查询
    @RequestMapping(value = "/admin/teacher/to/select/teacher", method = RequestMethod.GET)
    public String selectStuent(String Tno, String Tname, String Tsex, Short Tage, String Tdept, Integer Tsalary,
                               Model model) {
        Teacher teacher = new Teacher(Tno, Tname, Tsex, Tage, Tdept, Tsalary);
        System.out.println(teacher);
        model.addAttribute("teacher", teacher);
        return "redirect:/admin/teacher/select/page/1/";

    }

    // 分页展示查找到的教师列表
    @RequestMapping(value = "/admin/teacher/select/page/{pageNum}", method = RequestMethod.GET)
    public String selectTeacherPage(@PathVariable("pageNum") Integer pageNum, Model model) {
        Object teacher = model.getAttribute("teacher");
        PageInfo<Teacher> page = teacherService.selectTeacher((Teacher) teacher, pageNum);
        System.out.println("查找结果" + page);
        model.addAttribute("page", page);
        return "select_teacher_result";
    }

    // 分页展示课程列表
    @RequestMapping(value = "/admin/course/page/{pageNum}", method = RequestMethod.GET)
    public String getCoursePage(@PathVariable("pageNum") Integer pageNum, Model model) {
        // 获取分页信息
        PageInfo<Course> page = courseService.getCoursePage(pageNum);
        // 将分页数据共享到请求域中
        model.addAttribute("page", page);
        return "course_list";
    }

    // 删除教师信息
    @RequestMapping(value = "/admin/course/delete/{Cno}", method = RequestMethod.GET)
    public String deleteCourse(@PathVariable("Cno") String Cno) {
        courseService.deleteCourseByCno(Cno);
        // 在Suser表里删除
        return "redirect:/admin/course/page/1";
    }

    // 跳转至修改页面
    @RequestMapping(value = "/admin/course/update/{Cno}", method = RequestMethod.GET)
    public String updateCourse(@PathVariable("Cno") String Cno, Model model)
    {
        model.addAttribute("Cno", Cno);
        return "update_course";
    }

    // 修改课程信息
    @RequestMapping(value = "/admin/course/update/{Cno}", method = RequestMethod.POST)
    public String updateTeacherDetail(String Cname, String Cpno, Short Ccredit, @PathVariable("Cno") String Cno) {
        Course course = new Course(Cno, Cname, Cpno, Ccredit);
        courseService.updateCourseByExample(course);
        return "redirect:/admin/course/page/1";
    }

    // 跳转到添加页面
    @RequestMapping(value = "/admin/course/to/add", method = RequestMethod.GET)
    public String toCourseAdd() {
        System.out.println("跳转到添加教师页面");
        return "insert_course";
    }

    // 添加课程信息
    @RequestMapping(value = "/admin/course", method = RequestMethod.POST)
    public String insertCourseInfo(String Cname, String Cpno, Short Ccredit, String Cno) {
        Course course = new Course(Cno, Cname, Cpno, Ccredit);
        System.out.println(course);
        courseService.addCourse(course);
        return "redirect:/admin/course/page/1";
    }

    // 跳转到查询界面
    @RequestMapping(value = "/admin/course/to/select", method = RequestMethod.GET)
    public String toCourseSelect() {
        System.out.println("跳转到查询课程界面");
        return "select_course";
    }

    // 模糊查询
    @RequestMapping(value = "/admin/course/to/select/course", method = RequestMethod.GET)
    public String selectStuent(String Cname, String Cpno, Short Ccredit, String Cno, Model model) {
        Course course = new Course(Cno, Cname, Cpno, Ccredit);
        System.out.println(course);
        model.addAttribute("course", course);
        return "redirect:/admin/course/select/page/1/";

    }

    // 分页展示查找到的课程列表
    @RequestMapping(value = "/admin/course/select/page/{pageNum}", method = RequestMethod.GET)
    public String selectCoursePage(@PathVariable("pageNum") Integer pageNum, Model model) {
        Object course = model.getAttribute("course");
        PageInfo<Course> page = courseService.selectCourse((Course) course, pageNum);
        System.out.println("查找结果" + page);
        model.addAttribute("page", page);
        return "select_course_result";
    }
}
