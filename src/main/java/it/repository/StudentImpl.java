package it.repository;

import it.model.Groups;
import it.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import javax.xml.transform.sax.SAXResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
@Transactional
public class StudentImpl implements StudentDao{
    @Autowired
    private SessionFactory connection;
    @Autowired
    private GroupDao groupDao;

    @Override
    public void save(Student student) {
        Session session = connection.getCurrentSession();
        session.save(student);
        System.out.println("saved");

    }

    @Override
    public Student getById(Long id) {
        Session session = connection.getCurrentSession();
        return session.get(Student.class,id);
    }

    @Override
    public List<Student> getALl() {
        Session session = connection.getCurrentSession();
        return session.createQuery("select p from Student p",Student.class).getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Session session = connection.getCurrentSession();
        session.delete(session.get(Student.class,id));

    }

    @Override
    public void deleteAll() {
        Session session = connection.getCurrentSession();
        session.createQuery("delete from Student ").executeUpdate();

    }

    @Override
    public List<Student> findAllStudent(Long id) {
        List<Student> students =new ArrayList<>();
        List<Groups> groups = (List<Groups>) groupDao.findAllGroups(id);
        for (Groups group : groups){
            for (Student student : getALl()){
                Student student1 = getById(student.getId());
                if (Objects.equals(student.getGroup().getId(), group.getId()))
                    students.add(student1);
                }
            }

        return students;
    }

    @Override
    public void updateById(Long id, Student student) {
        Session session = connection.getCurrentSession();
        Student student1= getById(id);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setGroup(student.getGroup());
        student1.setEmail(student.getEmail());
        student1.setStudyFormat(student.getStudyFormat());
        session.merge(student1);

    }
}
