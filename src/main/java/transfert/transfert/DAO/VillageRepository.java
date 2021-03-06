package transfert.transfert.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import transfert.transfert.Model.Client;
import transfert.transfert.Model.Village;

import java.util.List;

@Repository
public interface VillageRepository extends JpaRepository<Village, Integer> {
    Village findById(int id);
    Village findByClients(Client client);
}
