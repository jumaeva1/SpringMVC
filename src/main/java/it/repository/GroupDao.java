package it.repository;

import it.model.Groups;

public interface GroupDao {
    void save(Groups group);

    void deleteAll();

    Groups getById(Long id);

    Object getALl();

    void deleteById(Long id);

    void updateById(Long id, Groups group);

    Object findAllGroups(Long id);
}

