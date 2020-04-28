package DTO;

public class User {
    private String self;
    private String name;
    private LoginInfo loginInfo;

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    public User() {
    }

    public User(String self, String name, LoginInfo loginInfo) {
        this.self = self;
        this.name = name;
        this.loginInfo = loginInfo;
    }
}