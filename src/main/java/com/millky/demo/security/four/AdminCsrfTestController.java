package com.millky.demo.security.four;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class AdminCsrfTestController {

    @GetMapping("/admin")
    public String users(Model model) {

        String xss = "<script>\n" +
                "alert('This can happen if \\'XSS\\' is not blocked well.\\n\\ntoken: ' + token + '\\nheader: ' + header);\n" +
                "$.post('/user/email', 'email=csrf@xss.omg', function (data, status) { alert('Cross Site Request Forgery\\n\\nUpdated Email: ' + data.email + '\\nStatus: ' + status); });\n" +
                "</script>";

        log.debug("xss = ", xss);

        model.addAttribute("xssContent", xss);

        return "admin";
    }
}
