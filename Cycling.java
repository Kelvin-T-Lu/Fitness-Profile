/**
 * Cycling exercise that is 
 * classified as an Aerobic exercise
 */
public class Cycling extends Aerobic{
  
  @Override public Muscle[] muscleTargeted(){
    return new Muscle[]{Muscle.Glutes, Muscle.Cardio, Muscle.Legs};
  }
  
  @Override public String description(){ return "Cycling"; }
  
  @Override public double calorieLoss(Intensity intensity, double weight, int duration){
    double x = 0.0; 
    switch(intensity){
      case HIGH:
        x = 14.0;
        break;
         
      case MEDIUM: 
        x = 8.5; 
        break; 
        
      case LOW: 
        x = 4.0; 
        break; 
    }
    return x * weight * duration/60.0;
  }
  
}