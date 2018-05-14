package com.unitri.lucas.elasticloadbalancer.controllers;

import com.unitri.lucas.elasticloadbalancer.service.MetricsService;
import com.unitri.lucas.elasticloadbalancer.util.math.representation.ArrivalRepresentation;
import com.unitri.lucas.elasticloadbalancer.util.math.representation.RequestsRepresentation;
import com.unitri.lucas.elasticloadbalancer.util.math.representation.ServiceRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MetricaController extends HttpServlet {

    @Autowired
    private MetricsService metricsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

        System.out.println(metricsService.getArrivalRate());
        System.out.println(metricsService.getRequestsAverage());
        System.out.println(metricsService.getServiceRate());
    }
}
