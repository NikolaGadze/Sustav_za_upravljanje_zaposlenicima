package ba.sum.fpmoz.ems.services;

import ba.sum.fpmoz.ems.models.Employee;
import ba.sum.fpmoz.ems.models.User;
import ba.sum.fpmoz.ems.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees(User user) {
        return employeeRepository.findByUser(user);
    }

    @Override
    public void saveEmployee(Employee employee, User user) {
        employee.setUser(user);
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id, User user) {
        Optional<Employee> optional = employeeRepository.findByIdAndUser(id, user);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(long id, User user) {
        Employee employee = getEmployeeById(id, user);
        this.employeeRepository.delete(employee);
    }

    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection, User user) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.employeeRepository.findByUser(user, pageable);
    }
}