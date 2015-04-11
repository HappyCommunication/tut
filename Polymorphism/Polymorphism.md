## Polymorphism
In Geek roots, "poly" means *many* like polygon, and "morph" means *forms* or the way something behaves. 
In programming, polymorphism is the ability to change the behavior of an object as if it was another object. 

For example, adding a complex number ```C = a + bi``` and a real number ```R``` result in a complex number ```(a+R) + bi```. Here, the real number ```R``` can behave as if it was a complex number ```R + 0i```, making the addition looks like that of two complex numbers.

In Java, Polymorphism enables you to process objects that share the same superclass (either directly or indirectly) as if they’re all objects of the superclass. 
Subclasses of the superclass can define their own unique behaviors and yet share some of the same functionality of the superclass.

To demonstrate polymorphic features in the Java language, let us create an ```Animal``` class having a ```talk``` method and extend it with a ```Cat``` and a ```Dog``` class. For ```Animal```, the talk method simply throws an exception, which indicates the method has not yet implemented. For ```Cat```, override the ```talk``` method to return ```"Meow!"```. For ```Dog```, override the method to return ```Woof!```.

```java
class Animal {
    
    String talk() {
       throw new UnsupportedOperationException("Animal has not implement talk");
    }
}

class Cat extends Animal {
    String talk() {
        return "Meow!";
    }
}
 
class Dog extends Animal {
    String talk() {
        return "Woof!";
    }
}
```

As ```Cat``` is a subclass of ```Animal```, Java allows an object of type Animal to point to an object of type ```Cat```.
Hence, it is possible to write:
```java
Animal c = new Cat();
```
Now the object ```c``` is capble of calling every method in Animal class. But when you call ```c.talk()```, the actual method being applied is that of the ```Cat``` class. So, ```c.talk()``` will return the string ```"Meow!"```.
The following snippet demonstrates it.

```java
public class AnimalTest {
 
    public static void main(String[] args) {
        Animal[] pets = new Animal[3];
        pets[0] = new Cat();
        pets[1] = new Dog();
        pets[2] = new Animal();
        for (int i = 0; i < pets.length; i++) {
            System.out.println("Pet[" + i + "]: " + pets[i].talk());
        }
    }
}
```
The above code produce
```
Pet[0]: Meow!
Pet[1]: Woof!
Exception in thread "main" java.lang.UnsupportedOperationException: Animal has not implement talk
	at Animal.talk(AnimalTest.java:11)
	at AnimalTest.main(AnimalTest.java:35)
```
The ```talk``` method of ```Pet[2]``` is of ```Animal``` class. The method intentionally thows an exception as it is not implemented.

## Abstract class
Sometimes, we want a superclass to just act as general template. Based on the template, an object of the superclass becomes a type to exploit the polymorphic feature of Java language similar to the array of ```Animal``` mentioned above.  
However, we have no intention to allow an Animal in general to talk, thus the program thows an exception when the method is called. All this happen at run time, so we must run our program and hope to discover the mistake as soon as possible.  
There is a better way, though. By stating that ```Animal``` is an ```abstract``` class, there will be no object of such class, thus no call to the should-not-exist ```talk``` method.
```java
abstract class Animal {
    abstract String talk();
}
```
Using the new ```Animal``` class, the compiler compains about creating an object of abstract ```Animal``` class.
```
error: Animal is abstract; cannot be instantiated
        pets[2] = new Animal();
```
Furthermore, extending an ```abstract``` class without implementing the ```abstract``` method results a compile-time error. 
For example, we create a non-abstract Fish class using Animal as its superclass but forget to implement the ```talk``` method.
```java
class Fish extends Animal {
    
}
```

The error looks like
```
error: Fish is not abstract and does not override abstract method talk() in Animal
class Fish extends Animal {
```

## Interface
There are a number of situation where it is important to have a group of classes to exhibit a common behavior. For example, we want a ```Radio``` class to have the ```talk``` method as the ```Cat``` class has. Surely, a ```Radio``` should not be classified as an ```Animal```, yet need to be called via a ```talk``` interface.

In Java, an ```interface``` type is similar to an abstract class. Specifically, acting as a template, it could not do anything. The ```implements``` keyword is used to state that the following class implements all the methods specfied in the interface.

Here is an example.
```java
// File TalkInterfaceTest.java
import java.io.*; // header stuff MUST go above the first class

interface Talk {
	String talk();
}

class Cat implements Talk {
    public String talk() {
        return "Meow!";
    }
}

class Radio implements Talk {
    public String talk() {
        return "This is the Voice of America!";
    }
}

public class TalkInterfaceTest {

    public static void main(String[] args) {
        Talk[] things = new Talk[2];
      	Cat c = new Cat();
      	Radio r = new Radio();
        things[0] = c;
        things[1] = r;
        for (int i = 0; i < things.length; i++) {
            System.out.println("Things[" + i + "]: " + things[i].talk());
        }
    }
}
```
In the above code, the ```Talk``` interface is used as to references objects in the ```things``` array. Such objects can invoke only methods specified in the interface.  
Try it, you will see the following output
```
Things[0]: Meow!
Things[1]: This is the Voice of America!
```

At this point, you may be asking "What is the difference between ```abstract``` and ```interface```"?  
In practice, ```interface``` are used quite often but ```abstract``` is not. A lot of objects has the same interface, but only a small number of them are organized into a hierarchy. The reason to favor which one is out of scope of this article.   
For those new to the OOP concept, practical experience is more useful than the minute differences in concept between ```abstract``` and ```interface```.

## A complete example
Suppose we create a program that calculates the interest rates of several types of bank accounts. Classes CheckingAccount and SavingAccount represent the types of accounts. Each class extends superclass BankAccount, which contains general methods such as deposit, withdraw and apply interest rate at the end of month. Each subclass implements its own version of the method ```ApplyInterestRate```. Our program maintains an array containing references to objects of various BankAccount subclasses. 
At the end of month, the program traverse the array and tell the object to apply interest rate. To each object, the instruction is the same: apply interest rate. But how the tasks are carried out varies depending on the class of the object. This programming paradigm is called polymorphism.   
TODO: 
```java
//AccounTest.java
```


## Summary
