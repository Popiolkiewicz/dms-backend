package pl.dms.model;

import javax.persistence.Entity;

@Entity(name = "t_permission")
public class Permission extends BaseId {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
