import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A unit test class for implementations of 
 * the IndexedUnsortedList ADT.  
 * @author Matt T
 */
public class IndexedUnsortedListTests
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
	
		if(listType.equals(ListType.goodList))
		{
//		    newList = new GoodList<Character>();
		}
		else if(listType.equals(ListType.arrayList))
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

	//****** Test cases for general List methods ************************************

	/**
	 * Tests removeFirst method
	 * @param list - implementation of IndexedUnsortedList ADT
	 * @param first - Character object
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean removeFirst(IndexedUnsortedList<Character> list, Character first, Result expectedResult)
	{
		Result result;
		try
		{
			Character retVal = list.removeFirst();
			if (retVal.equals(first)) 
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
			System.out.printf("%s caught unexpected %s\n", "removeFirst", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}
	
	/**
	 * Tests removeLast method
	 * @param list - implementation of IndexedUnsortedList ADT
	 * @param last - Character object
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean removeLast(IndexedUnsortedList<Character> list, Character last, Result expectedResult)
	{
		Result result;
		try
		{
			Character retVal = list.removeLast();
			if (retVal.equals(last)) 
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
			System.out.printf("%s caught unexpected %s\n", "removeLast", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}
	
	/**
	 * Tests remove(element) method
	 * @param list - implementation of IndexedUnsortedList ADT
	 * @param element - Character object
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean remove(IndexedUnsortedList<Character> list, Character element, Result expectedResult)
	{
		Result result;
		try
		{
			Character retVal = list.remove(element);
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
			System.out.printf("%s caught unexpected %s\n", "remove(element)", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}
	
	/**
	 * Tests first method
	 * @param list - implementation of IndexedUnsortedList ADT
	 * @param first - Character object
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean first(IndexedUnsortedList<Character> list, Character first, Result expectedResult)
	{
		Result result;
		try
		{
			Character retVal = list.first();
			if (retVal.equals(first)) 
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
			System.out.printf("%s caught unexpected %s\n", "first", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}
	
	/**
	 * Tests last method
	 * @param list - implementation of IndexedUnsortedList ADT
	 * @param first - Character object
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean last(IndexedUnsortedList<Character> list, Character last, Result expectedResult)
	{
		Result result;
		try
		{
			Character retVal = list.last();
			if (retVal.equals(last)) 
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
			System.out.printf("%s caught unexpected %s\n", "last", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}
	
	/**
	 * Tests contains method
	 * @param list - implementation of IndexedUnsortedList ADT
	 * @param element - Character object
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean contains(IndexedUnsortedList<Character> list, Character element, Result expectedResult)
	{
		Result result;
		try 
		{
			if (list.contains(element)) 
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
			System.out.printf("%s caught unexpected %s\n", "contains", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}
	
	/**
	 * Tests isEmpty method
	 * @param list - implementation of IndexedUnsortedList ADT
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean isEmpty(IndexedUnsortedList<Character> list, Result expectedResult)
	{
		Result result;
		try 
		{
			if (list.isEmpty()) 
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
			System.out.printf("%s caught unexpected %s\n", "isEmpty", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}
	
	/**
	 * Tests size method 
	 * @param list - implementation of IndexedUnsortedList ADT
	 * @param expectedSize - int representing number of elements 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean size(IndexedUnsortedList<Character> list, int expectedSize)
	{
		try 
		{
			return (list.size() == expectedSize);
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "size", e.toString());
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Tests toString method 
	 * Just checks that result is a String object.
	 * @param list - implementation of IndexedUnsortedList ADT
	 * @return - boolean whether pass test or not 
	 */
	public static boolean toString(IndexedUnsortedList<Character> list)
	{
		try 
		{
			String result = list.toString(); 
			return (String.class.isAssignableFrom(result.getClass()));
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "toString", e.toString());
			e.printStackTrace();
			return false;
		}
	}
			
	//****** Test methods for IndexedList methods ************************************
	
	/**
	 * Tests add(index) method
	 * @param list - implementation of IndexedUnsortedList ADT
	 * @param index - int position 
	 * @param element - Character object
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean add(IndexedUnsortedList<Character> list, int index, Character element, Result expectedResult)
	{
		Result result;
		try 
		{
			list.add(index, element);
			result = Result.NoException;
		} 
		catch (IndexOutOfBoundsException e) 
		{
			result = Result.IndexOutOfBounds;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "add(index)", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}
	
	/**
	 * Tests remove(index) method
	 * @param list - implementation of IndexedUnsortedList ADT
	 * @param index - int position 
	 * @param element - Character object
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean remove(IndexedUnsortedList<Character> list, int index, Character expectedElement, Result expectedResult)
	{
		Result result;
		try
		{
			Character retVal = list.remove(index);
			if (retVal.equals(expectedElement)) 
			{
				result = Result.MatchingValue;
			} 
			else 
			{
				result = Result.Fail;
			}
		} 
		catch (IndexOutOfBoundsException e) 
		{
			result = Result.IndexOutOfBounds;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "remove(index)", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}
	
	/**
	 * Tests set method
	 * @param list - implementation of IndexedUnsortedList ADT
	 * @param index - int position 
	 * @param element - Character object
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean set(IndexedUnsortedList<Character> list, int index, Character element, Result expectedResult)
	{
		Result result;
		try 
		{
			list.set(index, element);
			result = Result.NoException;
		} 
		catch (IndexOutOfBoundsException e) 
		{
			result = Result.IndexOutOfBounds;
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
	 * Tests add(element) method
	 * @param list - implementation of IndexedUnsortedList ADT
	 * @param element - Character object
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean add(IndexedUnsortedList<Character> list, Character element, Result expectedResult)
	{
		Result result;
		try 
		{
			list.add(element);
			result = Result.NoException;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "add(element)", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}

	/**
	 * Tests get method
	 * @param list - implementation of IndexedUnsortedList ADT
	 * @param index - int position 
	 * @param element - Character object
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean get(IndexedUnsortedList<Character> list, int index, Character expectedElement, Result expectedResult)
	{
		Result result;
		try
		{
			Character retVal = list.get(index);
			if (retVal.equals(expectedElement)) 
			{
				result = Result.MatchingValue;
			} 
			else 
			{
				result = Result.Fail;
			}
		} 
		catch (IndexOutOfBoundsException e) 
		{
			result = Result.IndexOutOfBounds;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "get", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}
	
	/**
	 * Tests indexOf method
	 * @param list - implementation of IndexedUnsortedList ADT
	 * @param element - Character object
	 * @param index - int position 
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean indexOf(IndexedUnsortedList<Character> list, Character element, int expectedIndex, Result expectedResult)
	{
		Result result;
		try
		{
			int retVal = list.indexOf(element);
			if (retVal == expectedIndex) 
			{
				result = Result.MatchingValue;
			} 
			else 
			{
				result = Result.Fail;
			}
		} 
		catch (IndexOutOfBoundsException e) 
		{
			result = Result.IndexOutOfBounds;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "indexOf", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}
	
	//****** Test cases for UnsortedList methods ************************************
	
	/**
	 * Tests addToFront method
	 * @param list - implementation of IndexedUnsortedList ADT
	 * @param element - Character object
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean addToFront(IndexedUnsortedList<Character> list, Character element, Result expectedResult)
	{
		Result result;
		try 
		{
			list.addToFront(element);
			result = Result.NoException;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "addToFront", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}
	
	/**
	 * Tests addToRear method
	 * @param list - implementation of IndexedUnsortedList ADT
	 * @param element - Character object
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean addToRear(IndexedUnsortedList<Character> list, Character element, Result expectedResult)
	{
		Result result;
		try 
		{
			list.addToRear(element);
			result = Result.NoException;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "addToRear", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}
	
	/**
	 * Tests addAfter method
	 * @param list - implementation of IndexedUnsortedList ADT
	 * @param addElement - Character object
	 * @param element - Character object
	 * @param expectedResult - Result of running test 
	 * @return - boolean whether pass test or not 
	 */
	public static boolean addAfter(IndexedUnsortedList<Character> list, Character addElement, Character element, Result expectedResult)
	{
		Result result;
		try 
		{
			list.addAfter(addElement, element);
			result = Result.NoException;
		} 
		catch (NoSuchElementException e) 
		{
			result = Result.NoSuchElement;
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "addAfter", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}
	
	/**
	 * Tests iterator method 
	 * Just checks that result is an Iterator object.
	 * @param list - implementation of IndexedUnsortedList ADT
	 * @return - boolean whether pass test or not 
	 */
	public static boolean iterator(IndexedUnsortedList<Character> list)
	{
		try 
		{
			return (Iterator.class.isAssignableFrom(list.iterator().getClass()));
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "iterator", e.toString());
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Tests listIterator method 
	 * Just checks that result is a ListIterator object.
	 * @param list - implementation of IndexedUnsortedList ADT
	 * @return - boolean whether pass test or not 
	 */
	public static boolean listIterator(IndexedUnsortedList<Character> list)
	{
		try 
		{
			return (ListIterator.class.isAssignableFrom(list.iterator().getClass()));
		} 
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "listIterator", e.toString());
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Tests listIterator(int) method 
	 * Just checks index and result is an ListIterator object.
	 * @param list - implementation of IndexedUnsortedList ADT
	 * @return - boolean whether pass test or not 
	 */
	public static boolean listIterator(IndexedUnsortedList<Character> list, int index, Result expectedResult)
	{
		Result result; 
		try 
		{
			ListIterator<Character> listItr = list.listIterator(index); 
			if(ListIterator.class.isAssignableFrom(listItr.getClass()))
			{
				result = Result.True; 
			}
			else
			{
				result = Result.False; 
			}
		} 
		catch(IndexOutOfBoundsException e)
		{
			result = Result.IndexOutOfBounds;
		}
		catch (Exception e) 
		{
			System.out.printf("%s caught unexpected %s\n", "listIterator(int)", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult; 
	}

}
