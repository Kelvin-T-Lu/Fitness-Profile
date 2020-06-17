public class Yoga extends Flexibility{
  @Override public double calorieLoss(Intensity intensity, double weight, int duration){
    double x = 0.0; 
    switch(intensity){
      case HIGH:
        x = 4.0;
        break;
         
      case MEDIUM: 
        x = 3.0; 
        break; 
        
      case LOW: 
        x = 2.0; 
        break; 
    }
    return x * weight * duration/60.0;
  }
  
  @Override public String description(){ return "Yoga"; }
  
  @Override public Muscle[] muscleTargeted(){
    return new Muscle[]{Muscle.Triceps, Muscle.Biceps};
  }
}