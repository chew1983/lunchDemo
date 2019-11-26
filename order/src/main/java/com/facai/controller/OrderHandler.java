package com.facai.controller;

import com.facai.entity.Order;
import com.facai.entity.OrderVO;
import com.facai.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderHandler {
    @Value("${server.port}")
    private String port;
    @Autowired
    private OrderRepository orderRepository;
    @GetMapping("/index")
    public String index(){
        return this.port;
    }
    @PostMapping("/save")
    public void save(@RequestBody Order order){
        order.setDate(new Date());
        this.orderRepository.save(order);
    }
    @GetMapping("/findAll/{uid}/{index}/{limit}")
    OrderVO findAllByUid(@PathVariable("uid") long uid, @PathVariable("index")int index, @PathVariable("limit")int limit){
        OrderVO orderVO=new OrderVO();
        List<Order> list=orderRepository.findAllByUid(uid, index, limit);
        orderVO.setMsg("");
        orderVO.setCount(this.orderRepository.countByUid(uid));
        orderVO.setData(list);
        return orderVO;
    }
    @GetMapping("/countByUid/{uid}")
    int countByUid(@PathVariable("uid") long uid){
        return this.orderRepository.countByUid(uid);
    }
    @GetMapping("/findAllByState/{state}/{index}/{limit}")
    OrderVO findAllByState(@PathVariable("state") int state, @PathVariable("index")int index,@PathVariable("limit") int limit){
        OrderVO orderVO=new OrderVO();
        orderVO.setCount(this.orderRepository.countByState(state));
        orderVO.setData(this.orderRepository.findAllByState(state, index, limit));
        orderVO.setMsg("");
        return orderVO;
    }
    @GetMapping("/updateState/{id}/{aid}/{state}")
    void updateState(@PathVariable("id") long id, @PathVariable("aid")long aid,@PathVariable("state") int state){
        this.orderRepository.updateState(id, aid, state);
    }
}
