import java.util.ArrayList; 

public class WeeklyExercise{
  /** Weekly exercise List */ 
  private ArrayList<Fitness> exerciseList;
  /** Number of days to workout. */ 
  private int days; 
  /** Targetted Calories */ 
  private double weeklyCalorieTarget;
  /** Client's profile. */ 
  private Profile profile; 
  
  
  //Getters
  /** @return A list of exercises person must do. */ 
  public ArrayList<Fitness> getExerciseList(){ return this.exerciseList; }
  /** @return A integer value of the number of days a client wants to work. */ 
  public int getDays(){ return this.days; } 
  /** @return A double value of amount of calories targetted in a week. */
  public double getWeeklyCalorieTarget(){ return this.weeklyCalorieTarget; } 
  /** @return Returns the client's profile */ 
  public Profile getProfile(){ return this.profile; }
  
  //Setters
  
  /** @param listSets the exerciseList. */ 
  public void setExerciseList(ArrayList<Fitness> list){ this.exerciseList = list; } 
  /** @param days Sets the number of days to workout */ 
  public void setDays(int days){ this.days = days; }
  /** @param target Sets the weekly calorie target */ 
  public void setWeeklyCalorieTarget(double target){ this.weeklyCalorieTarget = target; }
  /** @param profile Sets the profile of the client. */ 
  public void setProfile(Profile profile){ this.profile = profile; }

  //Constructors
  public WeeklyExercise(ArrayList<Fitness> exerciseList, int days, double weeklyCalorieTarget, Profile profile){
    setExerciseList(exerciseList);
    setDays(days);
    setWeeklyCalorieTarget(weeklyCalorieTarget);
    setProfile(profile); 
  }
  public WeeklyExercise(ArrayList<Fitness> exerciseList, Profile profile){
    this(exerciseList, 7, 3500, profile);
  }
  
  //Class Methods
  
  /** @param Adds an exercise to the list. */ 
  public void addExercise(Fitness ex){
    exerciseList.add(ex);
  }
  /** @param Removes a specified exercise in the list. */ 
  public void removeExercise(Fitness ex){
    exerciseList.remove(ex);
  }
  
  public ArrayList<DailyExercise> getWeeklyExercises(Intensity intensity){
    ArrayList<DailyExercise> end = new ArrayList<DailyExercise>(); 
    double x= weeklyCalorieTarget/ ((double)days); //Calories needed to burn per day
    
    for(Fitness i: exerciseList){
      //Calculates the duration of exercise for current day. 
      double y = i.calorieLoss(intensity, this.profile.getWeight(), 1); //Calories burnt in one minute with exercise. 
      int duration = (int) (x/y);  //Daily Targeted Calories divided Calories burnt with one minute session of exercise. 
      

      //Creates an array list to instantiate 
      ArrayList<Fitness> temp = new ArrayList<Fitness>(); 
      temp.add(i); 
      
      end.add(new DailyExercise(temp, duration, x, this.profile));  
    }
    return end; 
  }
  
  public ArrayList<DailyExercise>getWeeklyExercises(){
    return getWeeklyExercises(Intensity.LOW); 
  }
  
  /** @return Returns a String that calculates the caloric deficit and the caloric intake.
    * @exception TargetWightException if target weight is greater than current weight. 
    */
  public String targetedCalorieLoss(double targetWeight, int withInDays) throws TargetWeightException{
   
      if (profile.getWeight() <= targetWeight){ //Checks if the target is to lose weight
        throw new TargetWeightException();
      }
      double weightLoss = profile.getWeight() - targetWeight; //Total targetted Weight Loss of time period
      double x = (weightLoss * 7000)/withInDays; // Targeted Daily Calorie Deficit
      double y = this.profile.dailyCalorieIntake() - x; //Daily Caloric intake        
      return String.format("You need to lose %.2f calories per day or decrease your intake from %.2f to %.2f inorder to lose %.2f kg of weight", x, this.profile.dailyCalorieIntake(), y, weightLoss);

    }

  
}