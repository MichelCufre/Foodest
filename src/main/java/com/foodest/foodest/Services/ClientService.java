package com.foodest.foodest.Services;
import com.foodest.foodest.Classes.Client;
import com.foodest.foodest.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {}

    public Client getClientById(Long id) {}

    public Client createClient(String name, String email, String password, String imgUrl, String phoneNumber) {}

    public Client updateClient(Long id, String name, String email, String password, String imgUrl, String phoneNumber) {}

    public void deleteClient(Long id) {}
}
