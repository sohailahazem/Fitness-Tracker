import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Results {

    Scene scene;
    ACTIVITY Swimming;
    ACTIVITY Running;
    ACTIVITY Kick_Boxing;
    ACTIVITY Strength_Training;
    ChooseActivity chooseActivity;
    Stage stage;
    User user;

    public void setChooseActivity(ChooseActivity chooseActivity) {
        this.chooseActivity = chooseActivity;
    }

    public Results(ACTIVITY Swimming, ACTIVITY Running, ACTIVITY Kick_Boxing, ACTIVITY Strength_Training, User user,Stage stage){
        this.Swimming = Swimming;
        this.Running = Running;
        this.Kick_Boxing = Kick_Boxing;
        this.Strength_Training = Strength_Training;
        this.user = user;
        this.stage = stage;

    }

    public void ResultsWindow(){
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.UP);
        ACTIVITY[] activities = {Swimming, Running, Kick_Boxing, Strength_Training};
        ACTIVITY.sort(activities);
        Label resultsLabel = new Label("Results:");
        resultsLabel.setTextFill(Color.NAVY);
        resultsLabel.setStyle("-fx-font: 18 verdana;");
        Label rank = new Label("Activities Rank:");
        rank.setTextFill(Color.NAVY);
        rank.setStyle("-fx-font: 18 verdana;");
        Label cal = new Label("Total Calories =   " + df.format(user.getCaloriesBurnt()) +"  beat per minute");
        Label heartRate = new Label("Total Heart Rate  =   " + df.format(user.getHeartRate()) + "  calories");

        Label results = new Label("1. " + activities[0].getName() + ":\n" + "Calories Burnt =  " + activities[0].getTotalCalories() + "  calories\n" + "Heart Rate Increase =  " + df.format(activities[0].getTotalHeartRateInc()) + "  beat per minute\n" +
                "2. " + activities[1].getName() + ":\n" + "Calories Burnt =  " + activities[1].getTotalCalories() + "   calories\n" + "Heart Rate Increase =  " + df.format(activities[1].getTotalHeartRateInc()) + "  beat per minute\n" +
                "3. " + activities[2].getName() + ":\n" + "Calories Burnt =  " + activities[2].getTotalCalories() + "   calories\n" + "Heart Rate Increase =  " + df.format(activities[2].getTotalHeartRateInc()) + "  beat per minute\n" +
                "4. " + activities[3].getName() + ":\n" + "Calories Burnt =  " + activities[3].getTotalCalories() + "   calories\n" + "Heart Rate Increase =  " + df.format(activities[3].getTotalHeartRateInc()) + "  beat per minute\n" );
        Button backButton = new Button("Back");
        backButton.setPrefSize(150,30);
        backButton.setStyle("-fx-font: 16 arial;");
        cal.setStyle("-fx-font: 16 verdana;");
        cal.setTextFill(Color.BLACK);
        heartRate.setStyle("-fx-font: 16 verdana;");
        heartRate.setTextFill(Color.BLACK);
        results.setTextFill(Color.BLACK);
        results.setStyle("-fx-font: 16 verdana;");
        GridPane grid  = new GridPane();
        grid.add(resultsLabel,0,1);
        grid.add(cal,0,2);
        grid.add(heartRate,0,3);
        grid.add(rank,0,4);
        grid.add(backButton,4,10);
        grid.add(results,0,8);
        BackgroundImage myBI= new BackgroundImage(new Image("https://media.istockphoto.com/photos/fitness-concept-background-picture-id935963214?k=6&m=935963214&s=612x612&w=0&h=TJlS5bv9cbKTOFb1PVP_8NQ2pn4bTl7f0BkullC9Tc4=",600,400,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        grid.setBackground(new Background(myBI));
        scene = new Scene(grid, 600, 400);
        backButton.setOnAction(e->{
            stage.setScene(chooseActivity.getScene());
        });

    }
    public Scene getScene(){

        return this.scene;
    }
}
