package transfert.transfert.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import transfert.transfert.DAO.VillageRepository;
import transfert.transfert.Model.Village;

@Controller
@RequestMapping("/village")
public class VillageController {

    @Autowired
    VillageRepository villageRepos;
    @GetMapping("/home")
    public String index(Model model){
        model.addAttribute("villages", villageRepos.findAll());
        return "village/index";
    }

    @PostMapping("/ajout")
    public String add(@Validated Village village, BindingResult result){
        try{
                if (!result.hasErrors()){
                    villageRepos.save(village);
                }
        }catch (Exception exception){
            exception.getStackTrace();
        }
        return "redirect:/village/home";
    }


}
