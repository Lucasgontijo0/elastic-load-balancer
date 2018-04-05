package com.unitri.lucas.elasticloadbalancer.util.math.representation;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

public class RequestsRepresentation {

    private Timestamp startDate;
    private Timestamp endDate;
    private long requestAmmount;
    private BigDecimal requestAverage;

    public RequestsRepresentation(Timestamp startDate, Timestamp endDate, long requestAmmount, BigDecimal requestAverage) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.requestAmmount = requestAmmount;
        this.requestAverage = requestAverage;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public long getRequestAmmount() {
        return requestAmmount;
    }

    public BigDecimal getRequestAverage() {
        return requestAverage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestsRepresentation that = (RequestsRepresentation) o;
        return requestAmmount == that.requestAmmount &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(requestAverage, that.requestAverage);
    }
}
