package cricscorer.Model;

import cricscorer.repository.generic.GenericAbstractClass;
import cricscorer.repository.generic.GenericInterface;

public class Team extends GenericAbstractClass implements GenericInterface {

    private String name;
    private String address;
    private String manager;

    public Team(Integer id, String name, String address, String manager) {
        this.setId(id);
        this.name = name;
        this.address = address;
        this.manager = manager;
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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getTableName() {
        return "team";
    }
}
