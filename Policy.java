/**
 * The Policy class models an insurance policy and stores
 * details about both the policy and the individual covered.
 */
public class Policy
{
   private int policyNumber;
   private String providerName;
   private String firstName;
   private String lastName;
   private int age;
   private String smokingStatus;
   private double height;
   private double weight;

   /**
    * Default constructor that assigns initial default values
    * to all instance variables.
    */
   public Policy()
   {
      policyNumber = 0;
      providerName = "";
      firstName = "";
      lastName = "";
      age = 0;
      smokingStatus = "non-smoker";
      height = 0.0;
      weight = 0.0;
   }

   /**
    * Constructor that sets all policy attributes using
    * the values passed in as arguments.
    *
    * @param pNum the policy identification number
    * @param prov the name of the insurance company
    * @param fName the first name of the policyholder
    * @param lName the last name of the policyholder
    * @param theAge the policyholder's age
    * @param smoke the policyholder's smoking status
    * @param h the policyholder's height in inches
    * @param w the policyholder's weight in pounds
    */
   public Policy(int pNum, String prov, String fName, String lName,
                 int theAge, String smoke, double h, double w)
   {
      policyNumber = pNum;
      providerName = prov;
      firstName = fName;
      lastName = lName;
      age = theAge;
      smokingStatus = smoke;
      height = h;
      weight = w;
   }

   /**
    * Returns the policy number.
    * @return the policy number
    */
   public int getPolicyNumber() { return policyNumber; }

   /**
    * Returns the insurance provider's name.
    * @return the provider name
    */
   public String getProviderName() { return providerName; }

   /**
    * Returns the policyholder's first name.
    * @return the first name
    */
   public String getFirstName() { return firstName; }

   /**
    * Returns the policyholder's last name.
    * @return the last name
    */
   public String getLastName() { return lastName; }

   /**
    * Returns the policyholder's age.
    * @return the age
    */
   public int getAge() { return age; }

   /**
    * Returns the policyholder's smoking status.
    * @return the smoking status
    */
   public String getSmokingStatus() { return smokingStatus; }

   /**
    * Returns the policyholder's height in inches.
    * @return the height
    */
   public double getHeight() { return height; }

   /**
    * Returns the policyholder's weight in pounds.
    * @return the weight
    */
   public double getWeight() { return weight; }

   /**
    * Updates the policy number.
    * @param pNum the new policy number
    */
   public void setPolicyNumber(int pNum) { policyNumber = pNum; }

   /**
    * Updates the provider name.
    * @param prov the new provider name
    */
   public void setProviderName(String prov) { providerName = prov; }

   /**
    * Updates the policyholder's first name.
    * @param fName the new first name
    */
   public void setFirstName(String fName) { firstName = fName; }

   /**
    * Updates the policyholder's last name.
    * @param lName the new last name
    */
   public void setLastName(String lName) { lastName = lName; }

   /**
    * Updates the policyholder's age.
    * @param theAge the new age
    */
   public void setAge(int theAge) { age = theAge; }

   /**
    * Updates the policyholder's smoking status.
    * @param smoke the new smoking status
    */
   public void setSmokingStatus(String smoke) { smokingStatus = smoke; }

   /**
    * Updates the policyholder's height in inches.
    * @param h the new height
    */
   public void setHeight(double h) { height = h; }

   /**
    * Updates the policyholder's weight in pounds.
    * @param w the new weight
    */
   public void setWeight(double w) { weight = w; }

   /**
    * Computes the Body Mass Index (BMI) for the policyholder.
    *
    * @return the calculated BMI value
    */
   public double calculateBMI()
   {
      if(height <= 0)
         return 0.0;

      return (weight * 703) / (height * height);
   }

   /**
    * Determines the cost of the policy based on the
    * policyholder's age, smoking status, and BMI.
    *
    * @return the total policy price
    */
   public double calculatePolicyPrice()
   {
      double price = 600.0;

      if(age > 50)
         price += 75.0;

      if(smokingStatus != null && smokingStatus.equalsIgnoreCase("smoker"))
         price += 100.0;

      double bmi = calculateBMI();
      if(bmi > 35.0)
         price += (bmi - 35.0) * 20.0;

      return price;
   }
}
