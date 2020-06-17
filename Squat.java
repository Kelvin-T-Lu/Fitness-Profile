public class Squat extends Endurance{
  @Override public double calorieLoss(Intensity intensity, double weight, int duration){
    double x = 0.0; 
    switch(intensity){
      case HIGH:
        x = 7.0;
        break;
         
      case MEDIUM: 
        x = 5.0; 
        break; 
        
      case LOW: 
        x = 2.5; 
        break; 
    }
    return x * weight * duration/60.0;
  }
  
  @Override public String description(){ return "Squat"; }
  
  @Override public Muscle[] muscleTargeted(){
    return new Muscle[]{Muscle.Glutes, Muscle.Abs, Muscle.Back};
  }
}