package com.facai.controller;

import com.facai.entity.Menu;
import com.facai.entity.MenuVO;
import com.facai.entity.Type;
import com.facai.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuHandler {
    @Autowired
    private MenuFeign menuFeign;
    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        return menuFeign.findAll(page, limit);
    }
    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id")Long id){
        menuFeign.deleteById(id);
        return "redirect:/menu/redirect/menu_manage";
    }
    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }
    @GetMapping("/findTypes")
    public ModelAndView findTypes(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("menu_add");
        modelAndView.addObject("list",this.menuFeign.findTypes());
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(Menu menu){
        this.menuFeign.save(menu);
        return "redirect:/menu/redirect/menu_manage";
    }
    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") Long id){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("menu_update");
        modelAndView.addObject("menu",this.menuFeign.findById(id));
        modelAndView.addObject("list",this.menuFeign.findTypes());
        return modelAndView;
    }
    @PostMapping("/update")
    public String update(Menu menu){
        this.menuFeign.update(menu);
        return "redirect:/menu/redirect/menu_manage";
    }
}
