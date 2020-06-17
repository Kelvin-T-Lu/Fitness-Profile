/**
 * Swimming exercise that is 
 * classified as an Aerobic exercise
 */
public class Swimming extends Aerobic{
  private SwimmingType type;
  
  //Getter
  
  /**
   * @return Returns type of Swim
   */
  public SwimmingType getSwimmingType(){ return this.type; }
  
  //Setter
  /**
   * @param type Sets the swim type
   */
  public void setSwimmingType(SwimmingType type){ this.type = type; }
  
  //Constructors
  public Swimming(SwimmingType type){
    setSwimmingType(type);
  }
  
  /*
   * Sets the default swim to Freestyle
   */
  public Swimming(){
    this(SwimmingType.Freestyle);
  }
  
  //Class Methods
  
  /**
   * @return Returns the excercise String description to "Swimming"
   */
  @Override public String description(){
    return "Swimming"; 
  }
  
  /**
   * @return Returns the muscles utilized for the current instance of swim. 
   */
  @Override public Muscle[] muscleTargeted(){
    switch(type){
      case Butterflystroke:
        return new Muscle[]{Muscle.Abs, Muscle.Back, Muscle.Shoulders, Muscle.Biceps, Muscle.Triceps};
      case Breaststroke:
        return new Muscle[]{Muscle.Glutes, Muscle.Cardio};
      case Freestyle:
        return new Muscle[]{Muscle.Arms, Muscle.Legs, Muscle.Cardio};
    }
    return null; 
  }
  
  @Override public double calorieLoss(Intensity intensity, double weight, int duration){
    double x = 0.0; 
    switch(intensity){
      case HIGH:
        x = 10.0;
        break;
         
      case MEDIUM: 
        x = 8.3; 
        break; 
        
      case LOW: 
        x = 6.0; 
        break; 
    }
    return x * weight * duration/60.0;
  }
}