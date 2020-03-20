public class User {
    private double heartRate;
    private int caloriesBurnt;


    public User(int caloriesBurnt, float heartRate) {
        this.caloriesBurnt = caloriesBurnt;
        this.heartRate = heartRate;
    }

     public void setCaloriesBurnt(int caloriesBurnt) {
        this.caloriesBurnt += caloriesBurnt;

    }

     public int getCaloriesBurnt() {
        return caloriesBurnt;

    }

     public double getHeartRate() {
        return heartRate;

    }

     public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;

    }
}
