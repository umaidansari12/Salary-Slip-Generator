package oopsandooad;


import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

public class Employee {
    private String Name;
    private String CompanyName;
    private double BasicSalary;
    private double HouseRentAllowance;
    private double DearnessAllowance;
    private double TravellingAllowance;
    private double MedicalAllowance;
    private double ProvidentFund;
    private double GrossSalary;
    private double NetSalary;
    private double TaxRate;

    Employee(String name,String companyName,double basicSalary)
    {
        setName(name);
        setCompanyName(companyName);
        setBasicSalary(basicSalary);
        setHouseRentAllowance(0.3*BasicSalary);
        setDearnessAllowance(0.1*BasicSalary);
        setTravellingAllowance(0.2*BasicSalary);
        setMedicalAllowance(0.15*BasicSalary);
        setProvidentFund(0.1*BasicSalary);
        setGrossSalary(getBasicSalary() + getHouseRentAllowance() + getDearnessAllowance() + getTravellingAllowance() + getMedicalAllowance()-getProvidentFund());
        setTaxRate();
        setNetSalary(getGrossSalary() - getTaxRate());
    }

    public double getTaxRate() {
        return TaxRate;
    }

    public void setTaxRate() {
        double taxRate = 0.0;
        if(this.BasicSalary>900000)
        taxRate=0.3;
        else if(this.BasicSalary>700000 && this.BasicSalary<=900000)
        taxRate = 0.2;
        else if(this.BasicSalary>500000 && this.BasicSalary<=700000)
        taxRate = 0.1;
        this.TaxRate = taxRate * BasicSalary;
    }

    public double getNetSalary() {
        return NetSalary;
    }

    public void setNetSalary(double netSalary) {
        this.NetSalary = netSalary;
    }

    public double getGrossSalary() {
        return GrossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.GrossSalary = grossSalary;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        this.CompanyName = companyName;
    }

    public double getBasicSalary() {
        return BasicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.BasicSalary = basicSalary;
    }

    public double getHouseRentAllowance() {
        return HouseRentAllowance;
    }

    public void setHouseRentAllowance(double houseRentAllowance) {
        this.HouseRentAllowance = houseRentAllowance;
    }

    public double getDearnessAllowance() {
        return DearnessAllowance;
    }

    public void setDearnessAllowance(double dearnessAllowance) {
        this.DearnessAllowance = dearnessAllowance;
    }

    public double getTravellingAllowance() {
        return TravellingAllowance;
    }

    public void setTravellingAllowance(double travellingAllowance) {
        this.TravellingAllowance = travellingAllowance;
    }

    public double getMedicalAllowance() {
        return MedicalAllowance;
    }

    public void setMedicalAllowance(double medicalAllowance) {
        this.MedicalAllowance = medicalAllowance;
    }

    public double getProvidentFund() {
        return ProvidentFund;
    }

    public void setProvidentFund(double providentFund) {
        this.ProvidentFund = providentFund;
    }

    public void printSalarySlip()
    {
        System.out.println("-----------------------------------------------------");
        System.out.println("                    SALARY SLIP                      ");
        System.out.println("-----------------------------------------------------");
        System.out.println("Name : "+getName());
        System.out.println("Company Name : "+getCompanyName());
        String string = "\u20B9";
        byte[] utf8 = null;
		try {
			utf8 = string.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        try {
			string = new String(utf8, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Basic Salary : "+string+" "+getBasicSalary()); 
        System.out.println("House Rent Allowance : "+string+" "+getHouseRentAllowance()); 
        System.out.println("Basic Salary : "+string+" "+getBasicSalary()); 
        System.out.println("Dearness Allowance : "+string+" "+getDearnessAllowance());
        System.out.println("Travelling Allowance : "+string+" "+getTravellingAllowance());
        System.out.println("Medical Allowance : "+string+" "+getMedicalAllowance());
        System.out.println("Provident Fund : "+string+" "+getProvidentFund()); 
        System.out.println("Gross Salary : "+string+" "+getGrossSalary());
        System.out.println("Tax : "+string+" "+getTaxRate());
        System.out.println("Net Salary : "+string+" "+getNetSalary());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        System.out.println("-----------------------------------------------------");  
        System.out.println("           Generated On : "+dtf.format(now));
        System.out.println("-----------------------------------------------------");
    }

    public static String convertTitleCase(String input){
        StringBuilder output = new StringBuilder(input.length());
        boolean nextTitleCase = true;
        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase && Character.isLowerCase(c)) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }else if(!nextTitleCase && Character.isUpperCase(c))
            {
                c=Character.toLowerCase(c);
                nextTitleCase = false;
            }
            output.append(c);
        }

        return output.toString();
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number of Employees : ");
        int n=scanner.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter Name : ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.println("Enter Company Name : ");
            String companyName = scanner.nextLine();
           // scanner.nextLine();
            System.out.println("Enter Basic Salary : ");
            double basicSalary = scanner.nextDouble();
            name = convertTitleCase(name);
            Employee ob = new Employee(name, companyName, basicSalary);
            ob.printSalarySlip();
        }
        scanner.close();
    }
    
}
