package com.facai.feign;


import com.facai.entity.Menu;
import com.facai.entity.MenuVO;
import com.facai.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "menu")
public interface MenuFeign {
    @GetMapping("/menu/findAll/{page}/{limit}")
    public MenuVO findAll(@PathVariable("page") int page, @PathVariable("limit") int limit);
    @DeleteMapping("/menu/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id);
    @GetMapping("/menu/findTypes")
    public List<Type> findTypes();
    @PostMapping("/menu/save")
    public void save(Menu menu);
    @GetMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable("id") Long id);
    @PutMapping("/menu/update")
    public void update(Menu menu);
}
