package modelagem;

import controle.LoginBean;
import javax.annotation.PostConstruct;
import javax.el.MethodExpression;
import javax.el.ValueExpression;
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
        
        HtmlInputText usernameInput = new HtmlInputText();
        ValueExpression loginUsername = createValueExpression("#{loginBean.username}", String.class);
        usernameInput.setValueExpression("username", loginUsername);
        usernameInput.setStyleClass("form-control");
        
        HtmlInputSecret passwordInput = new HtmlInputSecret();
        ValueExpression loginPassword = createValueExpression("#{loginBean.password}", String.class);
        passwordInput.setValueExpression("password", loginPassword);
        passwordInput.setStyleClass("form-control");
        
        HtmlCommandButton loginButton = new HtmlCommandButton();
        MethodExpression loginAction = createMethodExpression("#{loginBean.login}", String.class);
        loginButton.setActionExpression(loginAction);
        loginButton.setValue("Entrar");
        loginButton.setStyleClass("btn btn-default");
        
        loginForm.getChildren().add(usernameInput);
        loginForm.getChildren().add(passwordInput);
        loginForm.getChildren().add(loginButton);
    }
    
    public static ValueExpression createValueExpression(String expression, Class<?> valueType) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return facesContext.getApplication().getExpressionFactory().createValueExpression(
            facesContext.getELContext(), expression, valueType);
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
