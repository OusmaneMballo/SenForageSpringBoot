package transfert.transfert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TransfertApplication implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepo;
    public static void main(String[] args) {
        SpringApplication.run(TransfertApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        List<Role> listRoles=roleRepo.findAll();
        if(listRoles.isEmpty()){
            Role r=new Role();
            r.setLibelle("Super_admin");
            roleRepo.save(r);
        }
    }
}
