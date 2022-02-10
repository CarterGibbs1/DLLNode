import java.util.Scanner;

/**
 * Runs a set of black box tests for lists that 
 * implement ListIterator interface. 
 * 
 * @author CS221
 */

public class RunListIteratorTests
{
	// run tests on IUDoubleLinkedList class 
	private final static ListType LIST_TYPE = ListType.doubleLinkedList;

	// instance variables for tracking test results
	private static int passes = 0; 
	private static int failures = 0; 
	private static int totalPasses = 0;
	private static int totalFailures = 0;
	private static int overallTotal = 0;

	/** 
	 * Run tests
	 * @param args - not used in this test suite
	 */
	public static void main(String[] args)
	{
		runTests();
		
		// report final verdict
		printFinalSummary();
	}
	
	/** 
	 * Run tests to confirm required functionality of implementation
	*/
	private static void runTests()
	{	
	    // create a scanner so we can read the command-line input
	    Scanner scanner = new Scanner(System.in);
		
	    //  Pause tests
	    System.out.print("To run tests for test classes 1 - 10, enter any character: ");
	    scanner.next();
	    
		// ListIterator tests for given change scenarios
		ListItrTest_1_constructor_emptyList constructor_emptyList = new ListItrTest_1_constructor_emptyList();
		printDescription(constructor_emptyList.getDescription());
		constructor_emptyList.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_2_emptyList_addToFrontA_A emptyList_addToFrontA_A = new ListItrTest_2_emptyList_addToFrontA_A();
		printDescription(emptyList_addToFrontA_A.getDescription());
		emptyList_addToFrontA_A.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_3_emptyList_addToRearA_A emptyList_addToRearA_A = new ListItrTest_3_emptyList_addToRearA_A();
		printDescription(emptyList_addToRearA_A.getDescription());
		emptyList_addToRearA_A.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_4_emptyList_addA_A emptyList_addA_A = new ListItrTest_4_emptyList_addA_A();
		printDescription(emptyList_addA_A.getDescription());
		emptyList_addA_A.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_5_emptyList_add0A_A emptyList_add0A_A = new ListItrTest_5_emptyList_add0A_A();
		printDescription(emptyList_add0A_A.getDescription());
		emptyList_add0A_A.run(LIST_TYPE); 
		printLine(); 
				
		ListItrTest_6_A_addToFrontB_BA A_addToFrontB_BA = new ListItrTest_6_A_addToFrontB_BA();
		printDescription(A_addToFrontB_BA.getDescription());
		A_addToFrontB_BA.run(LIST_TYPE); 
		printLine(); 
		
		ListItrTest_7_A_addToRearB_AB A_addToRearB_AB = new ListItrTest_7_A_addToRearB_AB();
		printDescription(A_addToRearB_AB.getDescription());
		A_addToRearB_AB.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_8_A_addAfterBA_AB A_addAfterBA_AB = new ListItrTest_8_A_addAfterBA_AB();
		printDescription(A_addAfterBA_AB.getDescription());
		A_addAfterBA_AB.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_9_A_addB_AB A_addB_AB = new ListItrTest_9_A_addB_AB();
		printDescription(A_addB_AB.getDescription());
		A_addB_AB.run(LIST_TYPE); 
		printLine(); 

		ListItrTest_10__A_add0B_BA A_add0B_BA = new ListItrTest_10__A_add0B_BA();
		printDescription(A_add0B_BA.getDescription());
		A_add0B_BA.run(LIST_TYPE); 
		printLine(); 
		
		printIntermediateResults("Test classes 1 - 10"); 
		
	    //  Pause tests
	    System.out.print("To run tests for test classes 11- 20, enter any character: ");
	    scanner.next();
							
		ListItrTest_11_A_add1B_AB A_add1B_AB = new ListItrTest_11_A_add1B_AB();
		printDescription(A_add1B_AB.getDescription());
		A_add1B_AB.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_12_A_removeFirst_emptyList A_removeFirst_emptyList = new ListItrTest_12_A_removeFirst_emptyList();
		printDescription(A_removeFirst_emptyList.getDescription());
		A_removeFirst_emptyList.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_13_A_removeLast_emptyList A_removeLast_emptyList = new ListItrTest_13_A_removeLast_emptyList();
		printDescription(A_removeLast_emptyList.getDescription());
		A_removeLast_emptyList.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_14_A_removeA_emptyList A_removeA_emptyList = new ListItrTest_14_A_removeA_emptyList();
		printDescription(A_removeA_emptyList.getDescription());
		A_removeA_emptyList.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_15_A_remove0_emptyList A_remove0_emptyList = new ListItrTest_15_A_remove0_emptyList();
		printDescription(A_remove0_emptyList.getDescription());
		A_remove0_emptyList.run(LIST_TYPE); 
		printLine(); 
		
		ListItrTest_16_A_set0B_B A_set0B_B = new ListItrTest_16_A_set0B_B();
		printDescription(A_set0B_B.getDescription());
		A_set0B_B.run(LIST_TYPE); 
		printLine(); 
	
		ListItrTest_17_AB_addToFrontC_CAB AB_addToFrontC_CAB = new ListItrTest_17_AB_addToFrontC_CAB();
		printDescription(AB_addToFrontC_CAB.getDescription());
		AB_addToFrontC_CAB.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_18_AB_addToRearC_ABC AB_addToRearC_ABC = new ListItrTest_18_AB_addToRearC_ABC();
		printDescription(AB_addToRearC_ABC.getDescription());
		AB_addToRearC_ABC.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_19_AB_addAfterCA_ACB AB_addAfterCA_ACB = new ListItrTest_19_AB_addAfterCA_ACB();
		printDescription(AB_addAfterCA_ACB.getDescription());
		AB_addAfterCA_ACB.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_20_AB_addAfterCB_ABC AB_addAfterCB_ABC = new ListItrTest_20_AB_addAfterCB_ABC();
		printDescription(AB_addAfterCB_ABC.getDescription());
		AB_addAfterCB_ABC.run(LIST_TYPE); 
		printLine(); 

		printIntermediateResults("Test classes 11 - 20"); 

	    //  Pause tests
	    System.out.print("To run tests for test classes 21- 30, enter any character: ");
	    scanner.next();
		
		ListItrTest_21_AB_addC_ABC AB_addC_ABC = new ListItrTest_21_AB_addC_ABC();
		printDescription(AB_addC_ABC.getDescription());
		AB_addC_ABC.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_22_AB_add0C_CAB AB_add0C_CAB = new ListItrTest_22_AB_add0C_CAB();
		printDescription(AB_add0C_CAB.getDescription());
		AB_add0C_CAB.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_23_AB_add1C_ACB AB_add1C_ACB = new ListItrTest_23_AB_add1C_ACB();
		printDescription(AB_add1C_ACB.getDescription());
		AB_add1C_ACB.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_24_AB_add2C_ABC AB_add2C_ABC = new ListItrTest_24_AB_add2C_ABC();
		printDescription(AB_add2C_ABC.getDescription());
		AB_add2C_ABC.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_25_AB_removeFirst_B AB_removeFirst_B = new ListItrTest_25_AB_removeFirst_B();
		printDescription(AB_removeFirst_B.getDescription());
		AB_removeFirst_B.run(LIST_TYPE); 
		printLine(); 
		
		ListItrTest_26_AB_removeLast_A AB_removeLast_A = new ListItrTest_26_AB_removeLast_A();
		printDescription(AB_removeLast_A.getDescription());
		AB_removeLast_A.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_27_AB_removeA_B AB_removeA_B = new ListItrTest_27_AB_removeA_B();
		printDescription(AB_removeA_B.getDescription());
		AB_removeA_B.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_28_AB_removeB_A AB_removeB_A = new ListItrTest_28_AB_removeB_A();
		printDescription(AB_removeB_A.getDescription());
		AB_removeB_A.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_29_AB_remove0_B AB_remove0_B = new ListItrTest_29_AB_remove0_B();
		printDescription(AB_remove0_B.getDescription());
		AB_remove0_B.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_30_AB_remove1_A AB_remove1_A = new ListItrTest_30_AB_remove1_A();
		printDescription(AB_remove1_A.getDescription());
		AB_remove1_A.run(LIST_TYPE); 
		printLine(); 
	
		printIntermediateResults("Test classes 21 - 30"); 		
		
	    //  Pause tests
	    System.out.print("To run tests for test classes 31- 40, enter any character: ");
	    scanner.next();
		
		ListItrTest_31_AB_set0C_CB AB_set0C_CB = new ListItrTest_31_AB_set0C_CB();
		printDescription(AB_set0C_CB.getDescription());
		AB_set0C_CB.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_32_AB_set1C_AC AB_set1C_AC = new ListItrTest_32_AB_set1C_AC();
		printDescription(AB_set1C_AC.getDescription());
		AB_set1C_AC.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_33_ABC_removeFirst_BC ABC_removeFirst_BC = new ListItrTest_33_ABC_removeFirst_BC();
		printDescription(ABC_removeFirst_BC.getDescription());
		ABC_removeFirst_BC.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_34_ABC_removeLast_AB ABC_removeLast_AB = new ListItrTest_34_ABC_removeLast_AB();
		printDescription(ABC_removeLast_AB.getDescription());
		ABC_removeLast_AB.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_35_ABC_removeA_BC ABC_removeA_BC = new ListItrTest_35_ABC_removeA_BC();
		printDescription(ABC_removeA_BC.getDescription());
		ABC_removeA_BC.run(LIST_TYPE); 
		printLine(); 
					
		ListItrTest_36_ABC_removeB_AC ABC_removeB_AC = new ListItrTest_36_ABC_removeB_AC();
		printDescription(ABC_removeB_AC.getDescription());
		ABC_removeB_AC.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_37_ABC_removeC_AB ABC_removeC_AB = new ListItrTest_37_ABC_removeC_AB();
		printDescription(ABC_removeC_AB.getDescription());
		ABC_removeC_AB.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_38_ABC_remove0_BC ABC_remove0_BC = new ListItrTest_38_ABC_remove0_BC();
		printDescription(ABC_remove0_BC.getDescription());
		ABC_remove0_BC.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_39_ABC_remove1_AC ABC_remove1_AC = new ListItrTest_39_ABC_remove1_AC();
		printDescription(ABC_remove1_AC.getDescription());
		ABC_remove1_AC.run(LIST_TYPE); 
		printLine(); 
				
		ListItrTest_40_ABC_remove2_AB ABC_remove2_AB = new ListItrTest_40_ABC_remove2_AB();
		printDescription(ABC_remove2_AB.getDescription());
		ABC_remove2_AB.run(LIST_TYPE); 
		printLine(); 
	
		printIntermediateResults("Test classes 31 - 40"); 
		
	    //  Pause tests
	    System.out.print("To run tests for test classes 41 - 43, enter any character: ");
	    scanner.next();
		
		ListItrTest_41_ABC_set0D_DBC ABC_set0D_DBC = new ListItrTest_41_ABC_set0D_DBC();
		printDescription(ABC_set0D_DBC.getDescription());
		ABC_set0D_DBC.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_42_ABC_set1D_ADC ABC_set1D_ADC = new ListItrTest_42_ABC_set1D_ADC();
		printDescription(ABC_set1D_ADC.getDescription());
		ABC_set1D_ADC.run(LIST_TYPE); 
		printLine(); 
			
		ListItrTest_43_ABC_set2D_ABD ABC_set2D_ABD = new ListItrTest_43_ABC_set2D_ABD();
		printDescription(ABC_set2D_ABD.getDescription());
		ABC_set2D_ABD.run(LIST_TYPE); 
		printLine(); 
		
		// close scanner
		scanner.close(); 
	}
	
