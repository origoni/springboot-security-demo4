package com.millky.demo.security.four;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.security.Principal;

@Slf4j
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;


    @GetMapping("/user")
    public String users(Model model, Principal principal) {

        User user = userRepository.findByUsername(principal.getName());

        log.debug("principal={}", principal);
        log.debug("user={}", user);
        model.addAttribute("user", user);

        return "user";
    }

    @PostMapping("/user")
    public String userUpdate(User user) {
        log.debug("user={}", user);

        userService.update(user);

        return "user";
    }

    @ResponseBody
    @PostMapping("/user/email")
    public User userUpdate2(Principal principal, @RequestParam("email") String email) {
        log.debug("email={}", email);

        User user = new User();
        user.setEmail(email);
        user.setUsername(principal.getName());

        return userService.updateEmail(principal.getName(), email);
    }


    @GetMapping("/login")
    public String loginForm(Model model, String status) {
        model.addAttribute("status", status);
        return "login";
    }


    // for form
//    @ModelAttribute
//    public User formUser() {
//        return new User();
//    }

    @GetMapping("/join")
    public String joinForm(User user) { // for form
        return "join";
    }

    @PostMapping("/join")
    public String join(@Valid User user, Errors errors) {

        if (errors.hasErrors()) return "join";

        userService.join(user);
        return "redirect:/login?status=joinSuccess";
    }
}
