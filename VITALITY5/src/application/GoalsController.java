package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GoalsController {
    private UserData userData;

    public GoalsController() {
    	
    }
    
    public GoalsController(UserData userData) {
        this.userData = userData;
    }

    public void initData(UserData userData) {
        this.userData = userData;
        
    }

    public void handleButtonClick(ActionEvent event) {
        String goal = ((Button) event.getSource()).getText();
        System.out.println("Goal selected: " + goal);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menumain.fxml"));
            Parent root = loader.load();
            MenuMainController controller = loader.getController();
            controller.initData(userData);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
