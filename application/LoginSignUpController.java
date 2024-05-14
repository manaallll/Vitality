package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginSignUpController {

    @FXML
    private Button logInBtn;

    @FXML
    private Button signUpBtn;

    @FXML
    private PasswordField passField;

    @FXML
    private TextField userField;

    private List<String> users = new ArrayList<>();
    private List<String> passwords = new ArrayList<>();

    public void initialize() {
        users.add("user1");
        passwords.add("password1");
        users.add("user2");
        passwords.add("password2");

        userField.setVisible(false);
        passField.setVisible(false);
    }

    @FXML
    void handleLogIn(ActionEvent event) {
        String username = userField.getText();
        String password = passField.getText();

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(username) && passwords.get(i).equals(password)) {
                openInfoPage(event);
                return; 
            }
        }
        System.out.println("Invalid username or password!");
    }

    @FXML
    void handleSignUp(ActionEvent event) {
    	 userField.setVisible(true);
         passField.setVisible(true);
        users.add(userField.getText());
        passwords.add(passField.getText());
        System.out.println("User signed up successfully!");
    }

   
    private void openInfoPage(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();

            Parent root = FXMLLoader.load(getClass().getResource("info.fxml"));
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }



    @FXML
    void showLoginFields(ActionEvent event) {
        userField.setVisible(true);
        passField.setVisible(true);
    }

    @FXML
    void showSignUpFields(ActionEvent event) {
        userField.setVisible(true);
        passField.setVisible(true);
    }
}
