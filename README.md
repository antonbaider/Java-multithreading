# Welcome to Practical Java
## JOM Multithreading

## Task 1

Create **ParallelCalculator** class that will be able to execute an operation in **parallel thread**.
Use the implementation of **Runnable** interface for this.

Constructor of **ParallelCalculator** should take **3 parameters**:

1. The **BinaryOperator<Integer>** to define an operation that will be executed,
2. The **operand1** of type int and **operand2** of type **int**.

The **ParallelCalculator** class should have **_not_**  **private result** field of type **int** where the result of the operation will be written when it's executed.
