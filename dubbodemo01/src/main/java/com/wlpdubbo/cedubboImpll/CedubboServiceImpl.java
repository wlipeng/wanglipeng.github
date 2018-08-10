package com.wlpdubbo.cedubboImpll;

import com.alibaba.dubbo.config.annotation.Service;
import com.wlpdubboapi.DubboApiService.DubboApiService;

/*
* 必须使用dubbo的service，用别的无法使用dubbo
* */
@Service
public class CedubboServiceImpl implements DubboApiService {
/*
* 实现接口
* */
    @Override
    public String dubboapi(String name) {
        if(name == null){
           return "aha";
        }

        return "wlp";
    }
}
