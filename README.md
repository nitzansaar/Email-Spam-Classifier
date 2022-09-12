#### Homework 2: Classifying spam emails with Naive Bayes. 

##### Due: Sept 23 at the start of class.

In this homework you'll be implementing a simple machine learning classifier using the Naive Bayes algorithm to determine whether an email is spam or ham.
This will give you a chance to practice some of the skills you've learned so far and integrate them into a real-world
application. I've provided a fair amount of code for you to get you started - a lot of your tasks are using or extending existing code.

All code should be well-formatted, with no extraneous or commented-out code. Please include your name in a comment at the top of each file.

This homework will be graded using specifications grading. There are a sequence of tasks to complete. Grades will be assigned as follows:


- To receive a C, you should complete tasks 1,2,3,4
- To receive a B, complete all the C-level tasks, plus tasks 5 and 6
- To receive an A, complete the B-level tasks, plus task 7.

This description is relatively short - you'll want to refer to the class slides and lecture for details on how to complete these tasks.

Recall from class that we are going to treat an email as a bag of words. Our problem then becomes one of predicting
which class (spam or ham) is more likely, given the words in the email.

Step 1: Processor.

To begin, we need to convert an email into a list of words. While doing so, we also want to remove those words that are not useful.
We will do this in the Processor class. Processor should work with a single file. It will read it in, convert everything to lower case,
strip off trailing punctuation, check to see if a word is either a junk word or a stop word, and then return an ArrayList of Strings
containing the remaining words.

<b>
 Task 1: implement the stripPunctuation, isJunk and isStopword methods.

 Task 2: implement parseFile. 

 Task 3: Create a test class called ProcessorTest that tests this out. It should have a method called test() that calls each of the methods in 
 Processor with some sample data. Use this to check for "edge cases."
</b>

Step 2: Now we need to count the number of times a word occurs in a file, or list of files. We'll do this with the FreqDist class.
This is largely a wrapper for a HashMap, with two additions:

 - If a word is not present in a corpus, we'll give it a count of 1.
 - We also want to keep track of how many words we've counted. 

I've set this up for you - you'll just need to use the interface.

<b>
 Task 4: Extend ProcessorTest to make sure that the FreqDist class is tested and that you know how to use it.
</b>

Step 3: Now we want to be able to determine how likely it is that a new email is spam or ham, given the contents of the
 training set. We'll do this with the Predictor class, which has a method that computes the log likelihood, as discussed in the class slides.

<b>
  Task 5: implement computeLogLikelihood. 
  Task 6: Extend ProcessorTest once again to check Loglikelihood. You may want to try it on a couple of very simple cases if you're not sure of the results.
</b>

Step 4:

Get it all running! 
 
The TestManager class has a main() that does the actual training and testing. For each email, it prints out "Correct" or "Incorrect".

<b>
 Task 7: Extend the TestManager to keep track of how many emails of each type were classified correctly. (you should be able to classify at least 70% correctly.)
</b>
