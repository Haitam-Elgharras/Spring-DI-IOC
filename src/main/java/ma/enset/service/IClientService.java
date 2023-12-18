package ma.enset.service;


import ma.enset.dao.entities.Client;

import java.util.List;

public interface IClientService {
    void addClient(Client client);
    void deleteClientById(int id);
    List<Client> getAllClients();
    void updateClient(Client client);
    List<Client> searchClientByQuery(String query);
}
