package crudemployees.dao;

import crudemployees.entity.Department;
import crudemployees.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Department> getAllDepartments() {
        Session session = sessionFactory.getCurrentSession();
        List<Department> departments = session.createQuery("from Department", Department.class).getResultList();
        return departments;
    }

    @Override
    public void saveDepartment(Department department) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(department);
    }

    @Override
    public void deleteDepartment(int id) {
        Session session = sessionFactory.getCurrentSession();
        Department department = session.get(Department.class, id);
        List<Employee> employees = employeeDAO.getAllEmployees();
        for (Employee employee : employees) {
            if (department.equals(employee.getDepartment())) employee.setDepartment(null);
        }
        session.delete(department);
    }
}
