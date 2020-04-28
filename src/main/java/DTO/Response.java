package DTO;

public class Response {
    private LoginInfo loginInfo;
    private Session session;

    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Response() {
    }

    public Response(LoginInfo loginInfo, Session session) {
        this.loginInfo = loginInfo;
        this.session = session;
    }
}
