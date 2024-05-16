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

    private List<String> users = new ArrayList<>(); //array to store all the usernames
    private List<String> passwords = new ArrayList<>(); // array to store all the passwords

    public void initialize() {
       //at the start the textfields are not visible
        userField.setVisible(false);
        passField.setVisible(false);
    }

    @FXML
    void handleLogIn(ActionEvent event) {
        String username = userField.getText();
        String password = passField.getText();
        //we go through the array, if both username and password (same index) are 
        //equal to the same credentials.
        //after successful login we open Info page.
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(username) && passwords.get(i).equals(password)) {
                openInfoPage(event);
                return; 
            }
        }
    }

    @FXML
    void handleSignUp(ActionEvent event) {
    	//when signing up, text fields will appear
    	 userField.setVisible(true);
         passField.setVisible(true);
        //the username and password are added to the arrays in the same index.
        users.add(userField.getText());
        passwords.add(passField.getText());
    }

   
    private void openInfoPage(ActionEvent event) {
    	// function to open the info.fxml, with its controller
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
