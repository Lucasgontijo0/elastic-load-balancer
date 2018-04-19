package com.unitri.lucas.elasticloadbalancer.util.proxy;

import com.unitri.lucas.elasticloadbalancer.repository.RepositoryRequest;
import com.unitri.lucas.elasticloadbalancer.repository.entity.ProxyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.sql.Timestamp;
import java.time.Instant;
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
    public void service(ServletRequest req, ServletResponse res) {

        UUID id = UUID.randomUUID();

        Timestamp startTime = Timestamp.from(Instant.now());

        String status = "SUCCESS";

        try {
            super.service(req, res);
        } catch (Exception e) {
            status = "ERROR";
        } finally {
            Timestamp endTime = Timestamp.from(Instant.now());
            long serviceTime = endTime.getTime() - startTime.getTime();
            repositoryRequest.save(makeProxyRequest(id, status, startTime, endTime, serviceTime));
        }
    }




    @Bean
    private ProxyRequest makeProxyRequest(UUID id, String status, Timestamp arrivalTime, Timestamp exitTime,
                                          long tempoDeServico) {
        return new ProxyRequest(id, status, arrivalTime, exitTime, tempoDeServico);
    }
}