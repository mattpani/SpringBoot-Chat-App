package sk.plaut.ChatApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

  @GetMapping("/")
  public String welcomePage() {
        return "index";
  }

  @GetMapping("login")
  public String loginPage() {
        return "login";
  }

  @GetMapping("registration")
  public String registerPage() {
      return "registration";
  }

}