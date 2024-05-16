package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;

public class InfoController {
    private double age;
    private String sex;
    private double weight;
    private double height;
    private UserData userData; 

    @FXML
    private Label Age;

    @FXML
    private RadioButton FemRad, Malerad;

    @FXML
    private Label Height;

    @FXML
    private Label Sex;

    @FXML
    private Label Weight;

    @FXML
    private Spinner<?> kgmod;

    @FXML
    private Slider sliderage;

    @FXML
    private Slider slidercm;

    @FXML
    private Button subBtn;

    public InfoController() {
        userData = new UserData();
    }

   // function to declare values by using the data here and taking them to UserData,
    //where the info r stored.
    public void declareValues(ActionEvent e) {
        this.age = sliderage.getValue();
        this.height = slidercm.getValue();
        Object kgValue = kgmod.getValue();
        if (kgValue != null) {
            this.weight = (double) kgValue;
        }
        
        if(Malerad.isSelected()) {
        	sex = "Male";
        }
        else if(FemRad.isSelected()) {
        	sex = "Female";
        }
        else sex = "undefined";
        
        userData.setAge(age);
        userData.setSex(sex);
        userData.setWeight(weight);
        userData.setHeight(height);
    }

    @FXML
    //on action we declare the values and move on to the next page.
    public void submit(ActionEvent e) {
        declareValues(e); 
        try {
            Parent root = FXMLLoader.load(getClass().getResource("goal.fxml"));
            Scene scene = new Scene(root);
            
            Stage stage = (Stage) subBtn.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
