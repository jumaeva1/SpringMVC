package it.repository;

import it.model.Course;
import it.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
@Transactional
public class TeacherImpl implements TeacherDao{
    @Autowired
    private SessionFactory connection;
    @Autowired
    private CourseDao courseDao;
    @Override
    public void save(Teacher teacher) {
        Session session = connection.getCurrentSession();
        session.save(teacher);
        System.out.println("saved");

    }

    @Override
    public Teacher getById(Long id) {
        Session session = connection.getCurrentSession();

        return session.get(Teacher.class,id);
    }

    @Override
    public List<Teacher> getALl() {
        Session session = connection.getCurrentSession();
        return session.createQuery("select p from Teacher p", Teacher.class).getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Session session= connection.getCurrentSession();
        session.delete(session.get(Teacher.class,id));

    }

    @Override
    public void deleteAll() {
        Session session = connection.getCurrentSession();
        session.createQuery("delete from Teacher ").executeUpdate();

    }

    @Override
    public void updateById(Long id, Teacher teacher) {
        Session session = connection.getCurrentSession();
        Teacher teacher1 = getById(id);
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setCourse(teacher.getCourse());
        teacher1.setEmail(teacher.getEmail());
        session.merge(teacher1);
    }

    @Override
    public List<Teacher> findAllTeacher(Long id) {
        List<Teacher> teachers =new ArrayList<>();
        List<Course> courses = (List<Course>) courseDao.connectionFindAll(id);
        for (Course course :courses){
            for (Teacher teacher : getALl()){
                Teacher teacher1 =getById(teacher.getId());
                if(Objects.equals(teacher.getCourse().getId(), course.getId())){
                    teachers.add(teacher1);
                }
            }
        }
        return teachers;
    }
}