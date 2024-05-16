package application;


import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class AnnouncementController {

    @FXML
    private ImageView frameImage;

    @FXML
    private ImageView announcementImage1;

    @FXML
    private ImageView announcementImage2;

    @FXML
    private ImageView announcementImage3;

    @FXML
    private ImageView announcementImage4;

    @FXML
    private Label announcementLabel;

    private final String[] announcementPaths = { 
            "/application/pics/ann1.jpg",
            "/application/pics/ann2.jpg",
            "/application/pics/ann3.jpg",
            "/application/pics/ann4.jpg"
    };

    private final String announcementText = "New Version Coming Soon";

    private int currentImageIndex = 0;

    public void initialize() {
        frameImage.setImage(new Image("/application/pics/ann5.jpg")); 

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> transitionImages()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void transitionImages() {
        announcementImage1.setImage(null);
        announcementImage2.setImage(null);
        announcementImage3.setImage(null);
        announcementImage4.setImage(null);

        currentImageIndex = (currentImageIndex + 1) % announcementPaths.length;

        switch (currentImageIndex) {
            case 0:
                announcementImage1.setImage(new Image(announcementPaths[0]));
                break;
            case 1:
                announcementImage2.setImage(new Image(announcementPaths[1]));
                break;
            case 2:
                announcementImage3.setImage(new Image(announcementPaths[2]));
                break;
            case 3:
                announcementImage4.setImage(new Image(announcementPaths[3]));
                break;
        }

        if (announcementLabel != null) {
            announcementLabel.setText(announcementText);
        }

        FadeTransition ft = new FadeTransition(Duration.seconds(1), announcementImage1);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }
}
