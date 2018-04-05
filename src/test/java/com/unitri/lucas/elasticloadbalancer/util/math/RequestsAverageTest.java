package com.unitri.lucas.elasticloadbalancer.util.math;

import com.unitri.lucas.elasticloadbalancer.repository.entity.ProxyRequest;
import com.unitri.lucas.elasticloadbalancer.util.math.representation.RequestsRepresentation;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class RequestsAverageTest {

    private List<ProxyRequest> requests;

    @Before
    public void setUp() throws Exception {
        this.requests = new ArrayList<>();
        String[] ids = {
                "36fed9da-36dd-43fe-bfc0-bb52c92da4d5",
                "1a670c07-75ac-4f71-a004-8baa9832c156",
                "d3701970-2246-4665-bcac-6fb80fc626c0",
                "6ec9c275-8d45-4a7c-84a4-34761e6bcf02",
                "92c4802d-cf67-4ec7-8bd6-6979df71407d",
                "8082a46d-f8db-4d7b-b959-b9c132663d91",
                "216e912c-e855-4b58-84f1-0656863eea8f",
                "d999963f-f90e-4811-b385-c0c3b33655f4",
                "6b09552f-5c41-48df-92a3-878baee47a9a",
                "07225ace-eef3-40bb-a16f-34dba9aa4fee" };

        for (String id : ids) {
            this.requests.add(new ProxyRequest(UUID.fromString(id), Timestamp.valueOf(LocalDateTime.of(2018, 1, 2, 13, 1, 0, 0))));
            this.requests.add(new ProxyRequest(UUID.fromString(id), Timestamp.valueOf(LocalDateTime.of(2018, 1, 2, 13, 1, 2, 0))));
        }
    }

    @Test
    public void calculateRequestAverage() {

        Timestamp startDate = Timestamp.valueOf(LocalDateTime.of(2018, 1, 1, 1, 0, 0, 0));
        Timestamp endDate = Timestamp.valueOf(LocalDateTime.of(2018, 1, 1, 2, 0, 0, 0));

        RequestsAverage requestsAverage = new RequestsAverage(this.requests, startDate, endDate);

        RequestsRepresentation result = requestsAverage.calculateRequestAverage();
        RequestsRepresentation expected = new RequestsRepresentation(
                startDate, endDate, 10, new BigDecimal(2000.000000000).setScale(9, BigDecimal.ROUND_HALF_EVEN));

        assertEquals(expected.equals(result), true);
    }
}