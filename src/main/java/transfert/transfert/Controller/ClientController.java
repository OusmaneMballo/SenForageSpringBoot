package transfert.transfert.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import transfert.transfert.DAO.ClientRepository;
import transfert.transfert.DAO.VillageRepository;
import transfert.transfert.Model.Client;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientRepository clientRepos;
    @Autowired
    VillageRepository villageRepos;

    @GetMapping("/home")
    public String index(Model model){

        model.addAttribute("clients", clientRepos.findAll());
        model.addAttribute("villages", villageRepos.findAll());

        return "client/index";
    }

    @PostMapping("/ajout")
    public String add(@Validated Client client, int id){

        try{
            /*if(!result.hasErrors()){

            }*/
            clientRepos.save(client);
        }catch(Exception exception){
            exception.getStackTrace();
        }
        return "redirect:/client/home";
    }
}
