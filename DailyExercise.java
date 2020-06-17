import java.util.ArrayList;

/** A client's daily exercise planner. */
public class DailyExercise{
   /** List of registered exercises. */
  private final Fitness[] excer = new Fitness[]{new Swimming(SwimmingType.Freestyle), new Swimming(SwimmingType.Breaststroke), new Swimming(SwimmingType.Butterflystroke), new Cycling(), new WeightLifting(), new Plyometrics(), new Yoga(), new TaiChi(), new Squat(), new PullUp()};
  
  //Instance variables
  
  /** A list of exercises a client must do. */
  private ArrayList<Fitness> exerciseList; 
  /** Duration of workouts (in minutes)   */
  private int duration;
  /** Calorie target of client   */
  private double calorieTarget;
  /**  A client's profile */
  private Profile profile; 
 
  //Getters
  
  /** @return Returns arraylist of excercises. */
  public ArrayList<Fitness> getExerciseList(){ return this.exerciseList; }
  /** @return Returns targeted duration of excercises. */
  public int getDuration(){ return this.duration; }
  /** @return Return double value of Calorie Target. */
  public double getCalorieTarget(){ return this.calorieTarget; }
  /** @return Return a client's profile. */ 
  public Profile getProfile(){ return this.profile; }
  
  //Setters
  
  /** @param list Sets excercise list to excercise list. */
  public void setExerciseList(ArrayList<Fitness> list){ this.exerciseList = list; }
  /** @param duration Sets excercise duration to duration. */
  public void setDuration(int duration){ this.duration = duration; } 
  /** @param target Sets caloric target. */
  public void setCalorieTarget(double target){ this.calorieTarget = target; }
  /** @param profile Sets profile. */
  public void setProfile(Profile profile){ this.profile = profile; }


  //Constructors
  
  public DailyExercise(ArrayList<Fitness> exerciseList, int duration, double calorieTarget, Profile profile){
    setExerciseList(exerciseList); 
    setDuration(duration); 
    setCalorieTarget(calorieTarget);
    setProfile(profile); 
  }
  
  public DailyExercise(ArrayList<Fitness> exerciseList, Profile profile){
    this(exerciseList, 60 , 500, profile);
  }
  
  //Class Methods
  
  /** @param ex Adds an excercise to the list. */
  public void addExercise(Fitness ex){
    exerciseList.add(ex); 
  }
  /** @param ex Removes a deignated excercise from the list. */ 
  public void removeExercise(Fitness ex){
    exerciseList.remove(ex); 
  }
  
  /** 
   * @param targetMuscle Use to find excercise that fulfil the target muscles. 
   * @return Returns an array with excercise objects that target specified muscles.  
   */
  public Fitness[] getExercises(Muscle[] targetMuscle){
    //Use to find the index of getExcercises
    ArrayList<Fitness> result = new ArrayList<Fitness>();
    int size = 0; 
    //Search for all excercises in excerciseList that hits target tuscles 
    for(Fitness i: exerciseList){
      boolean temp = true; 
      for(Muscle j: targetMuscle){
        if(!find(i,j)){
          temp = false;
        }
      }
      if(temp){
        result.add(i); 
      }
    }
    //return result.toArray(new Fitness[0]); Assertion Error on getExercise_3
    if(result.size() == 0){ return null; } //Returns null if list is empty
    return copy(result); //Converts ArrayList into array 
  }
  
  /** 
   * @param i The muscle we are trying to find
   * @param j The excercise movement that's being serarched
   * @return Return if i is in j
   */
  public boolean find(Fitness j ,Muscle i){
    Muscle[] a = j.muscleTargeted(); 
    for(Muscle x: a){
      if(x == i){
        return true; 
      }
    }
    return false; 
  }
  
  /**
   * @param list Array list that is being copied of Fitness objects. 
   * @return Returns a regular array of Fitness objects. 
   */
  public Fitness[] copy(ArrayList<Fitness> list){
    Fitness[] end = new Fitness[list.size()];
    
    for(int i=0; i<list.size(); i++){
      end[i] = list.get(i);
    }
    
    return end;
  }
}