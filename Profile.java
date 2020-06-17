/** A client's fitness profile. */
public class Profile{
  /** Represents a client's age in years.*/
  private int age;
  /** Represents a client's height and weight, (meters and kilograms respectively)*/
  private double height, weight;
  /** Represents a client's gender. */
  private Gender gender; 
   
  
  //Getters
  
  /** @return Returns integer value of client's age.*/
  public int getAge() { return this.age; } 
   /** @return Returns integer value of client's height in meters.*/
  public double getHeight(){ return this.height; } 
    /** @return Returns double value of client's weight in kilograms.*/
  public double getWeight(){ return this.weight; }
  /** @return Returns client's gender.*/
  public Gender getGender(){ return this.gender; } 
  
  //Setters 
  
  /**@param age Set age of client.   */
  public void setAge(int age){ this.age = age; }
   /** @param height Set height for client.   */
  public void setHeight(double height){ this.height = height; }
  /**
   *@param weight Set weight of client.   */
  public void setWeight(double weight){ this.weight = weight; }
   /** @param gender Set Gender of client. */
  public void setGender(Gender gender){ this.gender = gender; }
  
  //Constructor
  public Profile(int age, double height, double weight, Gender gender){
    setAge(age);
    setHeight(height);
    setWeight(weight);
    setGender(gender);
  }
  
  //toString
  /** @return Returns a client's profile statistics */
  @Override public String toString(){
    return String.format("Age %d, Weight %.1fkg, Height %.1fm, Gender %s", age, weight, height, gender); 
  }
  
//Class methods
  
  /**
   * Calculate the Body Mass Index of a client. 
   * @return Double value of BMI. 
   */
  public double calcBMI(){
    return weight/(Math.pow(height,2)); 
  }
  
  /**
   * Calculate the daily caloric intake of a clients.
   * @return Double value of a client's caloric intake. 
   */
  public double dailyCalorieIntake(){
    switch(gender){
      case MALE:
        return (66.47 + (13.75 * this.weight) + (5.003 * (this.height*100.0)) - (6.755 * this.age));
      case FEMALE:
        return (655.1 + ( 9.563 * this.weight) + ( 1.85 * this.height*100.0) - ( 4.676 * this.age));
    }
    return 0.0; 
  }
}