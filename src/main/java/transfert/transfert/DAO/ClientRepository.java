package transfert.transfert.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import transfert.transfert.Model.Client;
import transfert.transfert.Model.Village;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
        public Client findById(int id);
        public List<Client> findByVillage(Village village);

}
