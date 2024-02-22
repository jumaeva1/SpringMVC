package it.repository;

import it.model.Company;

public interface CompanyDao {
    void save(Company company);


    Company getById(Long id);

    Object getALl();

    void deleteById(Long id);

    void deleteAll();

    void updateById(Long id, Company company);
}
