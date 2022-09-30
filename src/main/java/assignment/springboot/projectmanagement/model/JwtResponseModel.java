package assignment.springboot.projectmanagement.model;

import java.io.Serializable;

public class JwtResponseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    public final String token;
    public final String nickName;
    public final long accountId;

    public JwtResponseModel(String token, String nickName, long accountId) {
        this.token = token;
        this.nickName = nickName;
        this.accountId = accountId;
    }
}
