package it.repository;

import it.model.Teacher;

import java.util.List;

public interface TeacherDao {
    void save(Teacher teacher);

  //  void save(Teacher teacher);

    Teacher getById(Long id);

    List<Teacher> getALl();

    void deleteById(Long id);

    void deleteAll();

    void updateById(Long id, Teacher teacher);

    List  findAllTeacher(Long id);
}

