package it.repository;

import it.model.Company;
import it.model.Groups;
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
public class GroupImpl implements GroupDao{
    @Autowired
    private SessionFactory connection;
    @Autowired
    private CompanyDao companyDao;
    @Override
    public void save(Groups group) {
        Session session =connection.getCurrentSession();
        session.save(group);
        System.out.println("saved");

    }

    @Override
    public void deleteAll() {
        Session session = connection.getCurrentSession();
        session.createQuery("delete from Groups ").executeUpdate();

    }

    @Override
    public Groups getById(Long id) {
        Session session = connection.getCurrentSession();

        return session.get(Groups.class,id);
    }

    @Override
    public List<Groups> getALl() {
        Session session = connection.getCurrentSession();

        return session.createQuery("select p from Groups p").getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Session session = connection.getCurrentSession();
        session.delete(session.get(Groups.class,id));

    }

    @Override
    public void updateById(Long id, Groups group) {
        Session session = connection.getCurrentSession();
        Groups groups1=getById(id);
        groups1.setStudents(group.getStudents());
        groups1.setGroupName(group.getGroupName());
        groups1.setCompany(group.getCompany());
        groups1.setCourses(group.getCourses());
        groups1.setDateOfStart(group.getDateOfStart());
        groups1.setDateOfFinish(group.getDateOfFinish());
        session.merge(groups1);
    }

    @Override
    public List<Groups> findAllGroups(Long id) {
        List<Groups> groups = new ArrayList<>();
        Company company =companyDao.getById(id);
        for (Groups groups1 : getALl()){
            Groups groups2 = getById(groups1.getId());
            if (Objects.equals(groups2.getCompany().getId(), company.getId())){
                groups.add(groups2);
            }
        }

        return groups;
    }
}
