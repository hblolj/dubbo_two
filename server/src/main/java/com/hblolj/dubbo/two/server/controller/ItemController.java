package com.hblolj.dubbo.two.server.controller;

import com.google.common.collect.Maps;
import com.hblolj.dubbo.one.api.response.BaseResponse;
import com.hblolj.dubbo.one.api.service.IDubboItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hblolj
 * @Date: 2019/7/4 10:42
 * @Description:
 * @Version:
 **/
@Slf4j
@RestController
public class ItemController {

    private static final String prefix = "item";

    @Autowired
    private IDubboItemService dubboItemService;

    @RequestMapping(value = prefix + "/list", method = RequestMethod.GET)
    public Map<String, Object> list(){
        HashMap<String, Object> resMap = Maps.newHashMap();
        resMap.put("code", 0);
        resMap.put("msg", "成功");

        try {
            BaseResponse response = dubboItemService.listItems();
            if (response != null && response.getCode().equals(0)){
                resMap.put("data", response.getData());
            }
        }catch (Exception e){
            e.printStackTrace();
            resMap.put("code", -1);
            resMap.put("msg", "失败");
        }

        return resMap;
    }

    @RequestMapping(value = prefix + "/listPageItems", method = RequestMethod.GET)
    public Map<String, Object> listPageItems(@RequestParam Integer pageNo, @RequestParam Integer pageSize){
        HashMap<String, Object> resMap = Maps.newHashMap();
        resMap.put("code", 0);
        resMap.put("msg", "成功");

        try {
            BaseResponse response = dubboItemService.listPageItems(pageNo, pageSize);
            if (response != null && response.getCode().equals(0)){
                resMap.put("data", response.getData());
            }
        }catch (Exception e){
            e.printStackTrace();
            resMap.put("code", -1);
            resMap.put("msg", "失败");
        }

        return resMap;
    }

    @RequestMapping(value = prefix + "/listPageItemsParams", method = RequestMethod.GET)
    public Map<String, Object> listPageItemsParams(@RequestParam Integer pageNo, @RequestParam Integer pageSize,
                                                   @RequestParam String search){
        HashMap<String, Object> resMap = Maps.newHashMap();
        resMap.put("code", 0);
        resMap.put("msg", "成功");

        try {
            BaseResponse response = dubboItemService.listPageItemsParams(pageNo, pageSize, search);
            if (response != null && response.getCode().equals(0)){
                resMap.put("data", response.getData());
            }
        }catch (Exception e){
            e.printStackTrace();
            resMap.put("code", -1);
            resMap.put("msg", "失败");
        }

        return resMap;
    }
}
