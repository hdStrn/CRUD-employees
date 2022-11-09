package crudemployees.dao;

import crudemployees.entity.Department;

import java.util.List;

public interface DepartmentDAO {

    List<Department> getAllDepartments();

    void saveDepartment(Department department);

    void deleteDepartment(int id);
}
