package com.wlpdubbo.consumber;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.alibaba.dubbo.config.spring.ReferenceBean;
import com.alibaba.dubbo.rpc.Exporter;
import com.wlpdubboapi.DubboApiService.DubboApiService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javassist.ClassPool;

import java.lang.ref.Reference;

@Configuration
@ConditionalOnClass(Exporter.class)
public class ConsumerConfiga {

    /*
    *
    * 可以使用配置文件（如：application.properties），但优先级比xml慢
    * */

    /*
    *
    * 消费者信息，名字随便定
    * */
    @Bean
   @ConditionalOnMissingBean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("consumber2");
        return applicationConfig;
    }

    /*
    * 超时时间
    * */
    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setTimeout(3000);
        return consumerConfig;
    }

    /*
    * 注册中心
    * */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setProtocol("zookeeper");
        return registryConfig;
    }
    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        return protocolConfig;
    }

  /*  @Bean
    public AnnotationBean annotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage("com.wlpdubbo.consumber.demo03");
        return annotationBean;
    }*/


  /*
  * 调用接口的配置
  * */
    @Bean
    public ReferenceBean<DubboApiService> dubboApiServiceReferenceBean(@Qualifier("registryConfig") RegistryConfig registryConfig){
        ReferenceBean<DubboApiService> referenceBean = new ReferenceBean<>();
        referenceBean.setInterface(DubboApiService.class);
        //referenceBean.setId("dubboapiservice");
        //referenceBean.setFilter("simpleconsumerfilter");
        referenceBean.setRegistry(registryConfig);
        referenceBean.setTimeout(20000);
        referenceBean.setRetries(0);
        referenceBean.setCheck(false);
        return referenceBean;
    }
}
