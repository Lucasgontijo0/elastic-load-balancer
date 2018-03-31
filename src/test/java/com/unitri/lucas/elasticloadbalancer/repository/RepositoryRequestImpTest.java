package com.unitri.lucas.elasticloadbalancer.repository;

import com.unitri.lucas.elasticloadbalancer.repository.impl.ProxyRequest;
import com.unitri.lucas.elasticloadbalancer.repository.impl.RepositoryRequestImp;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class RepositoryRequestImpTest {


    @Test
    public void testGetRequestByPeriod() {

        RepositoryRequestImp repositoryImp = new RepositoryRequestImp();

        UUID oldIds = UUID.randomUUID();
        ProxyRequest firstOldRequest = new ProxyRequest(oldIds, LocalDateTime.of(2018, 1, 1, 1, 1, 1, 1));
        ProxyRequest secondOldRequest = new ProxyRequest(oldIds, LocalDateTime.of(2018, 1, 1, 1, 1, 2, 1));
        repositoryImp.addRequest(firstOldRequest);
        repositoryImp.addRequest(secondOldRequest);

        UUID newIds = UUID.randomUUID();
        ProxyRequest firstNewRequest = new ProxyRequest(newIds, LocalDateTime.now());
        ProxyRequest secondNewRequest = new ProxyRequest(newIds, LocalDateTime.now());
        repositoryImp.addRequest(firstNewRequest);
        repositoryImp.addRequest(secondNewRequest);

        List<ProxyRequest> expected = new ArrayList<>();
        expected.add(firstOldRequest);
        expected.add(secondOldRequest);

        LocalDateTime oldRequestDate = LocalDateTime.of(2018, 1, 1, 1, 1, 1);
        List<ProxyRequest> result = repositoryImp.getRequestByPeriod(oldRequestDate, oldRequestDate.plusHours(1));
        assertEquals(expected, result);
    }

    @Test
    public void testGetAllRequest() {

        RepositoryRequestImp repositoryImp = new RepositoryRequestImp();

        ProxyRequest firstOldRequest = new ProxyRequest(UUID.randomUUID(), LocalDateTime.now());
        ProxyRequest secondOldRequest = new ProxyRequest(UUID.randomUUID(), LocalDateTime.now());
        repositoryImp.addRequest(firstOldRequest);
        repositoryImp.addRequest(secondOldRequest);

        List<ProxyRequest> expected = new ArrayList<>();
        expected.add(firstOldRequest);
        expected.add(secondOldRequest);

        List<ProxyRequest> result = repositoryImp.getAllRequests();

        assertEquals(expected, result);

    }

}