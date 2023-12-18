package ma.enset.service;


import ma.enset.dao.ClientDao;
import ma.enset.dao.entities.Client;

import java.util.List;

public class ClientService implements IClientService{
    private ClientDao clientDao;

    // constructor injection
    public ClientService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }
    @Override
    public void addClient(Client client) {
        clientDao.create(client);
    }

    @Override
    public void deleteClientById(int id) {
        clientDao.delete(id);
    }

    @Override
    public List<Client> getAllClients() {
        return clientDao.getAll();
    }

    @Override
    public void updateClient(Client client) {
        clientDao.update(client);
    }

    @Override
    public List<Client> searchClientByQuery(String query) {
        return clientDao.searchClientByQuery(query);
    }
}
