package com.example.demo.controller;


import com.example.demo.Dao.AreaMapper;
import com.example.demo.Entity.Area;
//import com.example.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.JSON;

@Controller
//@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaMapper areaMapper;

    @ResponseBody
    @RequestMapping(value = "/get", produces = {"application/json;charset=UTF-8"})
    public Map<String,Object> getArea(@PathParam("areaId") Integer areaId){
        Map<String,Object> modelMap= new HashMap<String,Object>() ;
        modelMap.put("area",areaMapper.selectByPrimaryKey(areaId));
        return modelMap;
    }

    @ResponseBody
    @RequestMapping("get/{id}")
    public String findById(@PathVariable("id") Integer id) {
        return JSON.toJSONString(areaMapper.findOne(id));
    }

    @ResponseBody
    @RequestMapping("find")
    public String findUser() {
        return JSON.toJSONString(areaMapper.findAll());
    }

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public Map<String,Object> addArea(Area area){
        Map<String,Object> modelMap= new HashMap<String,Object>() ;
        modelMap.put("success",areaMapper.insertSelective(area)+1);
        return modelMap;
    }
    @ResponseBody
    @GetMapping(value="/del")
    public Map<String,Object> deleteArea(@PathParam("areaId") Integer areaId){
        Map<String,Object> modelMap= new HashMap<String,Object>() ;
        modelMap.put("success",areaMapper.deleteByPrimaryKey(areaId));
        return modelMap;
    }

    @GetMapping("/test")
    public String Test(){
        return "test";
    }
}

    /*
    @ResponseBody
    @RequestMapping(value = "/edit", produces = {"application/json;charset=UTF-8"})
    public Map<String,Object> editArea(Area area){
        Map<String,Object> modelMap= new HashMap<String,Object>() ;
        modelMap.put("success",areaMapper.updateByPrimaryKeySelective(area));
        return modelMap;
    }

    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllArea(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        return areaService.findAllArea(pageNum,pageSize);
    }
    */
