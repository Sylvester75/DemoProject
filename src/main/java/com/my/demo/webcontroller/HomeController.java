package com.my.demo.webcontroller;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MethodType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String getHomePage() {
        return "home";
    }
}
