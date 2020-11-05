package transfert.transfert.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import transfert.transfert.Model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
