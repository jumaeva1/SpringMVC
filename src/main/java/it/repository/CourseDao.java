package it.repository;

import it.model.Course;

public interface CourseDao {
    void save(Course course);

    Course getById(Long id);

    Object getALl();

    void deleteById(Long id);

    void deleteAll();

    void updateById(Long id, Course course);

    Object connectionFindAll(Long id);
}
