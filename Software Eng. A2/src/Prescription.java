import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.StringTokenizer;

public class Prescription {
	private String prescID;
	private String firstName;
	private String lastName;
	private String address;
	private float sphere;
	private float axis;
	private float cylinder;
	private String examinationDate;   //string format
	private String optometrist;
	private String [] remarkTypes= {"Client","Optometrist"};
	private ArrayList <String> postRemarks = new ArrayList<>();
	private LocalDate parsedDate;    // parsed date
	
	//Constructor to initialise the class variables
	public Prescription(String prescID, String firstName , String lastName , String address,float sphere, float axis, float cylinder ,String examinationDate , String optometrist) {
	this.prescID = prescID;
	this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.sphere = sphere;
    this.axis = axis;
    this.cylinder = cylinder;
    this.examinationDate = examinationDate;
    this.optometrist = optometrist;
    
    
    
    //Checking the date format 
    if (validateAndParseDate(examinationDate)){
    	this.parsedDate = LocalDate.parse(examinationDate,DateTimeFormatter.ofPattern("dd/MM/yy"));
    }
    else {
    	this.parsedDate=null;
      }
		
	}
	
	// method for parsing date
	public boolean validateAndParseDate(String datedt) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
		try {
		LocalDate.parse(datedt, formatter);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
	
	// add prescription method starts here
	public boolean addPrescription()
	{	
		// validating the first name
		if(firstName.length() < 4 ||firstName.length()>15) {
			return false;	
		}
		//validating the last name
		if(lastName.length() < 4 || lastName.length() > 15) {
			return false;
		}
		//validating the address
		if (address.length() < 20) {
			return  false;
		}
		//validating sphere value
		if (sphere < -20.00 || sphere > 20.00) {
			return false;
		}
		//validating the value of cylinder
		if(cylinder <-4.00 || cylinder>4.00) {
			return false;
		}
		//validating the value of axis
		if (axis < 0 || axis > 180) {
			return false;
		}
		//checking parse date
		if (parsedDate == null) {
			return false;
		}
		//Validating optometrist name
		 if (optometrist.length() < 8 || optometrist.length() > 25) {
			 return false;
		 }
		 
		 
		return true;
		
	}
	//Another  constructor with empty parameters for addRemark method
    public Prescription() {
        this.postRemarks = new ArrayList<>();
    }
	public boolean addRemark(String remarkType , String Remarks)
	{
		//Validating the correct remark type
		if(!Arrays.asList(remarkTypes).contains(remarkType)) {
			return false;
		}
		// tokenizer for counting words in remarks
		StringTokenizer tokens = new StringTokenizer(Remarks);
		int words = tokens.countTokens();
		
		//validating the words count of remarks
		if(words < 6 || words>20) {
			return false;
		}
		
		//Validating the first character of remarks
		if(!Character.isUpperCase(Remarks.trim().charAt(0))) {
			return false;
		}
		//Validating the no. of remarks
		if (postRemarks.size () >=2) {
			return false;
		}
		postRemarks.add(Remarks);
		return true;
	  }
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
