package ie.keithmurphy.hertzassignment.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class error {

    @GetMapping("/error")
    public String error(){

        return "error";
    }
}
