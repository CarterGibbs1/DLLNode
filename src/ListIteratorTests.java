import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A unit test class for implementations of 
 * the ListIterator interface.
 *   
 * @author Matt T
 */

public class ListIteratorTests 
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

	//****** Sets state of ListIterator for testing  ************************************
	/**
	 * Sets up ListIterator for tests. 
	 * 
	 * @param itrState - ListItrState of ListIterator when run tests 
	 */
	public static ListIterator<Character> initItr(IndexedUnsortedList<Character> list, ListItrState listItrState)
	{
		ListIterator <Character> listItr = list.listIterator();
		// choose state of listIterator to run tests on 
		switch (listItrState) 
		{	
		 
	        case init:  
	        		break;			// just need to initialize listIterator 
	        case add:  
	        		listItr.add(E);
	        		break;
	        case nextAdd:  
	        		listItr.next();
	        		listItr.add(E);
	        		break;
	        case nextPrev:
	        		listItr.next();
	        		listItr.previous();
	        		break;
	        case nextPrevAdd:  
	        		listItr.next();
	        		listItr.previous();
	        		listItr.add(E);
	        		break;
	        case nextPrevRemove:
		        	listItr.next();
		        	listItr.previous();
		        	listItr.remove();
					break;		
	        case nextNextPrev:  
	        		listItr.next();
	        		listItr.next();
	        		listItr.previous();
	        		break;
	        case nextNextAdd:
	        		listItr.next();
	        		listItr.next();
	        		listItr.add(E);
	        		break;
	        case nextNextPrevAdd:  
	        		listItr.next();
	        		listItr.next();
	        		listItr.previous();
	        		listItr.add(E);
	        		break;	   
	        case nextNextPrevRemove:  
	        		listItr.next();
	        		listItr.next();
	        		listItr.previous();
	        		listItr.remove();
	        		break;
	        case nextNextNextPrev:
	        		listItr.next();
		        	listItr.next();
		        	listItr.next();		
		        	listItr.previous();		
		        	break;
	        case nextNextNextAdd:
        		listItr.next();
	        	listItr.next();
	        	listItr.next();		
	        	listItr.add(E);		
	        	break;
	        case nextNextNextPrevAdd:
		        	listItr.next();
		        	listItr.next();
		        	listItr.next();
		        	listItr.previous();
					listItr.add(E);
					break;
	        case nextNextNextPrevRemove:
		        	listItr.next();
		        	listItr.next();
		        	listItr.next();
		        	listItr.previous();
		        	listItr.remove();
					break;
	        default:
					throw new IllegalStateException("Invalid List Iterator State");
		}
		return listItr; 
	}

	//****** Tests for ListIterator methods ************************************

	/**
	 * Tests hasNext method
	 * 
	 * @param listItr - ListIterator for implementation of IndexedUnsortedList ADT
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean hasNext(ListIterator<Character> listItr, Result expectedResult)
	{
		Result result;
		try 
		{
			if (listItr.hasNext()) 
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
	 * @param ListItr - ListIterator for implementation of IndexedUnsortedList interface
	 * @param element - Character object
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean next(ListIterator<Character> listItr, Character element, Result expectedResult)
	{
		Result result;
		try
		{
			Character retVal = listItr.next();
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
	 * @param listItr - ListIterator over list implementation of IndexedUnsortedList interface
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean remove(ListIterator<Character> listItr, Result expectedResult)
	{
		Result result;
		try 
		{
			listItr.remove();
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

	/**
	 * Tests hasPrevious method
	 * 
	 * @param listItr - ListIterator for implementation of IndexedUnsortedList ADT
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean hasPrevious(ListIterator<Character> listItr, Result expectedResult)
	{
		Result result;
		try 
		{
			if (listItr.hasPrevious()) 
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
			System.out.printf("%s caught unexpected %s\n", "hasPrevious", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}

		/**
	 * Tests previous method
	 * 
	 * @param ListItr - ListIterator for implementation of IndexedUnsortedList interface
	 * @param element - Character object
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean previous(ListIterator<Character> listItr, Character element, Result expectedResult)
	{
		Result result;
		try
		{
			Character retVal = listItr.previous();
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
			System.out.printf("%s caught unexpected %s\n", "previous", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}
	
	/**
	 * Tests set method
	 * 
	 * @param listItr - ListIterator over list implementation of IndexedUnsortedList interface
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean set(ListIterator<Character> listItr, Result expectedResult)
	{
		Result result;
		try 
		{
			listItr.set(E);
			result = Result.NoException;
		} 
		catch (IllegalStateException e) 
		{
			result = Result.IllegalState;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "set", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}

	/**
	 * Tests nextIndex method
	 * 
	 * @param ListItr - ListIterator for implementation of IndexedUnsortedList interface
	 * @param nextIndex - int value of position
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean nextIndex(ListIterator<Character> listItr, int nextIndex, Result expectedResult)
	{
		Result result;
		try
		{
			int retVal = listItr.nextIndex();
			if (retVal == nextIndex) 
			{
				result = Result.MatchingValue;
			} 
			else 
			{
				result = Result.Fail;
			}
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "nextIndex", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}

	/**
	 * Tests previousIndex method
	 * 
	 * @param ListItr - ListIterator for implementation of IndexedUnsortedList interface
	 * @param prevIndex - int value of position
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean previousIndex(ListIterator<Character> listItr, int prevIndex, Result expectedResult)
	{
		Result result;
		try
		{
			int retVal = listItr.previousIndex();
			if (retVal == prevIndex) 
			{
				result = Result.MatchingValue;
			} 
			else 
			{
				result = Result.Fail;
			}
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "previousIndex", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}
	
	/**
	 * Tests add method
	 * 
	 * @param listItr - ListIterator over list implementation of IndexedUnsortedList interface
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean add(ListIterator<Character> listItr, Result expectedResult)
	{
		Result result;
		try 
		{
			listItr.add(E);
			result = Result.NoException;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "add", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}	

}
