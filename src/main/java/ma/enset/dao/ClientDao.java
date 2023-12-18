package ma.enset.dao;


import ma.enset.dao.entities.Client;

import java.util.List;

public interface ClientDao extends Dao<Client,Integer>{
    List<Client> searchClientByQuery(String query);
}
