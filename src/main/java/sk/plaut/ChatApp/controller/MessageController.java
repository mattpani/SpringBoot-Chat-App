package sk.plaut.ChatApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.plaut.ChatApp.data.Users;
import sk.plaut.ChatApp.services.MessageService;
import sk.plaut.ChatApp.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class MessageController {

    private final MessageService messageService;
    private final UserService userService;

    @Autowired
    public MessageController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @GetMapping(path = "message")
    public String getMessages(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        Users longedInUser = (Users) session.getAttribute("logedInUser");
        String name = longedInUser.getUsername();

        System.out.println(longedInUser.getRoles().toString());
        if (longedInUser.getRoles().toString().contains("Roles{name='ADMIN'}")) {
            if (request.getParameter("user_name") != null) {
                name = request.getParameter("user_name");
            }

            session.setAttribute("list", messageService.getMessages(userService.findByName(name).getId()));
            session.setAttribute("user_name", name);

            return "adminMessageH";
        }

        if (longedInUser.getRoles().toString().contains("Roles{name='USER'}")) {
            session.setAttribute("user_name", longedInUser.getUsername());
            session.setAttribute("list", messageService.getMessages(longedInUser.getId()));

            return "messageH";
        }

        return "error";
    }

}
