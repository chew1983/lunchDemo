package com.facai.controller;

import com.facai.entity.Menu;
import com.facai.entity.MenuVO;
import com.facai.entity.Type;
import com.facai.repository.MenuRepository;
import com.facai.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuHandler  {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private TypeRepository typeRepository;
    @GetMapping("/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        return new MenuVO(0,"",menuRepository.count(),menuRepository.findAll((index-1)*limit,limit));
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id")Long id){
       menuRepository.deleteById(id);
    }
    @GetMapping("/findTypes")
    public List<Type> findTypes(){
        return typeRepository.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        this.menuRepository.save(menu);
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") Long id){
        return this.menuRepository.findById(id);
    }
    @PutMapping("/update")
    public void update(@RequestBody Menu menu){
        this.menuRepository.update(menu);
    }

}
