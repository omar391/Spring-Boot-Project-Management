package assignment.springboot.projectmanagement.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @Size(message = "Name length must be >=1  and <=20", min = 1, max = 20)
    private String nickName;

    public Users() {
    }

    public Users(String name) {
        super();
        this.nickName = name;
    }

    public long getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

}