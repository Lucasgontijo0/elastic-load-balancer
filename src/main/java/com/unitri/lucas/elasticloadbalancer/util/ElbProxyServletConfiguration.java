package com.unitri.lucas.elasticloadbalancer.util;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ElbProxyServletConfiguration implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new ProxyDecorator(), propertyResolver.getProperty("servlet_url"));
        servletRegistrationBean.addInitParameter(ProxyDecorator.P_TARGET_URI, propertyResolver.getProperty("target_url"));
        servletRegistrationBean.addInitParameter(ProxyDecorator.P_LOG, propertyResolver.getProperty("logging_enabled", "false"));
        return servletRegistrationBean;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, "proxy.solr.");
    }
}
