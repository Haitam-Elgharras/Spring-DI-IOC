package ma.enset.dao;


import ma.enset.dao.entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao {
    private final Connection connection = DBSingletonDb.connection;
    PreparedStatement pstm = null;

    static {
        try {
            DBSingletonDb.connection.prepareStatement(
                     "CREATE TABLE IF NOT EXISTS clients (" +
                             "id INT PRIMARY KEY AUTO_INCREMENT," +
                             "name VARCHAR(50)," +
                             "email VARCHAR(50)," +
                             "phone VARCHAR(50)," +
                             "address VARCHAR(50)" +
                             ")"
                ).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void create(Client client) {
        try {
            pstm = connection.prepareStatement(
                    "INSERT INTO clients (name, email, phone, address) VALUES (?, ?, ?, ?)"
            );
            pstm.setString(1, client.getName());
            pstm.setString(2, client.getEmail());
            pstm.setString(3, client.getPhone());
            pstm.setString(4, client.getAddress());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Client findById(Integer id) {
        Client client = null;
        try {
            pstm = connection.prepareStatement(
                    "SELECT * FROM clients WHERE id = ?"
            );
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                client = new Client(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address")
                );
                client.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return client;
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        Client client = null;
        try {
            pstm = connection.prepareStatement(
                    "SELECT * FROM clients"
            );
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                client = new Client(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address")
                );
                client.setId(rs.getInt("id"));
                clients.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }

    @Override
    public void update(Client client) {
        try {
            pstm = connection.prepareStatement(
                    "UPDATE clients SET name = ?, email = ?, phone = ?, address = ? " +
                            "WHERE id = ?"
            );
            pstm.setString(1, client.getName());
            pstm.setString(2, client.getEmail());
            pstm.setString(3, client.getPhone());
            pstm.setString(4, client.getAddress());
            pstm.setInt(5, client.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Integer id) {
        try {
            pstm = connection.prepareStatement(
                    "DELETE FROM clients WHERE id = ?"
            );
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Client> searchClientByQuery(String query) {
        List<Client> clients = new ArrayList<>();
        Client client = null;
        try {
            pstm = connection.prepareStatement(
                    "SELECT * FROM clients WHERE name LIKE ? OR email LIKE ? " +
                            "OR phone LIKE ? OR address LIKE ?"
            );

            String likeQuery = "%" + query + "%";
            for (int i = 1; i <= 4; i++) {
                pstm.setString(i, likeQuery);
            }

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                client = new Client(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address")
                );
                client.setId(rs.getInt("id"));
                clients.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }
}
