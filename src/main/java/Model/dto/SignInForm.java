package Model.dto;

/**
 * Created by yarik on 20.05.2015.
 */
public class SignInForm {
    private String login;
    private String password;

    public SignInForm() {
    }

    public SignInForm(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
