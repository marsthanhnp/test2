package com.example.aqsolution;

public class TokenClass {
    private String access_token;
    private String token_type;
    public String principal;
    public String userName;
    public String name;
    private String roles;

    public TokenClass(String access_token, String token_type, String principal, String userName, String name, String roles) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.principal = principal;
        this.userName = userName;
        this.name = name;
        this.roles = roles;
    }



    public String getToken_type() {
        return token_type;
    }

    public String getPrincipal() {
        return principal;
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public String getRoles() {
        return roles;
    }

    public String getAccess_token() {
        return access_token;
    }
}
