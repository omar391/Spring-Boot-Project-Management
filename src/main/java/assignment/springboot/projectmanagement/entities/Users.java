package assignment.springboot.projectmanagement.entities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @Size(message = "Name length must be >=1  and <=20", min = 1, max = 20)
    private String nickName;


    @Column(nullable = false, unique = true)
    @Size(message = "Name length must be >=1  and <=20", min = 1, max = 20)
    private String userName;

    @NotBlank
    @NotEmpty
    @NotNull
    @Column(nullable = false)
    private String password;

    public Users() {
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Users(String name, String userName, String password) {
        super();
        this.nickName = name;
        this.userName = userName;
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public long getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

}