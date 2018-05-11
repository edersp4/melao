package br.com.melao.corretora.service.bootstrap;

import br.com.melao.corretora.model.comum.Role;
import br.com.melao.corretora.model.comum.User;
import br.com.melao.corretora.service.comum.UserService;
import br.com.melao.corretora.service.seguranca.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {


    UserService userService;
    RoleService roleService;



    @Autowired
    public SpringJPABootstrap(UserService userService , RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadUsers();
        loadRoles();
        loadAssignUsersToDefaultRole();
        loadSeguradora();
    }

    public void loadSeguradora() {

    }

    public void loadUsers(){
        User user1 = new User();
        user1.setUsername("ed");
        user1.setPassword("melao@123");

        userService.save(user1);


        User user2 = new User();
        user2.setUsername("admin");
        user2.setPassword("navio");

        userService.save(user2);

        User user3 = new User();
        user3.setUsername("kelly");
        user3.setPassword("melao@123");

        userService.save(user3);
    }

    public void loadRoles(){
        Role role = new Role();
        role.setRole("CUSTUMER");
        roleService.save(role);
    }


    public void loadAssignUsersToDefaultRole(){
        List<Role> roles = roleService.findAll();
        List<User> users = userService.findAll();

        roles.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("CUSTUMER")) {
                users.forEach(user -> {
                    user.addRole(role);
                    userService.save(user);
                });
            }
        });
    }



}
