public class ACTIVITY {
    private int CaloriesBurntPerMin;
    private double heartRateInc;
    private int totalCalories;
    private double totalHeartRateInc;
    private String name;
    public boolean verifyChange;
    User user;
    public ACTIVITY(int caloriesBurntPerMin, double heartRateInc, int totalCalories, double totalHeartRateInc, User user, String name) {
        this.CaloriesBurntPerMin = caloriesBurntPerMin;
        this.heartRateInc = heartRateInc;
        this.totalCalories = totalCalories;
        this.totalHeartRateInc = totalHeartRateInc;
        this.user = user;
        this.name = name;
    }
    public String getName(){

        return name;
    }
    public int getCaloriesBurnt(int time){

        return CaloriesBurntPerMin * time;
    }

    public void setTotalCalories(int time) {
        totalCalories += getCaloriesBurnt(time);

    }

    public int getTotalCalories(){
        return totalCalories;

    }

    public double newHeartRate(int time){

        return user.getHeartRate() + (user.getHeartRate() * time * heartRateInc);
    }

    public void setTotalHeartRateInc(int time) {

        totalHeartRateInc += (user.getHeartRate() * time * heartRateInc);
    }
    public double getTotalHeartRateInc() {
        return totalHeartRateInc;

    }
    public void perform_ACTIVITY(int time){
        verifyChange = false;
        user.setCaloriesBurnt(getCaloriesBurnt(time));
        setTotalHeartRateInc(time);
        user.setHeartRate(newHeartRate(time));
        setTotalCalories(time);
        verifyChange = true;

    }
    public static void sort(ACTIVITY[] activities){
        int i ,j;
        ACTIVITY temp;
        for(i = 0; i < 4 ; i++){
            for(j = 0; j < 4 - i - 1; j++){
                if(activities[j].totalCalories < activities[j + 1].totalCalories){
                    temp = activities[j];
                    activities[j] = activities[j + 1];
                    activities[j + 1] = temp;
                } else if(activities[j].totalCalories == activities[j + 1].totalCalories){
                    if(activities[j].totalHeartRateInc < activities[j+1].totalHeartRateInc){
                        temp = activities[j];
                        activities[j] = activities[j + 1];
                        activities[j + 1] = temp;
                    }
                }
            }
        }

    }


}