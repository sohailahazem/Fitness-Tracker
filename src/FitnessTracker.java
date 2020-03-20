import javafx.application.Application;
import javafx.stage.Stage;

public class FitnessTracker extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Fitness Tracker");
        User user = new User(0,80);
        ACTIVITY Swimming = new ACTIVITY(4, 0.002, 0, 0,user,"Swimming");
        ACTIVITY Running = new ACTIVITY(5, 0.003, 0, 0,user,"Running");
        ACTIVITY Kick_Boxing = new ACTIVITY(3, 0.005, 0, 0,user,"Kick_Boxing");
        ACTIVITY Strength_Training = new ACTIVITY(5, 0.006, 0, 0,user,"Strength_Training");
        ChooseActivity chooseActivity = new ChooseActivity(Swimming, Running, Kick_Boxing, Strength_Training, user, primaryStage);
        Results results = new Results(Swimming, Running, Kick_Boxing, Strength_Training, user, primaryStage);
        chooseActivity.ActivityWindow();
        chooseActivity.setResults(results);
        results.setChooseActivity(chooseActivity);
        primaryStage.setScene(chooseActivity.getScene());
        primaryStage.show();
    }
}

