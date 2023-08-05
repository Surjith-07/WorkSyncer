package springboot.Project.Emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.Project.Emp.entity.Employee;
import springboot.Project.Emp.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // load employee data
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        List<Employee> list=employeeService.findAll();
        // add to the spring model
        theModel.addAttribute("employees",list);
        return "employees/list-employees";
    }
    @GetMapping("/showFormForAdd")
    public String showFromForAdd(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model){
        //get the Employee from the Service
        Employee employee=employeeService.findById(theId);
        //set employee in the model to prepopulate it
        model.addAttribute("employee",employee);
        //send over the to the form
        return "employees/employee-form";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        //save Employee
        employeeService.save(employee);
        //Redirect to prevent duplicate submission
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){
        //delete the employee by their id
        employeeService.deleteById(theId);
        //redirect to the home page (employees/list)
        return "redirect:/employees/list";
    }

}










