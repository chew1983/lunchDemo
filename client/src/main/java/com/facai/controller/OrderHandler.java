package com.facai.controller;

import com.facai.entity.*;
import com.facai.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderHandler {
    @Autowired
    private OrderFeign orderFeign;
    @GetMapping("/save/{mid}")
    public String save(@PathVariable("mid")Long mid, HttpSession session){
        User user= (User) session.getAttribute("user");
        Order order=new Order();
        order.setUser(user);
        Menu menu=new Menu();
        menu.setId(mid);
        order.setMenu(menu);
        this.orderFeign.save(order);
        return "order";
    }
    @GetMapping("/findAllByUid")
    @ResponseBody
    public OrderVO findAllByUid(@RequestParam("page") int page,@RequestParam("limit") int limit, HttpSession session){
        int index=(page-1)*limit;
        User user= (User) session.getAttribute("user");
        return this.orderFeign.findAllByUid(user.getId(),index,limit);
    }
    @GetMapping("/findAllByState")
    @ResponseBody
    public OrderVO findAllByState(@RequestParam("page")int page,@RequestParam("limit")int limit){
        int index=(page-1)*limit;
        int state=0;
        return this.orderFeign.findAllByState(state,index,limit);
    }
    @GetMapping("/updateState/{id}/{state}")
    public String updateState(@PathVariable("id") int id,@PathVariable("state")int state,HttpSession session){
        Admin admin=(Admin)session.getAttribute("admin");
        this.orderFeign.updateState(id,admin.getId(),state);
        return "redirect:/menu/redirect/order_handler";
    }
}
