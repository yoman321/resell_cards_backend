package backend.resell_cards_backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

  @GetMapping("http://localhost:5173/login")
  public String login() {
    return "login";
  }
}
