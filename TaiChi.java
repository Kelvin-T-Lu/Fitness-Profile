public class TaiChi extends Flexibility{
  @Override public double calorieLoss(Intensity intensity, double weight, int duration){
    double x = 0.0; 
    switch(intensity){
      case HIGH:
        x = 5.0;
        break;
         
      case MEDIUM: 
        x = 3.0; 
        break; 
        
      case LOW: 
        x = 1.5; 
        break; 
    }
    return x * weight * duration/60.0;
  }
  
  @Override public String description(){ return "TaiChi"; }
  
  @Override public Muscle[] muscleTargeted(){
    return new Muscle[]{Muscle.Arms, Muscle.Legs};
  }
}