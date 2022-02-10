import java.util.ListIterator;

/**
 * Testing for IndexedUnsortedList interface implementation: 
 * ListIterator Tests for Change Scenario 14: [A] -> remove(A) -> [ ]
 *
 * @author Matt T
 *
 */

public class ListItrTest_14_A_removeA_emptyList
{
	// List running tests on
	IndexedUnsortedList<Character> list;
	// ListListIterator list to run tests 
	private ListIterator<Character> listItr; 
		
	//****** Constants used in tests *****************
	// Name of class
	private static String CLASS_NAME = "ListItrTest_14_A_removeA_emptyList"; 
	// Description of change scenario testing 
	private static final String testDescription = 
			"Change Scenario 14: [A] -> remove(A) -> [ ]"; 
	// Number of tests run 
	private static final int NUM_TESTS = 18;   
	// Type of list using in tests
	private ListType listType; 
	// State of ListListIterator 
	private ListItrState listItrState; 
	// Value of nextIndex
	private int nextIndex; 
	// Value of previousIndex
	private int previousIndex; 

	// Element added to list 
	private static final Character ADD_ELEMENT = ListIteratorTests.E; 
	// Element not in list - used for negative testing 
	private static final Character INVALID_ELEMENT = ListIteratorTests.F;
	
	/**
	 * Sets up ListListIterator for testing. 
	 */
	public void initialize()
	{
		// create an empty list 
		list = ListIteratorTests.newList(listType);
		// initialize list 
		list.add(ListIteratorTests.A);
		// apply change
		list.remove(ListIteratorTests.A);
		
		// initialize ListIterator to given state
		listItr = ListIteratorTests.initItr(list, listItrState);
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
			//********* ListIterator State: initial position 
			System.out.println("ListIterator State: initial position");
			// initial ListIterator state
			listItrState = ListItrState.init;
			// value of nextIndex / previousIndex
			nextIndex = 0;
			previousIndex = -1; 

			// hasNext Test
			initialize(); 
			result = ListIteratorTests.hasNext(listItr, Result.False); 
			RunListIteratorTests.printResults("hasNext()", result);		

			// next Test
			initialize(); 
			result = ListIteratorTests.next(listItr, INVALID_ELEMENT, Result.NoSuchElement); 
			RunListIteratorTests.printResults("next()", result);

			// remove Test
			initialize(); 
			result = ListIteratorTests.remove(listItr, Result.IllegalState); 
			RunListIteratorTests.printResults("remove()", result);
				
			// hasPrevious Test
			initialize(); 
			result = ListIteratorTests.hasPrevious(listItr, Result.False); 
			RunListIteratorTests.printResults("hasPrevious()", result);		

			// previous Test
			initialize(); 
			result = ListIteratorTests.previous(listItr, INVALID_ELEMENT, Result.NoSuchElement); 
			RunListIteratorTests.printResults("previous()", result);

			// set Test
			initialize(); 
			result = ListIteratorTests.set(listItr, Result.IllegalState); 
			RunListIteratorTests.printResults("set()", result);
				
			// nextIndex Test
			initialize(); 
			result = ListIteratorTests.nextIndex(listItr, nextIndex, Result.MatchingValue); 
			RunListIteratorTests.printResults("nextIndex()", result);

			// previousIndex Test
			initialize(); 
			result = ListIteratorTests.previousIndex(listItr, previousIndex, Result.MatchingValue); 
			RunListIteratorTests.printResults("previousIndex()", result);

			// add Test
			initialize(); 
			result = ListIteratorTests.add(listItr, Result.NoException); 
			RunListIteratorTests.printResults("add()", result);
	
			//********* ListIterator State: initial position, then add 
			System.out.println("ListIterator State: initial position, then add");
			// ListIterator state
			listItrState = ListItrState.add;
			// value of nextIndex / previousIndex
			nextIndex = 1;
			previousIndex = 0; 

			// hasNext Test
			initialize(); 
			result = ListIteratorTests.hasNext(listItr, Result.False); 
			RunListIteratorTests.printResults("hasNext()", result);		

			// next Test
			initialize(); 
			result = ListIteratorTests.next(listItr, INVALID_ELEMENT, Result.NoSuchElement); 
			RunListIteratorTests.printResults("next()", result);

			// remove Test
			initialize(); 
			result = ListIteratorTests.remove(listItr, Result.IllegalState); 
			RunListIteratorTests.printResults("remove()", result);
				
			// hasPrevious Test
			initialize(); 
			result = ListIteratorTests.hasPrevious(listItr, Result.True); 
			RunListIteratorTests.printResults("hasPrevious()", result);		

			// previous Test
			initialize(); 
			result = ListIteratorTests.previous(listItr, ADD_ELEMENT, Result.MatchingValue); 
			RunListIteratorTests.printResults("previous()", result);

			// set Test
			initialize(); 
			result = ListIteratorTests.set(listItr, Result.IllegalState); 
			RunListIteratorTests.printResults("set()", result);
				
			// nextIndex Test
			initialize(); 
			result = ListIteratorTests.nextIndex(listItr, nextIndex, Result.MatchingValue); 
			RunListIteratorTests.printResults("nextIndex()", result);

			// previousIndex Test
			initialize(); 
			result = ListIteratorTests.previousIndex(listItr, previousIndex, Result.MatchingValue); 
			RunListIteratorTests.printResults("previousIndex()", result);

			// add Test
			initialize(); 
			result = ListIteratorTests.add(listItr, Result.NoException); 
			RunListIteratorTests.printResults("add()", result);							

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
