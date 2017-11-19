package com.hollywood.java8;

/**
 * Created by andrewlongstaffe on 08/02/2017.
 * TODO: More practise using lambda scope
 */
public class LambaScopeTest {
    final static String salutation = "Hello! ";

    public static void main(String args[]){
        // Variable accessed outside of function must be final
        GreetingService greetService1 = message -> System.out.println(salutation + message);
        greetService1.sayMessage("Mahesh");

        // effective final variables work too, ie if they are updated a second time, stuff will break
        String startMessage = "Hey ";
        GreetingService greetService2 = message -> System.out.println(startMessage + message);
        greetService2.sayMessage("Mahesh");

        //Updating the variable a second time gives a compilation error
        //startMessage = "Goodbye";
    }

    interface GreetingService {
        void sayMessage(String message);
    }
}
