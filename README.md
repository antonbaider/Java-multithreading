# Welcome to Practical Java
## JOM Multithreading

## Task 3
Suppose, we have the next class:

    class threadExample{
        public static void threadRun() { 
            Interactor interactor = new Interactor();     
            Thread t1 = new Thread(()-> { 
                try{ 
                    interactor.serve(x -> -x+4, 11); 
                } 
                catch(InterruptedException e){ 
                    e.printStackTrace(); 
                }
            });   
        
            Thread t2 = new Thread(() -> { 
                try{ 
                    interactor.consume((a, b) -> a + 2*b, 20); 
                } 
                catch(InterruptedException e){ 
                    e.printStackTrace(); 
                }
            });   
        
                try{
                t2.start();            
                t1.start();  
                t2.join();             
                t1.join();             
                }
                catch(InterruptedException e){ 
                    e.printStackTrace(); 
            } 
        }
    }

You need to implement the methods of the **Interactor** class so that output will look like this:
**_Serving thread running<br/>
Serving thread initializes the key<br/>
key = -7<br/>
Consuming thread received the key. key = -7<br/>
Consuming thread changed the key. key = 33<br/>
Serving thread resumed_**

The **serve(...)** method should initialize the **x** field by applying its first parameter to the second one and print the messages only about its own actions.

The **counsume(...)** method should wait until **serve** initializes **x** field (and preferably no longer) and then change **x** by assigning to it the result of applying the method's first parameter to the current value of **x** and the second parameter. This method also prints the messages only about its own actions.

Assure that the **consume(...)** method should be able to execute without the **serve(...)** method being ever called after waiting for 3 seconds.

Use synchronized blocks (or methods), wait() and notify() methods for your implementation.
