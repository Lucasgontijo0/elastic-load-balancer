package com.unitri.lucas.elasticloadbalancer.util.math;

import com.unitri.lucas.elasticloadbalancer.util.math.representation.ArrivalRepresentation;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ArrivalRate {

    /*
        Taxa de chegada dos clientes - Taxa (número de clientes / unid. tempo) segundo a
        qual os clientes chegam para serem atendidos. O valor médio da taxa de chegada é
        representado por λ (lambda). Como é raro um processo onde taxa de chegada dos
        clientes seja regular, ou seja, não existe nenhuma variação entre os valores para os
        intervalos entre chegadas, são adotadas distribuições de freqüência (normal,
        Poisson, exponencial etc.) para representar o processo. O mesmo modelo com
        distribuição normal pode diferir significativamente em termos de resultado do que
        com uma distribuição de Poisson.

        λ = Nº Chegadas / Tempo

    */

    private long requestAmmount;
    private Timestamp startDate;
    private Timestamp endDate;

    public ArrivalRate(long requestAmmount, Timestamp startDate, Timestamp endDate) {
        this.requestAmmount = requestAmmount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ArrivalRepresentation calculateArrivalRate() {
        return null;
    }
}
