public class Plyometrics extends Anaerobic{
  @Override public double calorieLoss(Intensity intensity, double weight, int duration){
    double x = 0.0; 
    switch(intensity){
      case HIGH:
        x = 7.4;
        break;
         
      case MEDIUM: 
        x = 4.8; 
        break; 
        
      case LOW: 
        x = 2.5; 
        break; 
    }
    return x * weight * duration/60.0;
  }
  
  @Override public String description(){ return "Plyometrics"; }
  
  @Override public Muscle[] muscleTargeted(){
    return new Muscle[]{Muscle.Abs, Muscle.Legs, Muscle.Glutes};
  }
}