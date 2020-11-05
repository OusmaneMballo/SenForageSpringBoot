package transfert.transfert.Controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Configuration
@Controller
public class HomeController {
    @RequestMapping("/login")
    public String index(Principal principal){
        return "index";
    }


}
