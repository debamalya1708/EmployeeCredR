package com.dcredr.emp.repository;

import com.dcredr.emp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    @Query(nativeQuery = true,value = "select client_name from client")
    List<String> findAllClientName();
}
