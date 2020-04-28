package DTO;

public class LoginInfo {
    private String  lastFailedLoginTime;
    private String previousLoginTime;
    private int loginCount;
    private int failedLoginCount;

    public String getLastFailedLoginTime() {
        return lastFailedLoginTime;
    }

    public void setLastFailedLoginTime(String lastFailedLoginTime) {
        this.lastFailedLoginTime = lastFailedLoginTime;
    }

    public String getPreviousLoginTime() {
        return previousLoginTime;
    }

    public void setPreviousLoginTime(String previousLoginTime) {
        this.previousLoginTime = previousLoginTime;
    }

    public int getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(int loginCount) {
        this.loginCount = loginCount;
    }

    public int getFailedLoginCount() {
        return failedLoginCount;
    }

    public void setFailedLoginCount(int failedLoginCount) {
        this.failedLoginCount = failedLoginCount;
    }

    public LoginInfo() {
    }

    public LoginInfo(String lastFailedLoginTime, String previousLoginTime, int loginCount, int failedLoginCount) {
        this.lastFailedLoginTime = lastFailedLoginTime;
        this.previousLoginTime = previousLoginTime;
        this.loginCount = loginCount;
        this.failedLoginCount = failedLoginCount;
    }
}
