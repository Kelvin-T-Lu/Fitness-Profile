/**
 * An anaerobic excercise is a type of exercise
 * that consists of short exertion,
 * high-intensity movement.
 */
public abstract class Anaerobic implements Fitness{
   /**
   * Returns the description of an Anaerobic execercise.
   * @return String Description of Anaerobic
   */
  @Override public String description(){
    return "Anaerobic means \"without oxygen.\""; 
  }
}