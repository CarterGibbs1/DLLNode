import java.util.Iterator;

/**
 * Testing for IndexedUnsortedList ADT implementation: 
 * Iterator Tests for Change Scenario 5: empty list -> add(0, A) -> [A]
 *
 * @author Matt T
 *
 */
public class ItrTest_5_emptyList_add0A_A
{
	// List running tests on
	IndexedUnsortedList<Character> list;
	// Iterator list to run tests 
	private Iterator<Character> itr; 
		
	// Name of class
	private static String CLASS_NAME = "ListItrTest_5_emptyList_add0A_A"; 
	// Description of change scenario testing 
	private static final String testDescription = 
			"Change Scenario 5: empty list -> add(0, A) -> [A]"; 
	// Number of tests run 
	private static final int NUM_TESTS = 9; 
	// Type of list using in tests
	private ListType listType; 
	// State of iterator 
	private ItrState itrState; 

	// First element in list
	private static final Character FIRST = IteratorTests.A;
	
	// Element not in list - used for negative testing 
	private static final Character INVALID_ELEMENT = IteratorTests.F;
	
	/**
	 * Sets up iterator for testing. 
	 */
	public void initialize()
	{
		// create an empty list 
		list = IteratorTests.newList(listType);
		// apply change
		list.add(0, IteratorTests.A); 
		// initialize iterator to given state
		itr = IteratorTests.initItr(list, itrState);
	}
		
	/** 
	 * Run tests for this change scenario 
	 */
	public void run(ListType listType)
	{
		// set type of list running tests on 
		this.listType = listType; 

		// result of running tests 
		boolean result; 
		
		try 
		{
			//********* Iterator State: initial position 
			System.out.println("Iterator State: initial position");
			// initial iterator state
			itrState = ItrState.init;

			// hasNext Test
			initialize(); 
			result = IteratorTests.hasNext(itr, Result.True); 
			RunIteratorTests.printResults("hasNext()", result);		
			// next Test
			initialize(); 
			result = IteratorTests.next(itr, FIRST, Result.MatchingValue); 
			RunIteratorTests.printResults("next()", result);
			// remove Test
			initialize(); 
			result = IteratorTests.remove(itr, Result.IllegalState); 
			RunIteratorTests.printResults("remove()", result);
			
			//********* Iterator State: next 
			System.out.println("Iterator State: next");
			// initial iterator state
			itrState = ItrState.next;

			// hasNext Test
			initialize(); 
			result = IteratorTests.hasNext(itr, Result.False); 
			RunIteratorTests.printResults("hasNext()", result);		
			// next Test
			initialize(); 
			result = IteratorTests.next(itr, INVALID_ELEMENT, Result.NoSuchElement); 
			RunIteratorTests.printResults("next()", result);
			// remove Test
			initialize(); 
			result = IteratorTests.remove(itr, Result.NoException); 
			RunIteratorTests.printResults("remove()", result);

			//********* Iterator State: next, remove 
			System.out.println("Iterator State: next, remove");
			// initial iterator state
			itrState = ItrState.nextRemove; 

			// hasNext Test
			initialize(); 
			result = IteratorTests.hasNext(itr, Result.False); 
			RunIteratorTests.printResults("hasNext()", result);		
			// next Test
			initialize(); 
			result = IteratorTests.next(itr, INVALID_ELEMENT, Result.NoSuchElement); 
			RunIteratorTests.printResults("next()", result);
			// remove Test
			initialize(); 
			result = IteratorTests.remove(itr, Result.IllegalState); 
			RunIteratorTests.printResults("remove()", result);
				
		} 
		catch (Exception e) 
		{
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", CLASS_NAME);
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns test description 
	 * @return testDescription - description of test
	 */
	public String getDescription()
	{
		return testDescription;
	}
	
	/**
	 * Returns number of tests in this test class 
	 * @return - int representing number of tests 
	 */
	public int getNumTests()
	{
		return NUM_TESTS; 
	}


}
