/**
 * A base interface that
 * represents all excercises. 
 */
public interface Fitness{
  
  /** 
   * @return Targeted muscles of exercise. 
   */
  public Muscle[] muscleTargeted();
  
  /**
   * Calculates the calories loss of an excercise.
   * @param intensity Intensity Enum of the excercise.
   * @param weight Weight of a person.
   * @param duration Duration of excercises in minutes.
   * @return Returns double value of Calories lost.
   */
  public double calorieLoss(Intensity intensity, double weight, int duration);
  
  /**
   * @return Returns String description of execercises.
   */
  public String description(); 
}