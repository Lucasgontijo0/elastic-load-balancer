package com.unitri.lucas.elasticloadbalancer.util.math;

import com.unitri.lucas.elasticloadbalancer.repository.entity.ProxyRequest;
import com.unitri.lucas.elasticloadbalancer.util.math.representation.ServiceRepresentation;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class ServiceRate {

    /*

        Taxa de atendimento dos clientes  Taxa (número de clientes / unid. tempo)
        segundo a qual um canal de atendimento ou servidor pode efetuar o atendimento de
        um cliente O valor médio da taxa de atendimento é µ (mu).

        μ = ∑(tempo de serviço) / qtd requisições

     */

    private List<ProxyRequest> proxyRequests;
    private Timestamp startDate;
    private Timestamp endDate;

    public ServiceRate(List<ProxyRequest> proxyRequests, Timestamp startDate, Timestamp endDate) {
        this.proxyRequests = proxyRequests;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ServiceRepresentation calculateServiceRate() {

        Double sumService = 0.0;

        for (ProxyRequest proxyRequest: this.proxyRequests) {
            sumService += proxyRequest.getServiceTime();
        }

        long ammount = this.proxyRequests.size();

        Double serviceRate = sumService / ammount;

        Long duration = endDate.getTime() - startDate.getTime();

        return new ServiceRepresentation(startDate, endDate, duration, ammount, serviceRate);

    }
}
