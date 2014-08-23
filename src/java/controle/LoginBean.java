package controle;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private boolean isLoggedIn;

    public LoginBean() {
        username = "Nome de Usuário";
        password = "Senha";
        isLoggedIn = false;
    }

    public String login() {
        //custom member manager class  
        MemberManager memberManager = new MemberManager();
        System.out.println(username + " " + password + " " + isLoggedIn);

        //user a custom method to authenticate a user  
        if (memberManager.authenticate(username, password)) {
            //changed the state to true  
            isLoggedIn = true;
        } else {
            //set the message to display when authentication fails  
            FacesContext.getCurrentInstance().addMessage("frmView:frmLogin:btnLogin", new FacesMessage("Nome de Usuário ou Senha Inválidos"));
        }
        return "faces/index";
    }

    public String logoff() {
        username = "Nome de Usuário";
        password = "Senha";
        isLoggedIn = false;
        return "faces/index";
    }
    
    /**
     * An event listener for redirecting the user to login page if he/she is not
     * currently logged in
     *
     * @param event
     */
    public void verifyUseLogin(ComponentSystemEvent event) {
        if (!isLoggedIn) {
            doRedirect("faces/index");
        }
    }

    /**
     * Method for redirecting a request
     *
     * @param url
     */
    private void doRedirect(String url) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("faces/index");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLogin() {
        return login();
    }
    
    public String getLogoff() {
        return logoff();
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
    
    public boolean getIsNotLoggedIn() {
        return !isLoggedIn;
    }

    public void setIsNotLoggedIn(boolean isNotLoggedIn) {
        //Do NOTHING
    }
}
