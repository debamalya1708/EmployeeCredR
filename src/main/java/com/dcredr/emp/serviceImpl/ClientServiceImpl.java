package com.dcredr.emp.serviceImpl;

import com.dcredr.emp.daoService.ClientDaoService;
import com.dcredr.emp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDaoService clientDaoService;

    @Override
    public List<String> getAllClient() {
        return clientDaoService.getAllClient();
    }
}
