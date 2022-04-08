package sk.plaut.ChatApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.plaut.ChatApp.data.Roles;
import sk.plaut.ChatApp.repository.RoleRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<Roles> findRoleById(Long id) {
        return roleRepository.findById(id);
    }
}
