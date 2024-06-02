package ba.sum.fpmoz.ems.repositories;

import ba.sum.fpmoz.ems.models.Employee;
import ba.sum.fpmoz.ems.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByUser(User user);
    Optional<Employee> findByIdAndUser(Long id, User user);
    Page<Employee> findByUser(User user, Pageable pageable);
}