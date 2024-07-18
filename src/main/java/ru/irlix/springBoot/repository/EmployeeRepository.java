package ru.irlix.springBoot.repository;

import org.springframework.stereotype.Repository;
import ru.irlix.springBoot.model.Employee;
import ru.irlix.springBoot.model.Manager;
import ru.irlix.springBoot.model.Weapon;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private final List<Employee> employeeList = new ArrayList<>();
    private Long employee_Id = 1L;


    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(Long id) {
        return employeeList.stream().
                filter(e -> e.getId().equals(id))
                .findFirst().orElse(null);
    }

    public void saveEmployee(Employee employee) {
        employee.setId(employee_Id++);
        employeeList.add(employee);
        Manager manager = employee.getManager();
        manager.getEmployees().add(employee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        Manager manager = employee.getManager();
        manager.getEmployees().remove(employee);
        employeeList.remove(employee);
    }

    public void update(Long id, Employee employee) {
        Employee update = getEmployeeById(id);
        update.setFirstName(employee.getFirstName());
        update.setLastName(employee.getLastName());
        update.setAge(employee.getAge());
        update.setExperience(employee.getExperience());
        update.setManager(employee.getManager());
    }
}
