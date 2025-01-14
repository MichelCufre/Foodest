package com.foodest.foodest.Services;
import com.foodest.foodest.Classes.Cart;
import com.foodest.foodest.Classes.Client;
import com.foodest.foodest.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private static ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        ClientService.clientRepository = clientRepository;
    }

    public static Client registerClient(String name, String email, String password, String imgUrl) {
        // Verificar si el cliente ya existe por email
        if (clientRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Client with email " + email + " already exists!");
        }

        // Crear y guardar el nuevo cliente
        Client client = new Client(name, email, password, imgUrl);
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientByEmail(String email) {
        return clientRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Client not found with email: " + email));
    }

    public void updateClient(String name, String email, String password, String imgUrl) {
        Client client = clientRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Client not found with email: " + email));

        //Seteo de datos nuevos
        client.setName(name);
        client.setEmail(email);
        client.setPassword(password);
        client.setImgUrl(imgUrl);
    }

    public void deleteClient(String email) {
        clientRepository.deleteByEmail(email);
    }
}
