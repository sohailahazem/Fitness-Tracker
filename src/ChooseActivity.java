import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ChooseActivity {
    ACTIVITY Swimming;
    ACTIVITY Running;
    ACTIVITY Kick_Boxing;
    ACTIVITY Strength_Training;
    User user;
    Results results;
    Stage stage;
    Scene scene;
    public void setResults(Results results) {
        this.results = results;
    }

    public ChooseActivity(ACTIVITY Swimming, ACTIVITY Running, ACTIVITY Kick_Boxing, ACTIVITY Strength_Training, User user, Stage stage){
        this.Swimming = Swimming;
        this.Running = Running;
        this.Kick_Boxing = Kick_Boxing;
        this.Strength_Training = Strength_Training;
        this.user = user;
        this.stage = stage;

    }
public void ActivityWindow() {
    DecimalFormat df = new DecimalFormat("#.####");
    df.setRoundingMode(RoundingMode.UP);
    FlowPane flowpane = new FlowPane();
    flowpane.setHgap(25);
    Label activityLabel = new Label("   <Choose your Activity>");
    Label timeLabel = new Label("Enter Time");
    TextField timeField = new TextField();
    Label inmins = new Label("mins");
    Label verification = new Label();
    Label heartRLabel = new Label("Heart Rate=     beat per minute");
    Label caloriesLabel = new Label("Calories Burnt=    calories");
    Button swimButton = new Button("Swimming");
    Button runButton = new Button("Running");
    Button kickButton = new Button("Kick-Boxing");
    Button trainButton = new Button("Strength-Training");
    Button resultsButton = new Button("RESULTS");
    activityLabel.setPrefSize(200,40);
    swimButton.setPrefSize(180,40);
    runButton.setPrefSize(180,40);
    kickButton.setPrefSize(180,40);
    trainButton.setPrefSize(180,40);
    timeLabel.setPrefSize(90,20);
    timeField.setMaxWidth(50); timeField.setMaxHeight(20);
    inmins.setPrefSize(50,20);
    heartRLabel.setPrefSize(300,40);
    heartRLabel.setWrapText(true);
    caloriesLabel.setPrefSize(400,40);
    resultsButton.setPrefSize(100,30);
    verification.setPrefSize(400,30);
    HBox hBox = new HBox(activityLabel);
    HBox hBox1 = new HBox(25, swimButton, runButton);
    HBox hBox2 = new HBox(25, kickButton, trainButton);
    HBox hBox3 = new HBox(10, timeLabel, timeField,inmins);
    HBox hBox4 = new HBox(20, heartRLabel, caloriesLabel);
    HBox hBox5 = new HBox(30,resultsButton,verification);
    FlowPane.setMargin(hBox, new Insets(30, 50, 0, 10));
    FlowPane.setMargin(hBox1, new Insets(30, 50, 0, 20));
    FlowPane.setMargin(hBox2, new Insets(30, 50, 0, 20));
    FlowPane.setMargin(hBox3, new Insets(30, 50, 0, 20));
    FlowPane.setMargin(hBox4, new Insets(30, 50, 0, 20));
    FlowPane.setMargin(hBox5, new Insets(30, 50, 0, 20));
    flowpane.getChildren().addAll(hBox,hBox1, hBox2, hBox3, hBox4, hBox5);
    swimButton.setStyle("-fx-font: 13 arial;");
    runButton.setStyle("-fx-font: 13 arial;");
    kickButton.setStyle("-fx-font: 13 arial;");
    trainButton.setStyle("-fx-font: 13 arial;");
    resultsButton.setStyle("-fx-font: 12 arial;");
    activityLabel.setStyle("-fx-font: 15 verdana;");
    activityLabel.setTextFill(Color.BLACK);
    timeLabel.setStyle("-fx-font: 15 verdana;");
    timeLabel.setTextFill(Color.BLACK);
    heartRLabel.setStyle("-fx-font: 15 verdana;");
    heartRLabel.setTextFill(Color.BLACK);
    caloriesLabel.setStyle("-fx-font: 15 verdana;");
    caloriesLabel.setTextFill(Color.BLACK);
    inmins.setStyle("-fx-font: 15 verdana;");
    inmins.setTextFill(Color.BLACK);
    verification.setStyle("-fx-font: 15 verdana;");
    verification.setTextFill(Color.BLACK);
    BackgroundImage myBI= new BackgroundImage(new Image("https://media.istockphoto.com/photos/fitness-concept-background-picture-id935963214?k=6&m=935963214&s=612x612&w=0&h=TJlS5bv9cbKTOFb1PVP_8NQ2pn4bTl7f0BkullC9Tc4=",600,400,false,true),
            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);
    flowpane.setBackground(new Background(myBI));
     scene = new Scene(flowpane, 600, 400);
    swimButton.setOnAction(e->{
        String timeString = timeField.getText();
        int time = Integer.parseInt(timeString);
        Swimming.perform_ACTIVITY(time);
        heartRLabel.setText("Heart Rate=  " + df.format(user.getHeartRate()) + "  beat per minute");
        caloriesLabel.setText("Calories Burnt=    " + user.getCaloriesBurnt() + "    calories");
        if(Swimming.verifyChange) verification.setText("Activity: (Swimming) Recorded Successfully");
        else verification.setText("Failed to record Swimming");
    });
    runButton.setOnAction(e->{
        String timeString = timeField.getText();
        int time = Integer.parseInt(timeString);
        Running.perform_ACTIVITY(time);
        heartRLabel.setText("Heart Rate=  " + df.format(user.getHeartRate()) + "   beat per minute");
        caloriesLabel.setText("Calories Burnt=    " + user.getCaloriesBurnt() + "    calories");
        if(Running.verifyChange) verification.setText("Activity: (Running) Recorded Successfully");
        else verification.setText("Failed to record Running");
    });
    kickButton.setOnAction(e->{
        String timeString = timeField.getText();
        int time = Integer.parseInt(timeString);
        Kick_Boxing.perform_ACTIVITY(time);
        heartRLabel.setText("Heart Rate=  " + df.format(user.getHeartRate()) + " beat per minute");
        caloriesLabel.setText("Calories Burnt=    " + user.getCaloriesBurnt() + " calories");
        if(Kick_Boxing.verifyChange) verification.setText("Activity: (Kick_Boxing) Recorded Successfully");
        else verification.setText("Failed to record Kick_Boxing");
    });
    trainButton.setOnAction(e->{
        String timeString = timeField.getText();
        int time = Integer.parseInt(timeString);
        Strength_Training.perform_ACTIVITY(time);
        heartRLabel.setText("Heart Rate=   " + df.format(user.getHeartRate()) + "  beat per minute");
        caloriesLabel.setText("Calories Burnt=   " + user.getCaloriesBurnt() + " calories");
        if(Strength_Training.verifyChange) verification.setText("Activity: (Strength_Training) Recorded Successfully");
        else verification.setText("Failed to record Strength_Training");
    });
    resultsButton.setOnAction(e->{
        results.ResultsWindow();
        stage.setScene(results.getScene());

    });
}
public Scene getScene(){

        return this.scene;
    }

}
