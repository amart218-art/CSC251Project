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

   public int getPolicyNumber() { return policyNumber; }
   public String getProviderName() { return providerName; }
   public String getFirstName() { return firstName; }
   public String getLastName() { return lastName; }
   public int getAge() { return age; }
   public String getSmokingStatus() { return smokingStatus; }
   public double getHeight() { return height; }
   public double getWeight() { return weight; }

   public void setPolicyNumber(int pNum) { policyNumber = pNum; }
   public void setProviderName(String prov) { providerName = prov; }
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