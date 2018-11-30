package com.example.demo.web;
import com.example.demo.web.storeToDb;
import com.example.demo.Repo.StoreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@Controller
public class storeToDbController {
    @Autowired
    private StoreRepository storeRepo;
    @GetMapping("/store")
    public String storeToDbForm(Model model) {
        model.addAttribute("storeToDb", new storeToDb("123"));
        return "storeToDb";
    }

    @PostMapping("/store")
    public String storeToDbSubmit(@ModelAttribute storeToDb storeToDb) {
        return "result3";
    }


    @RequestMapping("/addstore")
    @ResponseBody
    public String addstoreToDb( @RequestParam("id") int id, @RequestParam("str") String str, @RequestParam("strInt") int strInt)

    {
        if(storeRepo.addstoreToDb(id,str,strInt) >= 1){
            return "Number Added Successfully";
        }else{
            return "Something went wrong !";
        }
    }



}