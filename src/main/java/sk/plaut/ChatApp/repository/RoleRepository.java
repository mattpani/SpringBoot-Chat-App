package sk.plaut.ChatApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.plaut.ChatApp.data.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Long> {

    Roles findByRoleId (Integer id);

}
