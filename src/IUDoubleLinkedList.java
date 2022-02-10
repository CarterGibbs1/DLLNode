import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Double linked list implementation of the IndexedUnsortedList interface with generics
 * @author carter
 *
 * @param <T> - generic type
 */
public class IUDoubleLinkedList<T> implements IndexedUnsortedList<T> {

	private int count; // number of elements in list 
	private DLLNode<T> head, tail; // first/last nodes in list 
	private int modCount; // number of modifications made to list 

	/**
	 * default constructor - empty list
	 */
	public IUDoubleLinkedList() {
		count = 0;
		modCount = 0;
		head = null;
		tail = null;
	}
	
	@Override
	public void addToFront(T element) {
		DLLNode<T> newNode = new DLLNode<T>(element); 
		if (count != 0) {
			newNode.setNext(head);
			head.setPrevious(newNode);

		}
		head = newNode;
		if(count == 0) {
			tail = newNode; // only if empty 
		}
		count++;
		modCount++;
		
	}

	@Override
	public void addToRear(T element) {
		add(element);
	}

	@Override
	public void add(T element) {
		DLLNode<T> newNode = new DLLNode<T>(element); 
		if(count == 0)
		{
			head = newNode; // only if empty 
		}
		else
		{
			tail.setNext(newNode);  // can't run if empty 
			newNode.setPrevious(tail);
		}
		tail = newNode; 			
		count++; 
		modCount++; 
		
	}

	@Override
	public void addAfter(T element, T target) {
		int index = indexOf(target);
		if (index == -1) {
			throw new NoSuchElementException("Can't add, target not in list");
		}
		add(index + 1, element);
		
	}

	@Override
	public void add(int index, T element) {
		// check for valid index 
		if(index < 0 || index > count)
		{
			throw new IndexOutOfBoundsException("Can't insert, invalid index"); 
		}
		
		DLLNode<T> newNode = new DLLNode<T>(element);
		// if list is empty
		if (count == 0) {
			head = newNode;
			tail = newNode;
		} else if (index == 0) {
			newNode.setNext(head);
			head.setPrevious(newNode);
			head = newNode;
		} else {
			// if adding at tail
			if (index == count) {
				tail.setNext(newNode);
				newNode.setPrevious(tail);
				tail = newNode;
			} else {
				// traverse through list
				DLLNode<T> current = head;
				for (int i = 0; i < index - 1; i++) {
					current = current.getNext();
				}
				newNode.setPrevious(current);
				newNode.setNext(current.getNext());
				current.getNext().setPrevious(newNode);
				current.setNext(newNode);
			}
		}
		modCount++;
		count++;
	}

	@Override
	public T removeFirst() {
		if (count == 0) {
			throw new NoSuchElementException("Can't remove, list is empty");
		}
		return remove(0);
	}

	@Override
	public T removeLast() {
		if (count == 0) {
			throw new NoSuchElementException("Can't remove, list is empty");
		}
		return remove(count - 1);
	}

	@Override
	public T remove(T element) {
		int index = indexOf(element);
		
		// if item not found 
		if(index == -1)
		{
			throw new NoSuchElementException("Can't remove item, not in list"); 
		}
		
		return remove(index);
	}

	@Override
	public T remove(int index) {
		// check for valid index 
		if(index < 0 || index >= count)
		{
			throw new IndexOutOfBoundsException("Can't remove, invalid index"); 
		}

		T item = null; 
		// if list size == 1
		if(count == 1) {
			item = head.getElement();
			head = null;
			tail = null;
		} else if (index == 0) {
			DLLNode<T> next = head.getNext(); 
			head.setNext(null);
			next.setPrevious(null);
			item = head.getElement(); 
			head = next; 
			
		} else {
			DLLNode<T> current = head; 
			// traverse to node prior at index 
			for(int i = 0; i < index - 1; i++)
			{
				current = current.getNext(); 
			}
			DLLNode<T> itemToRemove = current.getNext();
			DLLNode<T> next = itemToRemove.getNext();
			current.setNext(next);
			if (next != null) {
				next.setPrevious(current);
			}
			itemToRemove.setNext(null);
			itemToRemove.setPrevious(null);
			item = itemToRemove.getElement();
			itemToRemove = null; // clean up memory
			if(index == count-1)
			{
				tail = current; 
			}
		}

		count--; 
		modCount++; 
		
		return item;
	}

	@Override
	public void set(int index, T element) {
		// check for valid index 
		if(index < 0 || index >= count)
		{
			throw new IndexOutOfBoundsException("Can't set, invalid index"); 
		}
		
		DLLNode<T> current = head; 
		// traverse to node prior at index 
		for(int i = 0; i < index; i++)
		{
			current = current.getNext(); 
		}
		current.setElement(element);
		modCount++;
	}

	@Override
	public T get(int index) {
		// check for valid index 
		if(index < 0 || index >= count)
		{
			throw new IndexOutOfBoundsException("Can't get, invalid index"); 
		}
		
		DLLNode<T> current = head; 
		// traverse to node prior at index 
		for(int i = 0; i < index; i++)
		{
			current = current.getNext(); 
		}
		
		return current.getElement();
	}

	@Override
	public int indexOf(T element) {
		boolean found = false; 
		DLLNode<T> current = head; 
		int index = 0; 
		
		// loop until at end of list, or found item 
		while((index != count) && !found)
		{
			if (element.equals(current.getElement()))
			{
				found = true; 
			}
			else
			{
				current = current.getNext(); 
				index++; 
			}
		}
		
		// if item not found 
		if(!found)
		{
			return -1;
		}
		
		return index;
	}

