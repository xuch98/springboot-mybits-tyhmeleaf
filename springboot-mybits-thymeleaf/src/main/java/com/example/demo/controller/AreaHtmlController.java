package com.example.demo.controller;

import com.example.demo.Dao.AreaMapper;
import com.example.demo.Entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AreaHtmlController{
    @Autowired
    private AreaMapper areaMapper;

    @GetMapping("/addArea")
    public String addArea(Model model) {
        model.addAttribute("msg","Spring boot集成Thymeleaf");
        model.addAttribute("area", new Area());
        return "addArea";  //在templates中寻找addArea.html,而不会陷入循环
    }
    @RequestMapping(value = "/addArea",method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public String addArea(@Valid @ModelAttribute Area area, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {  // in com..Entity @NotEmpty  @Size(min=2, max=30)  and @Valid
            return "addArea";   //@ModelAttribute Area area --https://www.cnblogs.com/zhangshitong/p/5342076.html
        }else{
            Map<String,Object> modelMap= new HashMap<String,Object>() ;
            modelMap.put("success",areaMapper.insertSelective(area));
            return "result";
        }
    }
}