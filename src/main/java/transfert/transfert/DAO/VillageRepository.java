package transfert.transfert.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import transfert.transfert.Model.Village;

@Repository
public interface VillageRepository extends JpaRepository<Village, Integer> {
    Village findById(int id);
}
