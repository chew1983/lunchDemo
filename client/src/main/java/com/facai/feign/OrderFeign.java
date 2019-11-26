package com.facai.feign;

import com.facai.entity.Order;
import com.facai.entity.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "order")
public interface OrderFeign {
    @PostMapping("/order/save")
    public void save(@RequestBody Order order);
    @GetMapping("/order/findAll/{uid}/{index}/{limit}")
    OrderVO findAllByUid(@PathVariable("uid") long uid, @PathVariable("index")int index, @PathVariable("limit")int limit);
    @GetMapping("/order/findAllByState/{state}/{index}/{limit}")
    OrderVO findAllByState(@PathVariable("state") int state, @PathVariable("index")int index,@PathVariable("limit") int limit);
    @GetMapping("/order/updateState/{id}/{aid}/{state}")
    void updateState(@PathVariable("id") long id, @PathVariable("aid")long aid,@PathVariable("state") int state);
}
