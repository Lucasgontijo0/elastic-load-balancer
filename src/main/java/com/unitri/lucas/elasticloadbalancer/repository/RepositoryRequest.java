package com.unitri.lucas.elasticloadbalancer.repository;

import com.unitri.lucas.elasticloadbalancer.repository.model.ProxyRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRequest extends CrudRepository<ProxyRequest, Long> {

}
