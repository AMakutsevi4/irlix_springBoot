package ru.irlix.springBoot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.irlix.springBoot.model.Employee;
import ru.irlix.springBoot.model.Manager;
import ru.irlix.springBoot.repository.EmployeeRepository;
import ru.irlix.springBoot.repository.ManagerRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final ManagerRepository managerRepo;

    public List<Employee> getAllEmployees() {
        return employeeRepo.getAllEmployees();
    }

    public List<Manager> getAllManagers() {
        return managerRepo.getAllManagers();
    }

    public void saveEmployee(Employee employee) {
        Manager manager = managerRepo.getManagerById(employee.getManager().getId());
        employee.setManager(manager);

        employeeRepo.saveEmployee(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepo.getEmployeeById(id);
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployee(id);
    }
}
