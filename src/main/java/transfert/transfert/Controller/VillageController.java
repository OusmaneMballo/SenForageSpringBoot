package transfert.transfert.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import transfert.transfert.DAO.VillageRepository;
import transfert.transfert.Model.Village;

@Controller
@RequestMapping("/village")
public class VillageController {

    @Autowired
    VillageRepository villageRepos;
    @GetMapping("/home")
    public String index(){
        Village village=new Village();
        village.setNom("Diamweli");
        villageRepos.save(village);
        return "village/index";
    }
}
