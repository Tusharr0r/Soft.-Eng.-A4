
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


 public class PrescriptionTest  {

@BeforeEach
	void setup() throws Exception {
		
	}
// First , We will test the addPrescription Method
@Test  
void testwithvalidinfo() {//Test Case 1
	//Testing with valid inputs
	//Test data 1
	Prescription p0=new Prescription("P101", "Jack","Radhakrishnanav","Wolf Street, Richmond,1234, Australia", -20.00f ,180.0f, 4.00f, "23/10/24","Dr. Vu Huy Mai");
	assertTrue(p0.addPrescription());
	
	//Test data 2
	Prescription p1=new Prescription("P101", "abcdefghijklmno","Radhakrishnanav","Wolf Street, Richmond,1234, Australia", -20.00f ,180.0f, 4.00f, "23/10/24","Dr. Vu Huy Mai");
	assertTrue(p1.addPrescription());
}


@Test
void  testaddPrescriptionInvalidfname() {//Test case 2
	
	//Test a first name with  3 characters
	//Test data 1 
	Prescription p2=new Prescription("P102","Joe","Rogan ","Wolf Street, Richmond,1234, Australia",-20.00f,180.0f,4.00f,"23/10/24","Dr. Vu Huy Mai");
	assertFalse(p2.addPrescription());
	
	//Test a first name with 16 characters
	//Test data 2
	Prescription p3=new Prescription("P102","abcdefghijklmnop","Rogan ","Wolf Street, Richmond,1234, Australia",-20.00f,180.0f,4.00f,"23/10/24","Dr. Vu Huy Mai");
	assertFalse(p3.addPrescription());
}

@Test
void testaddPrescriptionInvalidlname() {//Test case 3
	//Test last name with 3 characters
	//Test data 1 
	Prescription p4=new Prescription("P103", "Halil","Ali","Wolf Street, Richmond,1234, Australia",-20.00f ,180.0f, 4.00f, "23/10/24","Dr. Vu Huy Mai");
	assertFalse(p4.addPrescription());
	
	//Test last name with 16 characters
	//Test data 2
	Prescription p5=new Prescription("P103", "Halil","abcdefghijklmnop","Wolf Street, Richmond,1234, Australia",-20.00f ,180.0f, 4.00f, "23/10/24","Dr. Vu Huy Mai");
	assertFalse(p5.addPrescription());
}

@Test 
void testwithinvalidaddresss() {//Test case 4
	//Test address with empty value
	//Test Data 1
	Prescription p6=new Prescription("P104", "Halil","Ali","",-20.00f ,180.0f, 4.00f, "23/10/24","Dr. Vu Huy Mai");
	assertFalse(p6.addPrescription());
	
	//Test address less than 20 characters
	//Test Data 2
	Prescription p7=new Prescription("P104", "Halil","Ali","Mel , Aus",-20.00f ,180.0f, 4.00f, "23/10/24","Dr. Vu Huy Mai");
	assertFalse(p7.addPrescription());
	
}
@Test
void testinvalidsphere() {//Test case 5
	//Test sphere with value less than -20.00
	//Test data 1
	Prescription p8=new Prescription("P105", "Jack","Hughman","Wolf Street, Melbourne,1233, Australia",-20.01f ,180.0f, 4.00f, "23/10/24","Dr. Vu Huy Mai");
	assertFalse(p8.addPrescription());
	
	//Test sphere with value more than 20.00
	Prescription p9=new Prescription("P105", "Jack","Hughman","Wolf Street, Melbourne,1233, Australia",20.01f ,180.0f, 4.00f, "23/10/24","Dr. Vu Huy Mai");
	assertFalse(p9.addPrescription());
}

@Test 
void testinvalidcylinder() {//Test Case 6
	//Test cylinder with value less than -4.00
	//Test data 1
	Prescription p10=new Prescription("P106", "Jack","Reacher","Wolf Street, Richmond,1234, Australia",-20.00f ,180.0f, 4.01f, "23/10/24","Dr. Vu Huy Mai");
	assertFalse(p10.addPrescription());
	
	//Test data 2
	//Test cylinder with value greater than 4.0
	Prescription p11=new Prescription("P106", "Jack","Reacher","Wolf Street, Richmond,1234, Australia",-20.00f ,180.0f,-4.01f, "23/10/24","Dr. Vu Huy Mai");
	assertFalse(p11.addPrescription());
}
@Test 
void testinvalidaxis() {//Test case 7
	//Test axis with value less than 0.00
    //Test data 1
	Prescription p12=new Prescription("P107", "John","Radhakrishnanav","Wolf Street, Richmond,1234, Australia",-20.00f ,-0.1f, 4.00f, "23/10/24","Dr. Vu Huy Mai");
	assertFalse(p12.addPrescription());
	//Test data 2
	//Test axis with value greater than 180.0
	Prescription p13=new Prescription("P107", "John","Radhakrishnanav","Wolf Street, Richmond,1234, Australia",-20.00f ,180.1f, 4.00f, "23/10/24","Dr. Vu Huy Mai");
	assertFalse(p13.addPrescription());
}
@Test 
void testinvalidoptometrist() {//Test case 8
	//Test optometrist with less than 8 words
	//Test case 1
	Prescription p14=new Prescription("P109", "Jack","Radhakrishnanav","Wolf Street, Richmond,1234, Australia",-20.00f ,180.0f, 4.00f, "23/10/24","Dr Joey");
	assertFalse(p14.addPrescription());
	
	//Test data 2
	//Test optometrist with more than 25 words
	Prescription p15=new Prescription("P109", "Jack","Radhakrishnanav","Wolf Street, Richmond,1234, Australia",-20.00f ,180.0f, 4.00f, "23/10/24","abcdefghijklmnopqrstuvwxyz");
	assertFalse(p15.addPrescription());
}


// Lets write test cases for addRemarks function 

@Test
void testwithvalidremarks() {//Test Case 1
	//Testing with the valid inputs
	Prescription p16 = new Prescription();
	assertTrue(p16.addRemark("Client","Customer is suffering from Myopia and Color Blindness."));
	 
	//Test data 2
	Prescription p17 = new Prescription();
	assertTrue(p17.addRemark("Optometrist","Dr. Vu Huy Mai is very experienced and trained optometrist." ));
	
}
@Test 
void testinvalidRemarkType() {//Test Case 2 
	//Test data 1 
	Prescription p18 = new Prescription();
	assertFalse(p18.addRemark("Admin","Customer is suffering from Myopia and Color Blindness." ));
	
	//Test data 2 
	Prescription p19 = new Prescription();
	assertFalse(p19.addRemark(null,"Customer is suffering from Myopia and Color Blindness." ));
}
@Test
void testinvalidremark() {//Test case 3
	//Test data 1
	Prescription p20 = new Prescription();
	assertFalse(p20.addRemark("Client","no issue is found and both the eyes are well." ));
	
	//Test data 2
	Prescription p21 = new Prescription();
	assertFalse(p21.addRemark("Client","Not Recommended." ));
}
@Test
void testwithinvalidNoofremarks() {//Test Case 4
	//Test data 1
	Prescription p22 = new Prescription();
	assertFalse(p22.addRemark("Client","" ));
	
	//Test data 2
	Prescription p23 = new Prescription();
	assertTrue(p23.addRemark("Client","Customer is suffering from Myopia and Color Blindness."));
    assertTrue(p23.addRemark("Client","Customer is also suffering from Hypermyopia."));
    assertFalse(p23.addRemark("Client","Customer is also suffering from Hypermyopia."));
}
@Test
void testinvalidtypeandremark() {//Test case 5
	//Test data 1
	Prescription p24 = new Prescription();
	assertFalse(p24.addRemark("Admin","no issue is found and both the eyes are well."));
	
	//Test data 2
	Prescription p25 = new Prescription();
	assertFalse(p25.addRemark("OPTOMETRIST","The total number of words in this remark should be more than 6 but less than 20 , but this will lead to increase in the word count."));
}
@Test 
void testinvalidtypeandnoofremarks() {//Test case 6
	//Test data 1
	Prescription p26 = new Prescription();
	assertFalse(p26.addRemark("CLIENT",""));
	
    //Test data 2
	Prescription p27 = new Prescription();
	assertTrue(p27.addRemark("Client","No issue is found and both eyes are well."));
	assertTrue(p27.addRemark("Client","No issue was found and both the eyes are well"));
	assertFalse(p27.addRemark("Client","No issue will be found and both the eyes will be well"));
}
}