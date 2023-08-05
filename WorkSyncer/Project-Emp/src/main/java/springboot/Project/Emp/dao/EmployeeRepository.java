package springboot.Project.Emp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.Project.Emp.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    // no need to write any code :-)!
    //add an method to sort the employee by firstname
    public List<Employee> findAllByOrderByFirstNameAsc();
}
