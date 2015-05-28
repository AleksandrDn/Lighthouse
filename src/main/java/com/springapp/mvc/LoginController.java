package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping("login")
    public ModelAndView getLoginForm(
            @RequestParam(required = false) String authfailed, String logout,
            String denied) {
        String message = "";
        if (authfailed != null) {
            message = "Неправильный адрес электронной почты или пароль ";
        } else if (logout != null) {
            message = "Вы вышли из учетной записи";
        } else if (denied != null) {
            message = "Доступ запрещен";
        }
        return new ModelAndView("login", "message", message);
    }

    @RequestMapping("user/indexUser")
    public String geUserPage() {
        return "user/indexUser";
    }

    @RequestMapping("403page")
    public String ge403denied() {
        return "redirect:login?denied";
    }
}