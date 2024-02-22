package it.controller;

import it.model.Company;
import it.model.Course;
import it.repository.CompanyDao;
import it.repository.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {
    private CourseDao courseDao = null;
    private final CompanyDao companyDao;

    @Autowired
    public CourseController(CourseDao courseDao, CompanyDao companyDao) {
        this.courseDao = courseDao;
        this.companyDao = companyDao;
    }

    @GetMapping("/courses")
    public String findAll(Model model) {
        model.addAttribute("alls", courseDao.getALl());
        return "find-all-course";
    }

    @PostMapping("/saveCourse")
    private String saveStudent(@RequestParam("name") String name, @RequestParam ("duration") String duration, @RequestParam Long id) {
        Company company = companyDao.getById(id);
        Course course = new Course();
        course.setCourseName(name);
        course.setDuration(duration);
        course.setCompany(company);
        courseDao.save(course);
        return "redirect:/courses";
    }

    @GetMapping("/courseForm")
    public String saveCompanyPage(Model model) {
        model.addAttribute("connection", companyDao.getALl());
        return "course-save";

    }

    @GetMapping("/deleteCourse/{id}")
    public String deleteById(@PathVariable Long id) {
        Course course = courseDao.getById(id);
        courseDao.deleteById(course.getId());
        return "redirect:/courses";
    }

    @GetMapping("/get/course/by/{id}")
    public String getById(Model model, @PathVariable Long id) {
        Course course = courseDao.getById(id);
        model.addAttribute("course", course);
        return "find-course";
    }

    @GetMapping("/updates/course/{id}")
    public String updatePersonForm(@PathVariable("id") Long id, Model model) {
        Course course = courseDao.getById(id);
        model.addAttribute("course", course);
        return "update-course-form";
    }

    @PostMapping("/course/update/{id}")
    public String updateCourse(@RequestParam("courseName") String courseName, @RequestParam("duration") String duration, @PathVariable Long id) {
        Course course = new Course();
        course.setCourseName(courseName);
        course.setDuration(duration);
        courseDao.updateById(id, course);
        return "redirect:/courses";
    }

    @GetMapping("/clearAll/course")
    public String clear() {
        courseDao.deleteAll();
        return "redirect:/courses";
    }
}
