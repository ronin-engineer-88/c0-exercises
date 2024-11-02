package src.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.entity.Admin;
import src.exception.AdminException.AdminNotFoundException;
import src.repository.AdminRepository;

@Service
public class AdminValidateService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminValidateService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin validateLoginUsername(String username) {
        return adminRepository.findActiveAdminByUsername(username)
                .orElseThrow(() -> new AdminNotFoundException("Incorrect username!"));
    }

}
