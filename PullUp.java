public class PullUp extends Endurance{
  @Override public double calorieLoss(Intensity intensity, double weight, int duration){
    double x = 0.0; 
    switch(intensity){
      case HIGH:
        x = 7.5;
        break;
         
      case MEDIUM: 
        x = 6.0; 
        break; 
        
      case LOW: 
        x = 4.8; 
        break; 
    }
    return x * weight * duration/60.0;
  }
  
  @Override public String description(){ return "PullUp"; }
  
  @Override public Muscle[] muscleTargeted(){
    return new Muscle[]{Muscle.Biceps, Muscle.Arms};
  }
}