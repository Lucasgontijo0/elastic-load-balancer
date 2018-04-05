package com.unitri.lucas.elasticloadbalancer.util.proxy;

import com.unitri.lucas.elasticloadbalancer.repository.RepositoryRequest;
import com.unitri.lucas.elasticloadbalancer.repository.entity.ProxyRequest;
import com.unitri.lucas.elasticloadbalancer.util.proxy.ProxyServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public class ProxyDecorator extends ProxyServlet {

    @Autowired
    RepositoryRequest repositoryRequest;

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
            repositoryRequest.save(makeProxyRequest(id));
        }).start();
    }

    @Bean
    private ProxyRequest makeProxyRequest(UUID id) {
        return new ProxyRequest(id, Timestamp.from(Instant.now()));
    }
}