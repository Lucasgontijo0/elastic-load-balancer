package com.unitri.lucas.elasticloadbalancer.util;

import com.unitri.lucas.elasticloadbalancer.repository.model.ProxyRequest;
import com.unitri.lucas.elasticloadbalancer.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

public class ProxyDecorator extends ProxyServlet {

    @Autowired
    RequestService requestService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        UUID id = UUID.randomUUID();
        saveRequest(id);
        super.service(req, res);
        saveRequest(id);
    }

    private void saveRequest(UUID id) {
        new Thread(() -> {
            requestService.saveRequestInfo (makeProxyRequest(id));
        }).start();
    }

    @Bean
    private ProxyRequest makeProxyRequest(UUID id){
        return new ProxyRequest(id, LocalDateTime.now());
    }
}