package com.facai.controller;

import com.facai.entity.Menu;
import com.facai.entity.MenuVO;
import com.facai.entity.User;
import com.facai.entity.UserVO;
import com.facai.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserFeign userFeign;
    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        return this.userFeign.findAll(page, limit);
    }
    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id")Long id){
        this.userFeign.deleteById(id);
        return "redirect:/user/redirect/user_manage";
    }
    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }
    @PostMapping("/save")
    public String save(User user){
        this.userFeign.save(user);
        return "redirect:/user/redirect/user_manage";
    }
    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") Long id){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("user_update");
        modelAndView.addObject("user",this.userFeign.findById(id));
        return modelAndView;
    }
    @PostMapping("/update")
    public String update(User user){
        this.userFeign.update(user);
        return "redirect:/menu/redirect/user_manage";
    }
}
