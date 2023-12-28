# Welcome to Practical Java
## JOM Multithreading

## Task 4
Suppose, we have the next class:

    class MyThreads {
    public final static Object den = new Object();
    public final static Object ada = new Object();

        public static int n;
        public static int m;

         public static Thread t1 = new Thread() {
         public void run() {
            synchronized (den) {
                for(int i = 0; i < 5; i++, n++)
                    System.out.println("Thread1 n = " + n);
                Thread.yield();
                synchronized (ada) {
                    for(int i = 0; i < 5; i++, m++)
                        System.out.println("Thread1 m = " + m);
                    System.out.println( "Thread1 success!");
                }  
            }  
        }  
    };

    public static Thread t2 = new Thread() {
        public void run() {
            synchronized (ada) {
                for(int i = 0; i < 5; i++, m++)
                    System.out.println("Thread2 m = " + m);
                Thread.yield();
                synchronized (den) {
                    for(int i = 0; i < 5; i++, n++)
                        System.out.println("Thread2 n = " + n);
                    System.out.println("Thread2 success!");
                    }
                 }
             }
        };   
    }

Fix the problem with the preloaded implementation of the class **MyThread**.

Test starts both threads with the code:

        MyThreads.t1.start();
        MyThreads.t2.start();

The goal of each thread is to update **m** and **n** fields and not switch between threads **while loop is executed**.

You need to get an output like this:<br/>

Thread1 n = 0<br/>
Thread1 n = 1<br/>
Thread1 n = 2<br/>
Thread1 n = 3<br/>
Thread1 n = 4<br/>
Thread2 m = 0<br/>
Thread2 m = 1<br/>
Thread2 m = 2<br/>
Thread2 m = 3<br/>
Thread2 m = 4<br/>
Thread2 n = 5<br/>
Thread2 n = 6<br/>
Thread2 n = 7<br/>
Thread2 n = 8<br/>
Thread2 n = 9<br/>
Thread2 success!<br/>
Thread1 m = 5<br/>
Thread1 m = 6<br/>
Thread1 m = 7<br/>
Thread1 m = 8<br/>
Thread1 m = 9<br/>
Thread1 success!<br/>
Please, don't change actions that change variables or print output within **run()** methods. Use only **thread synchronization assets**.
