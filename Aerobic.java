/**
 * An aerobic excercise is a type of exercise
 * that increases the amount of oxygen
 * delivered to the muscles.
 */
public abstract class Aerobic implements Fitness{
  
  /**
   * Returns the description of an Aerobic execercise.
   * @return String Description of Aerobic
   */
  @Override public String description(){
    return "Aerobic means \"with oxygen.\"";
  }
}