package application;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class MenuMainController {
    
    private UserData userData;

    @FXML
    private AnchorPane mainAnchorPane;

    public void initData(UserData userData) {
        this.userData = userData;
    }
// each function opens a different scene 
    @FXML
    public void handleSleepButton() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene1.fxml"));
        try {
            AnchorPane sleepPage = loader.load();
            SleepPageController controller = loader.getController();
            mainAnchorPane.getChildren().setAll(sleepPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void handleNutritionButton(){
    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
         try {
             AnchorPane nutritionPage = loader.load();
             NutritionController controller = loader.getController();
             controller.initData(userData); 
             mainAnchorPane.getChildren().setAll(nutritionPage);
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
    
    @FXML
    public void handleWorkoutButton() {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene3.fxml"));
        try {
            AnchorPane workoutPage = loader.load();
            WorkoutController controller = loader.getController();
            mainAnchorPane.getChildren().setAll(workoutPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void handleFriendsButton(){
    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene5.fxml"));
         try {
             AnchorPane friendsPage = loader.load();
             FriendsController controller = loader.getController();
             mainAnchorPane.getChildren().setAll(friendsPage);
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
    
    @FXML
    public void handlePublicButton(){
    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene4.fxml"));
         try {
             AnchorPane publicPage = loader.load();
             AnnouncementController controller = loader.getController();
             mainAnchorPane.getChildren().setAll(publicPage);
         } catch (IOException e) {
             e.printStackTrace();
         }
    }


}
