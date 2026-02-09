import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Project_jalex_martinez
{
   public static void main(String[] args) throws IOException
   {
      Locale.setDefault(Locale.US);

      ArrayList<Policy> policies = new ArrayList<Policy>();

      File file = new File("PolicyInformation.txt");
      Scanner inputFile = new Scanner(file);
      inputFile.useLocale(Locale.US);

      while(inputFile.hasNext())
      {
         int policyNumber = inputFile.nextInt();
         inputFile.nextLine(); // consume endline

         String providerName = inputFile.nextLine();
         String firstName = inputFile.nextLine();
         String lastName = inputFile.nextLine();

         int age = inputFile.nextInt();
         inputFile.nextLine(); // consume endline

         String smokingStatus = inputFile.nextLine();

         double height = inputFile.nextDouble();
         double weight = inputFile.nextDouble();

         if(inputFile.hasNextLine())
            inputFile.nextLine(); // move to next line after weight

         Policy policy = new Policy(policyNumber, providerName, firstName, lastName,
                                    age, smokingStatus, height, weight);

         policies.add(policy);
      }

      inputFile.close();

      int smokerCount = 0;
      int nonSmokerCount = 0;

      for(int i = 0; i < policies.size(); i++)
      {
         Policy p = policies.get(i);

         displayPolicy(p);
         System.out.println();

         if(p.getSmokingStatus().equalsIgnoreCase("smoker"))
            smokerCount++;
         else
            nonSmokerCount++;
      }

      System.out.println("The number of policies with a smoker is: " + smokerCount);
      System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
   }

   public static void displayPolicy(Policy p)
   {
      System.out.println("Policy Number: " + p.getPolicyNumber());
      System.out.println("Provider Name: " + p.getProviderName());
      System.out.println("Policyholder's First Name: " + p.getFirstName());
      System.out.println("Policyholder's Last Name: " + p.getLastName());
      System.out.println("Policyholder's Age: " + p.getAge());
      System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + p.getSmokingStatus());
      System.out.printf("Policyholder's Height: %.1f inches\n", p.getHeight());
      System.out.printf("Policyholder's Weight: %.1f pounds\n", p.getWeight());
      System.out.printf("Policyholder's BMI: %.2f\n", p.calculateBMI());
      System.out.printf("Policy Price: $%.2f\n", p.calculatePolicyPrice());
   }
}/**
 * The Policy class represents an insurance policy and contains information
 * about the policy and the policyholder.
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
    * No-arg constructor that initializes all fields to default values.
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
    * Constructor that initializes the policy fields with provided values.
    *
    * @param pNum The policy number
    * @param prov The insurance provider name
    * @param fName The policyholder's first name
    * @param lName The policyholder's last name
    * @param theAge The policyholder's age
    * @param smoke The policyholder's smoking status
    * @param h The policyholder's height in inches
    * @param w The policyholder's weight in pounds
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
    * Gets the policy number.
    * @return The policy number
    */
   public int getPolicyNumber() { return policyNumber; }

   /**
    * Gets the provider name.
    * @return The provider name
    */
   public String getProviderName() { return providerName; }

   /**
    * Gets the policyholder's first name.
    * @return The policyholder's first name
    */
   public String getFirstName() { return firstName; }

   /**
    * Gets the policyholder's last name.
    * @return The policyholder's last name
    */
   public String getLastName() { return lastName; }

   /**
    * Gets the policyholder's age.
    * @return The policyholder's age
    */
   public int getAge() { return age; }

   /**
    * Gets the policyholder's smoking status.
    * @return The policyholder's smoking status
    */
   public String getSmokingStatus() { return smokingStatus; }

   /**
    * Gets the policyholder's height in inches.
    * @return The policyholder's height
    */
   public double getHeight() { return height; }

   /**
    * Gets the policyholder's weight in pounds.
    * @return The policyholder's weight
    */
   public double getWeight() { return weight; }

   /**
    * Sets the policy number.
    * @param pNum The policy number
    */
   public void setPolicyNumber(int pNum) { policyNumber = pNum; }

   /**
    * Sets the provider name.
    * @param prov The provider name
    */
   public void setProviderName(String prov) { providerName = prov; }

   /**
    * Sets the policyholder's first name.
    * @param fName The policyholder's first name
    */
   public void setFirstName(String fName) { firstName = fName; }

   /**
    * Sets the policyholder's last name.
    * @param lName The policyholder's last name
    */
   public void setLastName(String lName) { lastName = lName; }

   /**
    * Sets the policyholder's age.
    * @param theAge The policyholder's age
    */
   public void setAge(int theAge) { age = theAge; }

   /**
    * Sets the policyholder's smoking status.
    * @param smoke The policyholder's smoking status
    */
   public void setSmokingStatus(String smoke) { smokingStatus = smoke; }

   /**
    * Sets the policyholder's height in inches.
    * @param h The policyholder's height
    */
   public void setHeight(double h) { height = h; }

   /**
    * Sets the policyholder's weight in pounds.
    * @param w The policyholder's weight
    */
   public void setWeight(double w) { weight = w; }

   /**
    * Calculates the policyholder's BMI.
    *
    * @return The BMI value
    */
   public double calculateBMI()
   {
      if(height <= 0)
         return 0.0;

      return (weight * 703) / (height * height);
   }

   /**
    * Calculates the policy price based on age, smoking status, and BMI.
    *
    * @return The calculated policy price
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