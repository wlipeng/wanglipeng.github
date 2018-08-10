package com.wlpdubbo.consumber.demo03;

import com.wlpdubboapi.DubboApiService.DubboApiService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
public class ConsumberController {


    @Resource
    private DubboApiService dubboApiService;

    @RequestMapping(value = "consumber",method = RequestMethod.POST)
    @ResponseBody
    public String consumberd(){
        String a="";
        try{
             a = dubboApiService.dubboapi("aa");
        }catch (Exception e){
            return "fail";
        }

        return a;
    }
}
