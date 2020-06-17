public class WeightLifting extends Anaerobic{
  @Override public double calorieLoss(Intensity intensity, double weight, int duration){
    double x = 0.0; 
    switch(intensity){
      case HIGH:
        x = 6.0;
        break;
         
      case MEDIUM: 
        x = 5.0; 
        break; 
        
      case LOW: 
        x = 3.5; 
        break; 
    }
    return x * weight * duration/60.0;
  }
  
  @Override public String description(){ return "WeightLifting"; }
  
  @Override public Muscle[] muscleTargeted(){
    return new Muscle[]{Muscle.Shoulders, Muscle.Legs, Muscle.Arms, Muscle.Triceps};
  }
}