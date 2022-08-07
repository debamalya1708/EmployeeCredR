package com.dcredr.emp.daoServiceImpl;

import com.dcredr.emp.daoService.ClientDaoService;
import com.dcredr.emp.model.Client;
import com.dcredr.emp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientDaoServiceImpl implements ClientDaoService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<String> getAllClient() {
        return clientRepository.findAllClientName();
    }
}