	private static void printIntermediateResults(String testDescription)
	{
		System.out.printf("\nResults for %s tests: Passed: %d,  " + "Failed: %d\n", testDescription, passes, failures);

		// reset number of passes / failures 
		passes = 0; 
		failures = 0; 
		System.out.println(); 
	}

	/**
	 * Print test results in a consistent format
	 * 
	 * @param testDesc - description of the test
	 * @param result - indicates whether the test passed or failed
	 */	
	public static void printResults(String testDesc, boolean result)
	{
		overallTotal++;
		if (result) 
		{
			passes++;
			totalPasses++;
		} 
		else 
		{
			failures++; 
			totalFailures++;
		}
		System.out.printf("%-46s\t%s\n", testDesc, (result ? "   PASS" : "***FAIL***"));
	}

	/** 
	 * Print a final summary 
	 */
	private static void printFinalSummary()
	{
		System.out.printf("\nTotal Tests Run: %d,  Passed: %d,  "
				           + "Failed: %d\n", overallTotal, totalPasses, totalFailures);
	}
	
	/**
	 * Prints description of tests 
	 * @param description - description of tests 
	 */
	private static void printDescription(String description)
	{
		System.out.println(description);		
	}

	/** 
	 * Prints line between tests
	 */
	private static void printLine()
	{
		System.out.println("=======================================================");
		
	}

}
