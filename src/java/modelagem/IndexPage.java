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
            
            ValueExpression loginConfirmation = createValueExpression("#{loginConfirmation}", Boolean.class);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            boolean log = (boolean) loginConfirmation.getValue(facesContext.getELContext());

            if(log){
                rightForm.setStyleClass("navbar-text navbar-right");
                
                HtmlInputSecret searchInput = new HtmlInputSecret();
                ValueExpression searchSearch = createValueExpression("#{buscador.texto}", String.class);
                searchInput.setValueExpression("busca", searchSearch);
                searchInput.setStyleClass("form-control");

                HtmlCommandButton searchButton = new HtmlCommandButton();
                MethodExpression searchAction = createMethodExpression("#{loginBean.buscar}", String.class);
                searchButton.setActionExpression(searchAction);
                searchButton.setValue("<span class=\"glyphicon glyphicon-search\" />");
                searchButton.setStyleClass("btn btn-default");
                
                HtmlOutputText welcomeOutput = new HtmlOutputText();
                ValueExpression welcomeUsername = createValueExpression("#{loginBean.username}", String.class);
                welcomeOutput.setValueExpression(null, loginConfirmation);
                
                HtmlOutputLink logoffOutput = new HtmlOutputLink();
                logoffOutput.setValue("Sair");
                
                rightForm.getChildren().add(searchInput);
                rightForm.getChildren().add(searchButton);
                rightForm.getChildren().add(welcomeOutput);
                rightForm.getChildren().add(logoffOutput);
            } else {
                rightForm.setStyleClass("navbar-form navbar-right");
                
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
    
    public HtmlForm getLoginForm(){
        return rightForm;
    }
    
    public void setLoginForm(HtmlForm loginForm){
        //DO NOTHING
    }
}
