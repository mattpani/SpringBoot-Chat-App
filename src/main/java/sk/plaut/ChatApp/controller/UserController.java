package sk.plaut.ChatApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.plaut.ChatApp.data.Users;
import sk.plaut.ChatApp.repository.RoleRepository;
import sk.plaut.ChatApp.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private final UserService userService;
    private final RoleRepository roleRepository;

    @Autowired
    public UserController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @PostMapping(path = "login")
    public String logIn(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Users user = userService.findByName(request.getParameter("user_name"));

        if (user != null) {
            session.setAttribute("logedInUser", user);
            session.setAttribute("logedInInfo", "Si prihlaseny:" + user.getUsername());
            return "index";
        } else {
            session.setAttribute("logedInInfo", "Pouzivatel nexistuje alebo zadal zle meno.");
            return "login";
        }
    }

    @PostMapping(path = "registration")
    public String addUser(HttpServletRequest request, HttpServletResponse response){
        Users user = new Users();

        user.setUsername(request.getParameter("user_name"));
        user.setRoles(roleRepository.findByRoleId(1));

        request.getSession().setAttribute("regResult", user.getUsername() + " " + userService.addUser(user));
        return "redirect:registration";
    }
}
