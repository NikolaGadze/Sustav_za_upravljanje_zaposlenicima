package ba.sum.fpmoz.ems.services;

import ba.sum.fpmoz.ems.models.User;
import ba.sum.fpmoz.ems.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
    User findByEmail(String email);
}