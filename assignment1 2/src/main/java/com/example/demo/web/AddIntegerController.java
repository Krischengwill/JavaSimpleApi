package com.example.demo.web;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class AddIntegerController {
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("addInteger", new AddInteger());
        return "addInteger";
    }
    @PostMapping("/add")
    public String addSubmit(@ModelAttribute AddInteger addInteger) {
        return "result2";
    }
}
