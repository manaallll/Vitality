package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.control.ListView;

public class WorkoutController {

    @FXML
    private DatePicker date;

    @FXML
    private ComboBox<String> workoutSelection;

    @FXML
    private ListView<String> workoutList;

    @FXML
    private ImageView img;

    public void initialize() {
        workoutSelection.getItems().addAll("Chest", "Back", "Legs", "Triceps", "Shoulders", "Biceps", "Calves", "Neck", "Forearms" , "Abs");
    }

    @FXML
    protected void addWorkout(ActionEvent event) {
        String selectedWorkout = workoutSelection.getValue();
        if (selectedWorkout != null) {
            workoutList.getItems().add(selectedWorkout);

            switch (selectedWorkout) {
                case "Chest":
                    img.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/application/pics/chest.gif")));
                    break;
                case "Legs":
                    img.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/application/pics/squat.gif")));
                    break;
                case "Back":
                    img.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/application/pics/pull.gif")));
                    break;
                case "Triceps":
                    img.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/application/pics/dips.gif")));
                    break;
                case "Biceps":
                    img.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/application/pics/curl.gif")));
                    break;
                case "Forearms":
                    img.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/application/pics/fore.gif")));
                    break;
                case "Calves":
                    img.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/application/pics/calf.gif")));
                    break;
                case "Neck":
                    img.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/application/pics/neck.gif")));
                    break;
                case "Abs":
                    img.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/application/pics/abs.gif")));
                    break;
                case "Shoulders":
                    img.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/application/pics/shoulders.gif")));
                    break;
                default:
                    break;
            }
        }
    }

	
	
}
