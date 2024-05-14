package application;

import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class SleepPageController {

    @FXML
    private ProgressBar sleepProgressBar;

    @FXML
    private Label hoursSleptLabel;

    @FXML
    private LineChart<String, Number> sleepChart;

    @FXML
    private TextField sleepHoursInput; 

    private UserData userData;
    
    ArrayList<Integer> sleepData = new ArrayList<Integer>();


    
    public void initialize() {
        sleepChart.getXAxis().setLabel("Day");
        sleepChart.getYAxis().setLabel("Hours Slept");
    }

    public void initData(UserData userData) {
        this.userData = userData;
        updateSleepProgress();
        updateSleepChart();
    }

    private void updateSleepProgress() {
        
            int hoursSlept = Integer.parseInt(sleepHoursInput.getText());
            double progress = hoursSlept / 7.0; 

            if (progress > 1.0) {
                progress = 1.0;
            }

            sleepProgressBar.setProgress(progress);
            hoursSleptLabel.setText(String.format("%.1f hours", hoursSlept));
            sleepData.add(hoursSlept);
            
    }

    private void updateSleepChart() {
       
            sleepChart.getData().clear();
            ;
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            for (int i = 0; i < sleepData.size(); i++) {
                series.getData().add(new Data<>("" + (i + 1), sleepData.get(i)));
            }

            sleepChart.getData().add(series);
    }

    @FXML
    private void addHoursButtonClicked() {
            double sleepHours;
            try {
                sleepHours = Integer.parseInt(sleepHoursInput.getText());
                if (sleepHours <= 0) {
                    System.out.println("Invalid sleep hours entered (must be positive)! ");
                    sleepHoursInput.clear(); 
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid sleep hours entered!");
                sleepHoursInput.clear(); 
                return;
            }

            updateSleepProgress();
            updateSleepChart();
            sleepHoursInput.clear(); 
        
    }
}
