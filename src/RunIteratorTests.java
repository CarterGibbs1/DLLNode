/**
 * Runs a set of black box tests for lists that 
 * implement Iterator interface. 
 * 
 * @author CS221
 */
public class RunIteratorTests
{
	// TODO: make sure using correct list when running tests 
	
	// Which list to use in tests:
	// { arrayList, singleLinkedList, doubleLinkedList }
	private final static ListType LIST_TYPE = ListType.doubleLinkedList;

	// total test count
	private static int totalTests = 0; 

	// instance variables for tracking test results
	private static int passes = 0;
	private static int failures = 0;
	private static int total = 0;

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
		// Iterator tests for given change scenarios
		ItrTest_1_constructor_emptyList constructor_emptyList = new ItrTest_1_constructor_emptyList();
		printDescription(constructor_emptyList.getDescription());
		constructor_emptyList.run(LIST_TYPE); 
		totalTests += constructor_emptyList.getNumTests(); 
		printLine(); 
			
		ItrTest_2_emptyList_addToFrontA_A emptyList_addToFrontA_A = new ItrTest_2_emptyList_addToFrontA_A();
		printDescription(emptyList_addToFrontA_A.getDescription());
		emptyList_addToFrontA_A.run(LIST_TYPE); 
		totalTests += emptyList_addToFrontA_A.getNumTests(); 
		printLine(); 
			
		ItrTest_3_emptyList_addToRearA_A emptyList_addToRearA_A = new ItrTest_3_emptyList_addToRearA_A();
		printDescription(emptyList_addToRearA_A.getDescription());
		emptyList_addToRearA_A.run(LIST_TYPE); 
		totalTests += emptyList_addToRearA_A.getNumTests(); 
		printLine(); 
			
		ItrTest_4_emptyList_addA_A emptyList_addA_A = new ItrTest_4_emptyList_addA_A();
		printDescription(emptyList_addA_A.getDescription());
		emptyList_addA_A.run(LIST_TYPE); 
		totalTests += emptyList_addA_A.getNumTests(); 
		printLine(); 
			
		ItrTest_5_emptyList_add0A_A emptyList_add0A_A = new ItrTest_5_emptyList_add0A_A();
		printDescription(emptyList_add0A_A.getDescription());
		emptyList_add0A_A.run(LIST_TYPE); 
		totalTests += emptyList_add0A_A.getNumTests(); 
		printLine(); 
			
		ItrTest_6_A_addToFrontB_BA A_addToFrontB_BA = new ItrTest_6_A_addToFrontB_BA();
		printDescription(A_addToFrontB_BA.getDescription());
		A_addToFrontB_BA.run(LIST_TYPE); 
		totalTests += A_addToFrontB_BA.getNumTests(); 
		printLine(); 
		
		ItrTest_7_A_addToRearB_AB A_addToRearB_AB = new ItrTest_7_A_addToRearB_AB();
		printDescription(A_addToRearB_AB.getDescription());
		A_addToRearB_AB.run(LIST_TYPE); 
		totalTests += A_addToRearB_AB.getNumTests(); 
		printLine(); 
			
		ItrTest_8_A_addAfterBA_AB A_addAfterBA_AB = new ItrTest_8_A_addAfterBA_AB();
		printDescription(A_addAfterBA_AB.getDescription());
		A_addAfterBA_AB.run(LIST_TYPE); 
		totalTests += A_addAfterBA_AB.getNumTests(); 
		printLine(); 
			
		ItrTest_9_A_addB_AB A_addB_AB = new ItrTest_9_A_addB_AB();
		printDescription(A_addB_AB.getDescription());
		A_addB_AB.run(LIST_TYPE); 
		totalTests += A_addB_AB.getNumTests(); 
		printLine(); 

		ItrTest_10__A_add0B_BA A_add0B_BA = new ItrTest_10__A_add0B_BA();
		printDescription(A_add0B_BA.getDescription());
		A_add0B_BA.run(LIST_TYPE); 
		totalTests += A_add0B_BA.getNumTests(); 
		printLine(); 
						
