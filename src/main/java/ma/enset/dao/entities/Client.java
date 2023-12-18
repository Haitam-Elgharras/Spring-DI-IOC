package ma.enset.dao.entities;

public class Client {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;

    public Client(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client : \n"
                + "id : " + id + "\n"
                + "name : " + name + "\n"
                + "email : " + email + "\n"
                + "phone : " + phone + "\n"
                + "address : " + address + "\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }





}
