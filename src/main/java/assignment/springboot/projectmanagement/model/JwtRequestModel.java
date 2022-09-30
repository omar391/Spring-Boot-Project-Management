package assignment.springboot.projectmanagement.model;

import java.io.Serializable;

public class JwtRequestModel implements Serializable {
    private static final long serialVersionUID = 2636936156391265891L;
    public final String username;
    public final String password;
    
    public JwtRequestModel(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
}