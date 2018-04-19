package com.unitri.lucas.elasticloadbalancer.util.math;

import com.unitri.lucas.elasticloadbalancer.util.math.representation.ServiceRepresentation;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ServiceRate {

    /*

        Taxa de atendimento dos clientes - Taxa (número de clientes / unid. tempo)
        segundo a qual um canal de atendimento ou servidor pode efetuar o atendimento de
        um cliente O valor médio da taxa de atendimento é µ (mu). É importante ressaltar
        que o valor desta taxa é considerado como se o servidor estivesse ocupado 100%
        do seu tempo. Como há tempo ocioso, a distribuição de freqüência (normal,
        Poisson, exponencial etc.) deste valor é igualmente importante na determinação do
        grau de complexidade matemática. O pressuposto mais comum é a distribuição de
        Poisson, porém exige que os eventos de chegada e atendimento sejam
        completamente independentes. Em todos os casos, os resultados são valores
        médios ou esperados e supõe-se que as taxas se mantêm constantes ao longo do
        tempo. De fato, isto pode não ser verdade, uma vez que podem ocorrer alterações
        no processo tão logo a fila assuma um valor muito alto.

        μ = ∑(tempo de serviço) / qtd requisições

     */

    private long requestAmmount;
    private Timestamp startDate;
    private Timestamp endDate;

    public ServiceRate(long requestAmmount, Timestamp startDate, Timestamp endDate) {
        this.requestAmmount = requestAmmount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ServiceRepresentation calculateServiceRate(){
        return null;
    }
}
