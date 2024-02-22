package it.repository;

import it.model.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


public interface StudentDao {

    void save(Student student);

    Student getById(Long id);

    Object getALl();

    void deleteById(Long id);

    void deleteAll();

    void updateById(Long id, Student student);

    List findAllStudent(Long id);

   // void updateById(Long id, Student student);
}
