# Welcome to Practical Java 
## JOM Multithreading

## Task 2

Suppose, you have class from task #1 **ParallelCalculator** that is able to execute an operation in separate thread. 
It uses an implementation of **Runnable** interface for this.

You need to create **Accountant** class with a **static sum(...)** method that takes two parameters of type int and returns their **_sum_**. 
Use **ParallelCalculator** for this. The **sum(...)** method doesn't **throw** any checked exceptions.

The **_sum_** must be evaluated in a **_separate thread_**  (please, don't call **run()** method of **ParallelCalculator**. Use **start()** method on object of type **Thread**).

Using **Thread.sleep()** method is unwelcomed in this task.