		ItrTest_11_A_add1B_AB A_add1B_AB = new ItrTest_11_A_add1B_AB();
		printDescription(A_add1B_AB.getDescription());
		A_add1B_AB.run(LIST_TYPE); 
		totalTests += A_add1B_AB.getNumTests(); 
		printLine(); 
			
		ItrTest_12_A_removeFirst_emptyList A_removeFirst_emptyList = new ItrTest_12_A_removeFirst_emptyList();
		printDescription(A_removeFirst_emptyList.getDescription());
		A_removeFirst_emptyList.run(LIST_TYPE); 
		totalTests += A_removeFirst_emptyList.getNumTests(); 
		printLine(); 
			
		ItrTest_13_A_removeLast_emptyList A_removeLast_emptyList = new ItrTest_13_A_removeLast_emptyList();
		printDescription(A_removeLast_emptyList.getDescription());
		A_removeLast_emptyList.run(LIST_TYPE); 
		totalTests += A_removeLast_emptyList.getNumTests(); 
		printLine(); 
			
		ItrTest_14_A_removeA_emptyList A_removeA_emptyList = new ItrTest_14_A_removeA_emptyList();
		printDescription(A_removeA_emptyList.getDescription());
		A_removeA_emptyList.run(LIST_TYPE); 
		totalTests += A_removeA_emptyList.getNumTests(); 
		printLine(); 
			
		ItrTest_15_A_remove0_emptyList A_remove0_emptyList = new ItrTest_15_A_remove0_emptyList();
		printDescription(A_remove0_emptyList.getDescription());
		A_remove0_emptyList.run(LIST_TYPE); 
		totalTests += A_remove0_emptyList.getNumTests(); 
		printLine(); 
			
		ItrTest_16_A_set0B_B A_set0B_B = new ItrTest_16_A_set0B_B();
		printDescription(A_set0B_B.getDescription());
		A_set0B_B.run(LIST_TYPE); 
		totalTests += A_set0B_B.getNumTests(); 
		printLine(); 
	
		ItrTest_17_AB_addToFrontC_CAB AB_addToFrontC_CAB = new ItrTest_17_AB_addToFrontC_CAB();
		printDescription(AB_addToFrontC_CAB.getDescription());
		AB_addToFrontC_CAB.run(LIST_TYPE); 
		totalTests += AB_addToFrontC_CAB.getNumTests(); 
		printLine(); 
			
		ItrTest_18_AB_addToRearC_ABC AB_addToRearC_ABC = new ItrTest_18_AB_addToRearC_ABC();
		printDescription(AB_addToRearC_ABC.getDescription());
		AB_addToRearC_ABC.run(LIST_TYPE); 
		totalTests += AB_addToRearC_ABC.getNumTests(); 
		printLine(); 
			
		ItrTest_19_AB_addAfterCA_ACB AB_addAfterCA_ACB = new ItrTest_19_AB_addAfterCA_ACB();
		printDescription(AB_addAfterCA_ACB.getDescription());
		AB_addAfterCA_ACB.run(LIST_TYPE); 
		totalTests += AB_addAfterCA_ACB.getNumTests(); 
		printLine(); 
			
		ItrTest_20_AB_addAfterCB_ABC AB_addAfterCB_ABC = new ItrTest_20_AB_addAfterCB_ABC();
		printDescription(AB_addAfterCB_ABC.getDescription());
		AB_addAfterCB_ABC.run(LIST_TYPE); 
		totalTests += AB_addAfterCB_ABC.getNumTests(); 
		printLine(); 
			
		ItrTest_21_AB_addC_ABC AB_addC_ABC = new ItrTest_21_AB_addC_ABC();
		printDescription(AB_addC_ABC.getDescription());
		AB_addC_ABC.run(LIST_TYPE); 
		totalTests += AB_addC_ABC.getNumTests(); 
		printLine(); 
			
