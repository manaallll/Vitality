package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FriendsController {

    @FXML
    private TextField addFriendTextField;

    @FXML
    protected void addFriend() {
        addFriendTextField.setVisible(true);
    }
}
