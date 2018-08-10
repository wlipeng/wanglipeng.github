package com.wlpdubbo.scanConfig;

import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.alibaba.dubbo.rpc.Exporter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Exporter.class)
public class ScanConfig {

    /*
    * 配置dubbo扫描包，也可以写在ProdiverConfiga
    * */
    @Bean
    public AnnotationBean annotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage("com.wlpdubbo.cedubboImpll");
        return annotationBean;
    }
}
