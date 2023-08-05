package springboot.Project.Emp.service;

import springboot.Project.Emp.entity.Employee;

import java.util.List;
public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee theEmployee);

    void deleteById(int theId);

}