	@Override
	public T first() {
		if (count == 0) {
			throw new NoSuchElementException("Can't access element, list is empty");
		}
		return head.getElement();
	}

	@Override
	public T last() {
		if (count == 0) {
			throw new NoSuchElementException("Can't access element, list is empty");
		}
		return tail.getElement();
	}

	@Override
	public boolean contains(T target) {
		return (indexOf(target) > -1);
	}

	@Override
	public boolean isEmpty() {
		return (count == 0);
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public Iterator<T> iterator() {
		return (Iterator<T>) new IUDoubleLinkedListLIterator();
	}

	@Override
	public ListIterator<T> listIterator() {
		return new IUDoubleLinkedListLIterator();
	}

	@Override
	public ListIterator<T> listIterator(int startingIndex) {
		if (startingIndex >= count || startingIndex < 0) {
			throw new IndexOutOfBoundsException("Can't create ListIterator, starting index out of bounds");
		}
		return new IUDoubleLinkedListLIterator(startingIndex);
	}

	/**
	 * Implementation of the ListIterator interface for a double linked list
	 * @author carte
	 *
	 */
	private class IUDoubleLinkedListLIterator implements ListIterator<T> {

		private DLLNode<T> next; // Node with the next object to be returned 
		private DLLNode<T> current; // Node with last object returned by next or previous
		private DLLNode<T> previous; // Node with the previous object to be returned 
		private int itrModCount, currentIndex; // number of modifications made before Iterator intialized, int of current index
		private boolean canModify, isNext; // whether we can remove last item called by next, isNext
													   // represents if next or previous was run last
		
		/**
		 * default constructor
		 */
		public IUDoubleLinkedListLIterator() {
			next = head; 
			current = null; 
			previous = null; 
			itrModCount = modCount; 
			canModify = false;
			currentIndex = 0;
			isNext = false;
		}
		
		/**
		 * constructor that takes in a starting index and traverses to that index
		 * @param startingIndex
		 */
		public IUDoubleLinkedListLIterator(int startingIndex) {
			next = head;
			for (int i = 0; i < startingIndex; i++) {
				next = next.getNext();
			}
			current = null; 
			previous = null; 
			itrModCount = modCount; 
			canModify = false;
			isNext = false;
			currentIndex = startingIndex;
		}
		
		@Override
		public boolean hasNext() {
			return (next != null);
		}

		@Override
		public T next() {
			if(itrModCount != modCount)
			{
				throw new ConcurrentModificationException("Can't call next, changes made"); 			
			}
			
			if(!hasNext())
			{
				throw new NoSuchElementException("Can't call next, end of iteration"); 
			}
			
			current = next; 
			next = next.getNext(); 
			previous = current;
			canModify = true; 
			currentIndex++;
			isNext = true;
			
			return current.getElement(); 
		}

		@Override
		public boolean hasPrevious() {
			return (previous != null);
		}

		@Override
		public T previous() {
			if(itrModCount != modCount)
			{
				throw new ConcurrentModificationException("Can't call next, changes made"); 			
			}
			
			if(!hasPrevious())
			{
				throw new NoSuchElementException("Can't call next, end of iteration"); 
			}
			
	 
			current = previous;
			previous = current.getPrevious();
			next = current;		
			canModify = true;
			currentIndex--;
			isNext = false;
			
			return current.getElement(); 
		}

		@Override
		public int nextIndex() {
			return currentIndex;
		}

		@Override
		public int previousIndex() {
			return currentIndex - 1;
		}

		@Override
		public void remove() {
			if(!canModify)
			{
				throw new IllegalStateException("Can't remove, haven't called next");
			}
			if(itrModCount != modCount)
			{
				throw new ConcurrentModificationException("Can't call remove, changes made"); 			
			}
			if (isNext) {
				current.setNext(null);
				if(current == head)
				{
					head = next; 
					current = null; 
				} else if (current == tail) {
					current.getPrevious().setNext(null);
				} else {
					previous.setNext(next);  // can't do this if current == head 
					next.setPrevious(previous);
					current = previous; 
				}
				if(current == tail)
				{
					tail = previous; 
				}
			} else {
				next = current.getNext();
				current.setPrevious(null);
				current.setNext(null);
				if(current == tail)
				{
					tail = previous; 
					current = null; 
				} else {
					next.setPrevious(previous);
					if (current != head) {
						previous.setNext(next);
					}
					current = next; 
				}
				if(current == head)
				{
					head = next; 
				}
			}
			canModify = false;
			
			count--; 
		}

		@Override
		public void set(T e) {
			if(!canModify)
			{
				throw new IllegalStateException("Can't set, haven't called next or previous");
			}
			if(itrModCount != modCount)
			{
				throw new ConcurrentModificationException("Can't call set, changes made"); 			
			}
			current.setElement(e);
		}

		@Override
		public void add(T e) {
			if(itrModCount != modCount)
			{
				throw new ConcurrentModificationException("Can't call set, changes made"); 			
			}
			DLLNode<T> newNode = new DLLNode<T>(e);
			// if list is empty
			if (count == 0) {
				head = newNode;
				tail = newNode;
			} else if (currentIndex == 0) {
				newNode.setNext(head);
				head.setPrevious(newNode);
				head = newNode;
			} else if (current == null) {
				newNode.setPrevious(previous);
				newNode.setNext(next);
			} else {
				// if adding at tail
				if (currentIndex == count) {
					tail.setNext(newNode);
					newNode.setPrevious(tail);
					tail = newNode;
				} else {
					current.setPrevious(newNode);
					previous.setNext(newNode);
					newNode.setPrevious(previous);
					newNode.setNext(current);
				}
			}
			previous = newNode;
			canModify = false;
			currentIndex++;
			count++;
		}
	}
}
