package com.unitri.lucas.elasticloadbalancer.repository;

import com.unitri.lucas.elasticloadbalancer.repository.entity.ProxyRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RepositoryRequest extends CrudRepository<ProxyRequest, Long> {

    /* Number of requests that arrived, answered or not. */

    @Query(
            value = "SELECT count(1)\n"
                  + "FROM (SELECT count(request_id)\n"
                  + "      FROM proxy_request\n"
                  + "      GROUP BY request_id) request_id;",
            nativeQuery = true)
    long quantityOfRequestsThatArrived();

    @Query(
            value = "SELECT count(1)\n"
                  + "FROM (SELECT count(request_id)\n"
                  + "      FROM proxy_request\n"
                  + "      WHERE time BETWEEN ?1 AND ?2\n"
                  + "      GROUP BY request_id) request_id;",
            nativeQuery = true )
    long quantityOfRequestsThatArrivedBetweenPeriod(Timestamp start, Timestamp end);

    /* Number of requests done */

    @Query(
            value =  "SELECT count(1) FROM ("
                    +    "SELECT count(request_id) FROM proxy_request GROUP BY request_id HAVING count(request_id) > 1"
                    + " ) request_id;\n",
            nativeQuery = true)
    long quantityOfRequestDone();


    @Query(
            value = "SELECT count(1)\n"
                    + "FROM (SELECT count(request_id)\n"
                    + "      FROM proxy_request\n"
                    + "      WHERE time BETWEEN ?1 AND ?2\n"
                    + "      GROUP BY request_id\n"
                    + "      HAVING count(request_id) > 1) request_id;",
            nativeQuery = true)
    long quantityOfRequestDoneBetweenPeriod(Timestamp start, Timestamp end);


    @Query(value = "SELECT max(time) FROM proxy_request", nativeQuery = true)
    Timestamp findMaxTime();

    @Query(value = "SELECT min(time) FROM proxy_request;", nativeQuery = true)
    Timestamp findMinTime();

}
