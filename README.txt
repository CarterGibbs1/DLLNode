****************
* Project 2 - Double-Linked List
* CS 221 section 4
* 12/3/21
* Carter Gibbs
**************** 

OVERVIEW:

The program is an implementation of a double-linked list with listIterator functionality


INCLUDED FILES:

DLLNode.java - Double-Linked list node class that stores references to the previous and next node in a list
IndexedUnsortedListTests.java - A unit test class for implementations of the IndexedUnsortedList ADT. 
IteratorTests.java - A unit test class for implementations of the Iterator interface.
ItrState.java - Possible states of iterator that could be tested. 
ItrTest_1-43_ChangeScenario.java - Testing for IndexedUnsortedList ADT implementation, Iterator testings for Change scenarios
IUDoubleLinkedList.java - Double linked list implementation of the IndexedUnsortedList interface
ListIteratorTests.java - A unit test class for implementations of the ListIterator interface.
ListItrState.java - Possible states of ListIterator that could be tested. 
ListItrTest_1-43_ChangeScenario.java - Testing for IndexedUnsortedList interface implementation, ListIterator Tests for Change Scenarios
ListType.java - Possible lists that could be tested. 
Result.java - Possible results expected in tests
RunIndexedUnsortedTests.java - Runs a set of black box tests for lists that implement IndexedUnsortedList ADT. 
RunIteratorTests.java - Runs a set of black box tests for lists that implement Iterator interface. 
RunListIteratorTests.java - Runs a set of black box tests for lists that implement ListIterator interface. 
Test_1-39_ChangeScenario - Testing for IndexedUnsortedList interface implementation

COMPILING AND RUNNING:


 From the directory containing all the source files, compile
 the driver classes (and all dependencies) with the commands:

 To compile RunIndexedUnsortedTests:
$ javac RunIndexedUnsortedTests.java

 To compile RunIteratorTests:
$ javac RunIteratorTests.java

 To compile RunListIteratorTests:
$ javac RunListIteratorTests.java

 Run the compiled class with the commands:

 To run RunIndexedUnsortedTests:
$ java RunIndexedUnsortedTests.java

 To run RunIteratorTests:
$ java RunIteratorTests.java

 To run RunListIteratorTests:
$ java RunListIteratorTests.java

 Console output will give the results after the program finishes.

PROGRAM DESIGN AND IMPORTANT CONCEPTS:

The RunIndexedUnsortedTests class calls onto IndexedUnsortedListTests to run the change scenario
tests and initializing a double-linked list. The double-linked list is initialized in the 
IUDoubleLinkedList class. The class creates nodes from the DLLNode class to link the list together.
The DLLNode class contains a reference to the next and previous node in a list. The IUDoubleLinkedList
is composed of a head and tail node to help traverse the list. The IUDoubleLinkedListLIterator private class
creates a List Iterator to iterate the double-linked list. The RunListIteratorTests class calls onto
ListIteratorTests to run List Iterator change scenario tests. The RunIteratorTests class calls onto IteratorTests
to run the Iterator change scenario tests.

TESTING:

I ran my double-linked list class against around 30 change scenarios to make sure it worked correctly. The class handles bad
inputs and exceptions but also uses generics to ensure type-saftey. The List Iterator has ran against around 80
change scenarios to ensure that the iterator works correctly.

DISCUSSION:
 
 I had many issues when programming the double-linked list. I had many bugs when programming the add and remove methods
since I would have troubles when updating the next, head, and tail fields. I also had issues with figuring
out the special cases for the iterator methods and linked-list methods. I would draw out the abstract picture to help me
solve these issues. I got a lot of NullPointerExceptions and IndexOutOfBoundsExceptions. The most challenging
part of the project was figuring out the iterator stuff. I visually couldn't understand the next and previous
fields because at some moments, previous/next would be equal to current. After a bit of trying to understand, it finally
clicked for me.

----------------------------------------------------------------------------