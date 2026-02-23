public class PolicyHolder
{
   private String firstName;
   private String lastName;
   private int age;
   private String smokingStatus;
   private double height;
   private double weight;

   public PolicyHolder()
   {
      firstName = "";
      lastName = "";
      age = 0;
      smokingStatus = "non-smoker";
      height = 0.0;
      weight = 0.0;
   }

   public PolicyHolder(String fName, String lName, int theAge,
                       String smoke, double h, double w)
   {
      firstName = fName;
      lastName = lName;
      age = theAge;
      smokingStatus = smoke;
      height = h;
      weight = w;
   }

   public String getFirstName() { return firstName; }
   public String getLastName() { return lastName; }
   public int getAge() { return age; }
   public String getSmokingStatus() { return smokingStatus; }
   public double getHeight() { return height; }
   public double getWeight() { return weight; }

   public void setFirstName(String fName) { firstName = fName; }
   public void setLastName(String lName) { lastName = lName; }
   public void setAge(int theAge) { age = theAge; }
   public void setSmokingStatus(String smoke) { smokingStatus = smoke; }
   public void setHeight(double h) { height = h; }
   public void setWeight(double w) { weight = w; }

   public double calculateBMI()
   {
      if(height <= 0)
         return 0.0;

      return (weight * 703) / (height * height);
   }

   public String toString()
   {
      return "Policyholder's First Name: " + firstName +
             "\nPolicyholder's Last Name: " + lastName +
             "\nPolicyholder's Age: " + age +
             "\nPolicyholder's Smoking Status (Y/N): " + smokingStatus +
             "\nPolicyholder's Height: " + String.format("%.1f", height) + " inches" +
             "\nPolicyholder's Weight: " + String.format("%.1f", weight) + " pounds" +
             "\nPolicyholder's BMI: " + String.format("%.2f", calculateBMI());
   }
}