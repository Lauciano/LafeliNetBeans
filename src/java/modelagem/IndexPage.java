package modelagem;

import controle.LoginBean;
import javax.annotation.PostConstruct;
import javax.el.MethodExpression;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;

/**
 *
 * @author Lauciano FA
 */
@ManagedBean
@SessionScoped
public class IndexPage {
    private HtmlForm loginForm;
    
    @PostConstruct
    public void init(){
        loginForm = new HtmlForm();
        loginForm.setId("frmLogin");
        loginForm.setStyleClass("navbar-form navbar-right");
        
        HtmlInputText username = new HtmlInputText();
        username.setValue("#{loginBean.username}");
        username.setStyleClass("form-control");
        
        HtmlInputSecret password = new HtmlInputSecret();
        password.setValue("#{loginBean.password}");
        password.setStyleClass("form-control");
        
        HtmlCommandButton login = new HtmlCommandButton();
        MethodExpression loginAction = createMethodExpression("#{loginBean.login}", String.class, String.class, String.class);
        login.setActionExpression(loginAction);
        login.setValue("Entrar");
        login.setStyleClass("btn btn-default");
        
        loginForm.getChildren().add(username);
        loginForm.getChildren().add(password);
        loginForm.getChildren().add(login);
    }
    
    public static MethodExpression createMethodExpression(String expression, Class<?> returnType, Class<?>... parameterTypes) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return facesContext.getApplication().getExpressionFactory().createMethodExpression(
            facesContext.getELContext(), expression, returnType, parameterTypes);
    }
    
    public HtmlForm getLoginForm(){
        return loginForm;
    }
    
    public void setLoginForm(HtmlForm loginForm){
        //DO NOTHING
    }
}
