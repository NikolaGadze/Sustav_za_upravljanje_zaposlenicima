package ba.sum.fpmoz.ems.services;

import ba.sum.fpmoz.ems.models.Employee;
import ba.sum.fpmoz.ems.models.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees(User user);
    void saveEmployee(Employee employee, User user);
    Employee getEmployeeById(long id, User user);
    void deleteEmployeeById(long id, User user);
    Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection, User user);
}