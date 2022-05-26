package codegym.danang.demo.dto;

import codegym.danang.demo.validator.PasswordMatches;

@PasswordMatches
public class UserDto {
    private String userName;


    private String password;
    private String matchingPassword;

    public UserDto() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }
// standard getters and setters
}
