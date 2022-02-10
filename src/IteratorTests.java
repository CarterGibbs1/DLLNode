import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A unit test class for implementations of 
 * the Iterator interface.
 *   
 * @author Matt T
 */
public class IteratorTests
{
	// Elements that can be in the list
	public static final Character A = Character.valueOf('A');
	public static final Character B = Character.valueOf('B');
	public static final Character C = Character.valueOf('C');
	public static final Character D = Character.valueOf('D');
	public static final Character E = Character.valueOf('E');
	public static final Character F = Character.valueOf('F');
	public static final Character G = Character.valueOf('G');
	
	/**
	 * Constructs new list for testing. 
	 * 
	 * @param listType - ListType of possible lists 
	 * @return new list of the given type 
	 */
	public static IndexedUnsortedList<Character> newList(ListType listType)
	{
		IndexedUnsortedList<Character> newList = null;
	
		if(listType.equals(ListType.arrayList))
		{
//			newList = new IUArrayList<Character>(); 
		}
		else if(listType.equals(ListType.singleLinkedList))		
		{
//		    newList = new IUSingleLinkedList<Character>(); 
		}
		else if(listType.equals(ListType.doubleLinkedList))
		{
		    newList = new IUDoubleLinkedList<Character>(); 
		}
	
		return newList; 
	}

	//****** Sets state of Iterator for testing  ************************************
	/**
	 * Sets up Iterator for tests. 
	 * 
	 * @param itrState - ItrState of Iterator when run tests 
	 */
	public static Iterator<Character> initItr(IndexedUnsortedList<Character> list, ItrState itrState)
	{
		Iterator <Character> itr = list.iterator();
		// choose state of iterator to run tests on 
		switch (itrState) 
		{	
	        case init:  
	        		break;			// just need to initialize iterator 
	        case next:  
	        		itr.next();
	        		break;
	        case nextNext:  
	        		itr.next();
	        		itr.next();
	        		break;
	        case nextRemove:
	        		itr.next();
	        		itr.remove();
	        		break;
	        case nextNextRemove:  
        			itr.next();
        			itr.next();
        			itr.remove();
	        		break;	        
	        case nextRemoveNext:  
	        		itr.next();
	        		itr.remove();
	        		itr.next();
	        		break;
	        case nextNextNext:
					itr.next();
					itr.next();
					itr.next();
					break;
	        case nextNextNextRemove:
					itr.next();
					itr.next();
					itr.next();
					itr.remove();
					break;
	        case nextNextRemoveNext:
					itr.next();
					itr.next();
					itr.remove();
					itr.next();
					break;
	        default:
					throw new IllegalStateException("Invalid Iterator State");
		}
		return itr; 
	}

	//****** Tests for Iterator methods ************************************

	/**
	 * Tests hasNext method
	 * 
	 * @param itr - Iterator for implementation of IndexedUnsortedList ADT
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean hasNext(Iterator<Character> itr, Result expectedResult)
	{
		Result result;
		try 
		{
			if (itr.hasNext()) 
			{
				result = Result.True;
			} 
			else 
			{
				result = Result.False;
			}
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "hasNext", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}

		/**
	 * Tests next method
	 * 
	 * @param itr - Iterator for implementation of IndexedUnsortedList interface
	 * @param element - Character object
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean next(Iterator<Character> itr, Character element, Result expectedResult)
	{
		Result result;
		try
		{
			Character retVal = itr.next();
			if (retVal.equals(element)) 
			{
				result = Result.MatchingValue;
			} 
			else 
			{
				result = Result.Fail;
			}
		} 
		catch (NoSuchElementException e) 
		{
			result = Result.NoSuchElement;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "next", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}
	
	/**
	 * Tests remove method
	 * 
	 * @param itr - Iterator over list implementation of IndexedUnsortedList interface
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean remove(Iterator<Character> itr, Result expectedResult)
	{
		Result result;
		try 
		{
			itr.remove();
			result = Result.NoException;
		} 
		catch (IllegalStateException e) 
		{
			result = Result.IllegalState;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "remove", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}

}