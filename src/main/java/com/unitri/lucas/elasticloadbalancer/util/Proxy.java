package com.unitri.lucas.elasticloadbalancer.util;

import com.unitri.lucas.elasticloadbalancer.repository.impl.ProxyRequest;
import com.unitri.lucas.elasticloadbalancer.service.RequestService;
import com.unitri.lucas.elasticloadbalancer.service.impl.RequestServiceImp;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

public class Proxy extends ProxyServlet {

    //TODO: Inject repositoryRequest here.
    private RequestService requestService = new RequestServiceImp();

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        UUID id = UUID.randomUUID();
        saveRequest(id);
        super.service(req, res);
        saveRequest(id);
    }

    private void saveRequest(UUID id) {

        new Thread(() -> {
            requestService.saveRequestInfo(
                    new ProxyRequest(id, LocalDateTime.now())
            );
        }).start();
    }

}