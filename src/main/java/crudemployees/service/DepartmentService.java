package crudemployees.service;

import crudemployees.entity.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartments();

    void saveDepartment(Department department);

    void deleteDepartment(int id);
}