		ItrTest_22_AB_add0C_CAB AB_add0C_CAB = new ItrTest_22_AB_add0C_CAB();
		printDescription(AB_add0C_CAB.getDescription());
		AB_add0C_CAB.run(LIST_TYPE); 
		totalTests += AB_add0C_CAB.getNumTests(); 
		printLine(); 
			
		ItrTest_23_AB_add1C_ACB AB_add1C_ACB = new ItrTest_23_AB_add1C_ACB();
		printDescription(AB_add1C_ACB.getDescription());
		AB_add1C_ACB.run(LIST_TYPE); 
		totalTests += AB_add1C_ACB.getNumTests(); 
		printLine(); 
			
		ItrTest_24_AB_add2C_ABC AB_add2C_ABC = new ItrTest_24_AB_add2C_ABC();
		printDescription(AB_add2C_ABC.getDescription());
		AB_add2C_ABC.run(LIST_TYPE); 
		totalTests += AB_add2C_ABC.getNumTests(); 
		printLine(); 
			
		ItrTest_25_AB_removeFirst_B AB_removeFirst_B = new ItrTest_25_AB_removeFirst_B();
		printDescription(AB_removeFirst_B.getDescription());
		AB_removeFirst_B.run(LIST_TYPE); 
		totalTests += AB_removeFirst_B.getNumTests(); 
		printLine(); 
			
		ItrTest_26_AB_removeLast_A AB_removeLast_A = new ItrTest_26_AB_removeLast_A();
		printDescription(AB_removeLast_A.getDescription());
		AB_removeLast_A.run(LIST_TYPE); 
		totalTests += AB_removeLast_A.getNumTests(); 
		printLine(); 
			
		ItrTest_27_AB_removeA_B AB_removeA_B = new ItrTest_27_AB_removeA_B();
		printDescription(AB_removeA_B.getDescription());
		AB_removeA_B.run(LIST_TYPE); 
		totalTests += AB_removeA_B.getNumTests(); 
		printLine(); 
			
		ItrTest_28_AB_removeB_A AB_removeB_A = new ItrTest_28_AB_removeB_A();
		printDescription(AB_removeB_A.getDescription());
		AB_removeB_A.run(LIST_TYPE); 
		totalTests += AB_removeB_A.getNumTests(); 
		printLine(); 
			
		ItrTest_29_AB_remove0_B AB_remove0_B = new ItrTest_29_AB_remove0_B();
		printDescription(AB_remove0_B.getDescription());
		AB_remove0_B.run(LIST_TYPE); 
		totalTests += AB_remove0_B.getNumTests(); 
		printLine(); 
			
		ItrTest_30_AB_remove1_A AB_remove1_A = new ItrTest_30_AB_remove1_A();
		printDescription(AB_remove1_A.getDescription());
		AB_remove1_A.run(LIST_TYPE); 
		totalTests += AB_remove1_A.getNumTests(); 
		printLine(); 
			
		ItrTest_31_AB_set0C_CB AB_set0C_CB = new ItrTest_31_AB_set0C_CB();
		printDescription(AB_set0C_CB.getDescription());
		AB_set0C_CB.run(LIST_TYPE); 
		totalTests += AB_set0C_CB.getNumTests(); 
		printLine(); 
			
		ItrTest_32_AB_set1C_AC AB_set1C_AC = new ItrTest_32_AB_set1C_AC();
		printDescription(AB_set1C_AC.getDescription());
		AB_set1C_AC.run(LIST_TYPE); 
		totalTests += AB_set1C_AC.getNumTests(); 
		printLine(); 
			
		ItrTest_33_ABC_removeFirst_BC ABC_removeFirst_BC = new ItrTest_33_ABC_removeFirst_BC();
		printDescription(ABC_removeFirst_BC.getDescription());
		ABC_removeFirst_BC.run(LIST_TYPE); 
		totalTests += ABC_removeFirst_BC.getNumTests(); 
		printLine(); 
			
