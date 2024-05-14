package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class NutritionController extends UserData{

    @FXML
    private Button addCarbs;

    @FXML
    private Button addFat;

    @FXML
    private Button addProtein;

    @FXML
    private Label bMI;

    @FXML
    private Label bmiInfo;

    @FXML
    private TextField cIntaketxt;

    @FXML
    private Label carbsIntake;

    @FXML
    private Label currentHeight;

    @FXML
    private Label currentWeight;

    @FXML
    private TextField fIntaketxt;

    @FXML
    private Label fatIntake;

    @FXML
    private TextField pIntaketxt;

    @FXML
    private ProgressBar pbarCarbs;

    @FXML
    private ProgressBar pbarFat;

    @FXML
    private ProgressBar pbarProtein;

    @FXML
    private Label proteinIntake;

    @FXML
    private Button updateWeightgoal;

    @FXML
    private Label weightGoal;

    @FXML
    private TextField weightGoaltxt;
    
    private double carbssIntake;
    private double fatsIntake;
    private double proteinsIntake;
    private double weightGoals;
    

    private UserData userData;

    public void initialize() {
        userData = UserData.getInstance();
        updateLabels();
        calculateBMI();
    }
    public void initData(UserData userData) {
        this.userData = userData;
    }

    @FXML
    void handleAddCarbs(ActionEvent event) {
        double carbs = Double.parseDouble(cIntaketxt.getText());
        addCarbs(carbs);
        updateLabels();
    }

    @FXML
    void handleAddFat(ActionEvent event) {
        double fat = Double.parseDouble(fIntaketxt.getText());
        addFat(fat);
        updateLabels();
    }

    @FXML
    void handleAddProtein(ActionEvent event) {
        double protein = Double.parseDouble(pIntaketxt.getText());
        addProtein(protein);
        updateLabels();
    }

    @FXML
    void handleUpdateWeight(ActionEvent event) {
        double weightGoal = Double.parseDouble(weightGoaltxt.getText());
        setWeightGoal(weightGoal);
        updateLabels();
    }

    private void setWeightGoal(double weightGoal) {
		this.weightGoals = weightGoal;
		
	}
	private void updateLabels() {
        currentWeight.setText(String.valueOf(userData.getWeight()));
        weightGoal.setText(String.valueOf(getWeightGoal()));
        carbsIntake.setText(String.valueOf(getCarbsIntake()));
        fatIntake.setText(String.valueOf(getFatIntake()));
        proteinIntake.setText(String.valueOf(getProteinIntake()));
        updateProgressBars();
    }

    private double getWeightGoal() {
    	double s = 5;
		return s;
	}
	private void updateProgressBars() {
        pbarCarbs.setProgress(getCarbsPercentage());
        pbarFat.setProgress(getFatPercentage());
        pbarProtein.setProgress(getProteinPercentage());
    }

    private void calculateBMI() {
        double height = userData.getHeight();
        double weight = userData.getWeight();
        double bmi = weight / (height * height);
        bMI.setText(String.format("%.2f", bmi));
        if (bmi < 18.5) {
            bmiInfo.setText("Underweight");
        } else if (bmi >= 18.5 && bmi < 25) {
            bmiInfo.setText("Normal weight");
        } else if (bmi >= 25 && bmi < 30) {
            bmiInfo.setText("Overweight");
        } else {
            bmiInfo.setText("Obese");
        }
    }
    public double getCarbsIntake() {
        return carbssIntake;
    }

    public void setCarbsIntake(double carbsIntake) {
        this.carbssIntake = carbsIntake;
    }

    public double getFatIntake() {
        return fatsIntake;
    }

    public void setFatIntake(double fatIntake) {
        this.fatsIntake = fatIntake;
    }

    public double getProteinIntake() {
        return proteinsIntake;
    }

    public void setProteinIntake(double proteinIntake) {
        this.proteinsIntake = proteinIntake;
    }

    public void addCarbs(double amount) {
        carbssIntake += amount;
    }

    public void addFat(double amount) {
        fatsIntake += amount;
    }

    public void addProtein(double amount) {
        proteinsIntake += amount;
    }

    public double getCarbsPercentage() {
        return (carbssIntake / getTotalDailyCalories()) * 100;
    }

    public double getFatPercentage() {
        return (fatsIntake / getTotalDailyCalories()) * 100;
    }

    public double getProteinPercentage() {
        return (proteinsIntake / getTotalDailyCalories()) * 100;
    }

    public double getTotalDailyCalories() {
        double bmr = calculateBMR();
        double pal = calculatePAL();
        return bmr * pal;
    }

    private double calculateBMR() {
       
        double bmr = 0;
        if (userData.getSex().equalsIgnoreCase("male")) {
            bmr = 88.362 + (13.397 * userData.getWeight()) + (4.799 * userData.getWeight()) - (5.677 * userData.getAge());
        } else if (userData.getSex().equalsIgnoreCase("female")) {
            bmr = 447.593 + (9.247 * userData.getWeight()) + (3.098 * userData.getHeight()) - (4.330 * userData.getAge());
        }
        return bmr;
    }

    private double calculatePAL() {
        return 1.55;
    }
    
}
