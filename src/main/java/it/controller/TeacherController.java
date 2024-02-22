package it.controller;

import it.model.Course;
import it.model.Teacher;
import it.repository.CourseDao;
import it.repository.TeacherDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeacherController {
    private final TeacherDao teacherDao;
    private final CourseDao courseDao;

    public TeacherController(TeacherDao companyDao, CourseDao courseDao) {
        this.teacherDao = companyDao;
        this.courseDao = courseDao;
    }

    @GetMapping("/teachers")
    public String findAll(Model model) {
        model.addAttribute("all", teacherDao.getALl());
        return "find-all-teacher";
    }

    @PostMapping("/saveTeacher")
    private String saveStudent(@RequestParam("fName") String fName, @RequestParam("lName") String lName, @RequestParam("email") String email,
                               @RequestParam("id") Long id) {
        Course course = courseDao.getById(id);
        Teacher teacher = new Teacher();
        teacher.setFirstName(fName);
        teacher.setLastName(lName);
        teacher.setEmail(email);
        teacher.setCourse(course);
        teacherDao.save(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teacherForm")
    public String saveCompanyPage(Model model) {
        model.addAttribute("courseConnectionWithTeacher", courseDao.getALl());
        return "teacher-save";
    }

    @GetMapping("/deleteTeacher/{id}")
    public String deleteById(@PathVariable Long id) {
        Teacher company = teacherDao.getById(id);
        teacherDao.deleteById(company.getId());
        return "redirect:/teachers";
    }

    @GetMapping("/get/teacher/by/{id}")
    public String getById(Model model, @PathVariable Long id) {
        Teacher company = teacherDao.getById(id);
        model.addAttribute("company", company);
        return "find-teacher";
    }

    @GetMapping("/zamenit/teacher/{id}")
    public String updatePersonForm(@PathVariable("id") Long id, Model model) {
        Teacher company = teacherDao.getById(id);
        model.addAttribute("company", company);
        return "update-teacher-form";
    }

    @PostMapping("/teacher/update/{id}")
    public String updatePerson(
            @RequestParam("fName") String firstName,
            @RequestParam("lName") String lastName,
            @RequestParam("email") String email,
            @PathVariable Long id
    ) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setEmail(email);
        teacherDao.updateById(id, teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/allRemove/teacher")
    public String clear() {
        teacherDao.deleteAll();
        return "redirect:/teachers";
    }
}

