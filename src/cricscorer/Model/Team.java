package cricscorer.Model;

import cricscorer.repository.generic.GenericInterface;

public class Team implements GenericInterface{

    private Integer id;
    private String name;
    private String address;
    private String manager;

    public Team(Integer id, String name, String address, String manager) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.manager = manager;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getManager() {
        return manager;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
