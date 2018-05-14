package com.unitri.lucas.elasticloadbalancer.repository;

import com.unitri.lucas.elasticloadbalancer.repository.entity.ProxyRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface RepositoryRequest extends CrudRepository<ProxyRequest, Long> {


    /* Get requests */

    List<ProxyRequest> findAll();

    @Query(
            value = "SELECT * FROM proxy_request\n" +
                    "WHERE start_time >= ?1 AND end_time <= ?2",
            nativeQuery = true
    )
    List<ProxyRequest> findAllByTimeBetween(Timestamp start, Timestamp end);

    /* Number of requests that arrived, answered or not. */

    @Query(
            value = "SELECT count(1) FROM proxy_request",
            nativeQuery = true)
    long quantityOfRequestsThatArrived();

    @Query(
            value = "SELECT count(1) FROM proxy_request WHERE start_time >= ?1 AND end_time <= ?2",
            nativeQuery = true )
    long quantityOfRequestsThatArrivedBetweenPeriod(Timestamp start, Timestamp end);

    /* Number of requests done */

    @Query(
            value =  "SELECT count(1) FROM proxy_request WHERE status = 'SUCCESS'",
            nativeQuery = true)
    long quantityOfRequestDone();


    @Query(
            value = "SELECT count(1) FROM proxy_request WHERE status = 'SUCCESS' AND start_time >= ?1 AND end_time <= ?2",
            nativeQuery = true)
    long quantityOfRequestDoneBetweenPeriod(Timestamp start, Timestamp end);


    @Query(value = "SELECT max(start_time) FROM proxy_request", nativeQuery = true)
    Timestamp findMaxTime();

    @Query(value = "SELECT min(start_time) FROM proxy_request;", nativeQuery = true)
    Timestamp findMinTime();

}
