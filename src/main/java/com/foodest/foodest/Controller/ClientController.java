package com.foodest.foodest.Controller;
import com.foodest.foodest.Classes.Client;
import com.foodest.foodest.Classes.User;
import com.foodest.foodest.Repository.ClientRepository;
import com.foodest.foodest.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/register")
    public ResponseEntity<Client> createClientResponse(@RequestBody Client client) {
        Client newClient = ClientService.registerClient(client.getName(),client.getEmail(),client.getPassword(),client.getImgUrl());
        return ResponseEntity.ok(newClient);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/{email}")
    public ResponseEntity<Client> getClientByEmail(@PathVariable String email) {
        return ResponseEntity.ok(clientService.getClientByEmail(email));
    }

    @GetMapping("/{email}/update")
    public ResponseEntity<String> updateClient(@PathVariable String email,
    @RequestBody String name, String password, String imgUrl) {
        clientService.updateClient(name, email, password, imgUrl);
        return ResponseEntity.ok("Client updated successfully!");
    }

    @GetMapping("/{email}/delete")
    public ResponseEntity<String> deleteClient(@PathVariable String email) {
        clientService.deleteClient(email);
        return ResponseEntity.ok("Client deleted successfully!");
    }
}
