package in.linuxwith.jchess;



import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;
import javafx.util.Builder;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

// Login MVCI Components
class LoginModel {
    private final StringProperty username = new SimpleStringProperty("");
    private final StringProperty password = new SimpleStringProperty("");
    private final BooleanProperty loginSuccessful = new SimpleBooleanProperty(false);

    public StringProperty usernameProperty() { return username; }
    public StringProperty passwordProperty() { return password; }
    public BooleanProperty loginSuccessfulProperty() { return loginSuccessful; }
}

class LoginInteractor {
    private final LoginModel model;

    public LoginInteractor(LoginModel model) {
        this.model = model;
    }

    public void validateLogin() {
        // Simple login validation (replace with actual authentication)
        boolean isValid = "admin".equals(model.usernameProperty().get()) && 
                          "password".equals(model.passwordProperty().get());
        model.loginSuccessfulProperty().set(isValid);
    }
}

class LoginController {
    private final LoginModel model;
    private final LoginInteractor interactor;
    private Runnable onLoginSuccessful;

    public LoginController(LoginModel model, Runnable onLoginSuccessful) {
        this.model = model;
        this.interactor = new LoginInteractor(model);
        this.onLoginSuccessful = onLoginSuccessful;
    }

    public Region getView() {
        return new LoginViewBuilder(model, this::handleLogin).build();
    }

    private void handleLogin() {
        interactor.validateLogin();
        if (model.loginSuccessfulProperty().get()) {
            onLoginSuccessful.run();
        }
    }
}

class LoginViewBuilder implements javafx.util.Builder<Region> {
    private final LoginModel model;
    private final Runnable loginAction;

    public LoginViewBuilder(LoginModel model, Runnable loginAction) {
        this.model = model;
        this.loginAction = loginAction;
    }

    @Override
    public Region build() {
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Label titleLabel = new Label("Login");
        titleLabel.setStyle("-fx-font-size: 20px;");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.textProperty().bindBidirectional(model.usernameProperty());

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.textProperty().bindBidirectional(model.passwordProperty());

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> loginAction.run());

        Label errorLabel = new Label();
        errorLabel.textProperty().bind(
            Bindings.when(model.loginSuccessfulProperty())
                .then("")
                .otherwise("Invalid username or password")
        );
        errorLabel.setStyle("-fx-text-fill: red;");

        layout.getChildren().addAll(
            titleLabel, 
            usernameField, 
            passwordField, 
            loginButton, 
            errorLabel
        );

        return layout;
    }
}

// Dashboard MVCI Components
class DashboardModel {
    private final StringProperty welcomeMessage = new SimpleStringProperty("");

    public StringProperty welcomeMessageProperty() { return welcomeMessage; }
}


class DashboardInteractor {
    private final DashboardModel model;
    private String username;

    public DashboardInteractor(DashboardModel model) {
        this.model = model;
    }

    public void setUsername(String username) {
        this.username = username;
        model.welcomeMessageProperty().set("Welcome, " + username + "!");
    }
}

class DashboardController {
    private final DashboardModel model;
    private final DashboardInteractor interactor;
    private Runnable onLogout;

    public DashboardController(DashboardModel model, String username, Runnable onLogout) {
        this.model = model;
        this.interactor = new DashboardInteractor(model);
        this.onLogout = onLogout;
        interactor.setUsername(username);
    }

    public Region getView() {
        return new DashboardViewBuilder(model, this::handleLogout).build();
    }

    private void handleLogout() {
        onLogout.run();
    }
}

class DashboardViewBuilder implements Builder<Region> {
    private final DashboardModel model;
    private final Runnable logoutAction;

    public DashboardViewBuilder(DashboardModel model, Runnable logoutAction) {
        this.model = model;
        this.logoutAction = logoutAction;
    }

    @Override
    public Region build() {
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Label welcomeLabel = new Label();
        welcomeLabel.textProperty().bind(model.welcomeMessageProperty());
        welcomeLabel.setStyle("-fx-font-size: 20px;");

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> logoutAction.run());

        // Example of multiple panes/sections
        TabPane tabPane = new TabPane();
        
        Tab profileTab = new Tab("Profile");
        profileTab.setContent(new Label("Profile Information"));
        
        Tab settingsTab = new Tab("Settings");
        settingsTab.setContent(new Label("Application Settings"));
        
        tabPane.getTabs().addAll(profileTab, settingsTab);

        layout.getChildren().addAll(
            welcomeLabel, 
            tabPane, 
            logoutButton
        );

        return layout;
    }
}

// Main Application
public class MVCITest extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("MVCI Multi-Scene Application");
        
        showLoginScreen();
        
        primaryStage.setWidth(400);
        primaryStage.setHeight(500);
        primaryStage.show();
    }

    private void showLoginScreen() {
        LoginModel loginModel = new LoginModel();
        LoginController loginController = new LoginController(
            loginModel, 
            () -> showDashboard(loginModel.usernameProperty().get())
        );
        
        Scene loginScene = new Scene(loginController.getView());
        primaryStage.setScene(loginScene);
    }

    private void showDashboard(String username) {
        DashboardModel dashboardModel = new DashboardModel();
        DashboardController dashboardController = new DashboardController(
            dashboardModel, 
            username, 
            this::showLoginScreen
        );
        
        Scene dashboardScene = new Scene(dashboardController.getView());
        primaryStage.setScene(dashboardScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}