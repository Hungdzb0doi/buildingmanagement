package com.BuildingWeb.Present;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Webcontroller {
    @GetMapping("/interface/insertbuilding")
    public String InsertBuilding(){
        return "forward:/InsertBuilding.html";
    }
    @GetMapping("/interface/register")
    public String Register(){
        return "forward:/Register.html";
    }
    @GetMapping("/interface/login")
    public String Login(){
        return "forward:/Login.html";
    }
    @GetMapping("/interface/user")
    public String User(){
        return "forward:/User.html";
    }
    @GetMapping("/interface/customer")
    public String Customer(){
        return "forward:/Customer.html";
    }
    @GetMapping("/interface/transaction")
    public String Transaction(){
        return "forward:/Transaction.html";
    }
    @GetMapping("/interface/dashboard")
    public String Dashboard(){
        return "forward:/Dashboard.html";
    }
    @GetMapping("/interface/building")
    public String Building(){
        return "forward:/Building.html";
    }
    @GetMapping("/interface/updatebuilding")
    public String UpdateBuilding(){
        return "forward:/UpdateBuilding.html";
    }
}
