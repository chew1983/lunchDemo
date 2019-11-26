package com.facai.controller;

import com.facai.entity.User;
import com.facai.entity.Admin;
import com.facai.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/account")
public class AccountHandler {
    @Autowired
    private AccountFeign accountFeign;
    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type")String type, HttpSession session){
         Object obj=accountFeign.login(username, password, type);
        LinkedHashMap<String,Object> hashMap=(LinkedHashMap)obj;
         System.out.println(obj);
         if(obj!=null){
            switch (type){
                case "user":
                    User user=new User();
                    String strId= hashMap.get("id")+"";
                    Long id= Long.parseLong(strId);
                    user.setId(id);
                    user.setNickname((String) hashMap.get("nickname"));
                    session.setAttribute("user",user);
                    return "index";

                case "admin":
                    Admin admin=new Admin();
                    String strId1= hashMap.get("id")+"";
                    Long id1= Long.parseLong(strId1);
                    admin.setId(id1);
                    admin.setUsername((String) hashMap.get("username"));
                    session.setAttribute("admin",admin);
                    return "main";
            }

         }
       return "login";
    }

}