		ItrTest_34_ABC_removeLast_AB ABC_removeLast_AB = new ItrTest_34_ABC_removeLast_AB();
		printDescription(ABC_removeLast_AB.getDescription());
		ABC_removeLast_AB.run(LIST_TYPE); 
		totalTests += ABC_removeLast_AB.getNumTests(); 
		printLine(); 
			
		ItrTest_35_ABC_removeA_BC ABC_removeA_BC = new ItrTest_35_ABC_removeA_BC();
		printDescription(ABC_removeA_BC.getDescription());
		ABC_removeA_BC.run(LIST_TYPE); 
		totalTests += ABC_removeA_BC.getNumTests(); 
		printLine(); 
			
		ItrTest_36_ABC_removeB_AC ABC_removeB_AC = new ItrTest_36_ABC_removeB_AC();
		printDescription(ABC_removeB_AC.getDescription());
		ABC_removeB_AC.run(LIST_TYPE); 
		totalTests += ABC_removeB_AC.getNumTests(); 
		printLine(); 
			
		ItrTest_37_ABC_removeC_AB ABC_removeC_AB = new ItrTest_37_ABC_removeC_AB();
		printDescription(ABC_removeC_AB.getDescription());
		ABC_removeC_AB.run(LIST_TYPE); 
		totalTests += ABC_removeC_AB.getNumTests(); 
		printLine(); 
			
		ItrTest_38_ABC_remove0_BC ABC_remove0_BC = new ItrTest_38_ABC_remove0_BC();
		printDescription(ABC_remove0_BC.getDescription());
		ABC_remove0_BC.run(LIST_TYPE); 
		totalTests += ABC_remove0_BC.getNumTests(); 
		printLine(); 
			
		ItrTest_39_ABC_remove1_AC ABC_remove1_AC = new ItrTest_39_ABC_remove1_AC();
		printDescription(ABC_remove1_AC.getDescription());
		ABC_remove1_AC.run(LIST_TYPE); 
		totalTests += ABC_remove1_AC.getNumTests(); 
		printLine(); 
				
		ItrTest_40_ABC_remove2_AB ABC_remove2_AB = new ItrTest_40_ABC_remove2_AB();
		printDescription(ABC_remove2_AB.getDescription());
		ABC_remove2_AB.run(LIST_TYPE); 
		totalTests += ABC_remove2_AB.getNumTests(); 
		printLine(); 
			
		ItrTest_41_ABC_set0D_DBC ABC_set0D_DBC = new ItrTest_41_ABC_set0D_DBC();
		printDescription(ABC_set0D_DBC.getDescription());
		ABC_set0D_DBC.run(LIST_TYPE); 
		totalTests += ABC_set0D_DBC.getNumTests(); 
		printLine(); 
			
		ItrTest_42_ABC_set1D_ADC ABC_set1D_ADC = new ItrTest_42_ABC_set1D_ADC();
		printDescription(ABC_set1D_ADC.getDescription());
		ABC_set1D_ADC.run(LIST_TYPE); 
		totalTests += ABC_set1D_ADC.getNumTests(); 
		printLine(); 
			
		ItrTest_43_ABC_set2D_ABD ABC_set2D_ABD = new ItrTest_43_ABC_set2D_ABD();
		printDescription(ABC_set2D_ABD.getDescription());
		ABC_set2D_ABD.run(LIST_TYPE); 
		totalTests += ABC_set2D_ABD.getNumTests(); 
		printLine(); 
			
	}
	
	/**
	 * Print test results in a consistent format
	 * 
	 * @param testDesc - description of the test
	 * @param result - indicates whether the test passed or failed
	 */	
	public static void printResults(String testDesc, boolean result)
	{
		total++;
		if (result) 
		{
			passes++;
		} 
		else 
		{
			failures++;
		}
		System.out.printf("%-46s\t%s\n", testDesc, (result ? "   PASS" : "***FAIL***"));
	}

	/** 
	 * Print a final summary 
	 */
	private static void printFinalSummary()
	{
		System.out.printf("\nTotal Tests Run: %d of %d,  Passed: %d,  "
				           + "Failed: %d\n", total, totalTests, passes, failures);
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
