package com.wlpdubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.alibaba.dubbo.rpc.Exporter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.dubbo.config.ProviderConfig;

@Configuration
@ConditionalOnClass(Exporter.class)
public class ProdiverConfiga {

    /*
    *
    * 注意：：：：jar包问题
    * */

    /*
    * 设置提供方信息的配置
    * */
    @Bean
    @ConditionalOnMissingBean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("provider");
        System.out.println(applicationConfig);
        return applicationConfig;
    }

    /*
    * 注册中心地址
    * */
    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setProtocol("zookeeper");
        return registryConfig;
    }

    /*
    暴露服务：相等于消费者通过协议调提供者
    * name:协议；port：端口（可以不写，会随机生成）
    * */
    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }


    /*
    * 提供者
    * */
    @Bean
    public ProviderConfig prodiverConfig(@Qualifier("registryConfig") RegistryConfig registryConfig){
        ProviderConfig prodiverConfig = new ProviderConfig();
        prodiverConfig.setRegistry(registryConfig);
        return prodiverConfig;
    }

}
