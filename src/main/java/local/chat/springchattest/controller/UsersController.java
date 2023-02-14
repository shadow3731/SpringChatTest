package local.chat.springchattest.controller;

import local.chat.springchattest.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

    private UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }


    @GetMapping("/users/count")
    public int countUsers() {
        System.out.println(usersService.countAllUsers());
        return usersService.countAllUsers();
    }
}
