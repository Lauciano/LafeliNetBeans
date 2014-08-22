package modelagem;

import javax.annotation.PostConstruct;
import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLink;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;

/**
 *
 * @author Lauciano FA
 */
@ManagedBean
@SessionScoped
public class IndexPage {
    private HtmlForm rightForm;
    
    @PostConstruct
    public void init(){
        
            rightForm = new HtmlForm();
            rightForm.setId("frmLogin");
            rightForm.setStyleClass("navbar-form navbar-right");
            
            ValueExpression loginConfirmation = createValueExpression("#{loginBean.isLoggedIn}", Boolean.class);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            Boolean log = (Boolean) loginConfirmation.getValue(facesContext.getELContext());

            if(log){
                
                HtmlOutputText welcomeOutput = new HtmlOutputText();
                welcomeOutput.setValue("Olá, usuário.");
                //ValueExpression welcomeUsername = createValueExpression("#{loginBean.username}", String.class);
                //welcomeOutput.setValueExpression("welcome", welcomeUsername);
                welcomeOutput.setStyleClass("navbar-text");
                
                HtmlOutputLink logoffLink = new HtmlOutputLink();
                HtmlOutputText logoffOutput = new HtmlOutputText();
                logoffOutput.setValue("Sair");
                logoffOutput.setStyleClass("navbar-text");
                logoffLink.getChildren().add(logoffOutput);
                
                rightForm.getChildren().add(welcomeOutput);
                rightForm.getChildren().add(logoffLink);
                
            } else {
                
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

                rightForm.getChildren().add(usernameInput);
                rightForm.getChildren().add(passwordInput);
                rightForm.getChildren().add(loginButton);
            }
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
    
    public HtmlForm getRightForm(){
        return rightForm;
    }
    
    public void setRightForm(HtmlForm rightForm){
        //DO NOTHING
    }
}
