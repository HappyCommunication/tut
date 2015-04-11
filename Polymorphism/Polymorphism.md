## Polymorphism

Polymorphism enables you to write programs that process objects that share the same superclass (either directly or indirectly) as if they’re all objects of the superclass; this can simplify programming.


Consider the following example of polymorphism.

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

public class AnimalTest {
 
    public static void main(String[] args) {
        Animal[] pets = new Animal[3];
        pets[0] = new Cat();
        pets[1] = new Dog();
        pets[2] = new Animal();
        for (int i = 0; i < pets.length; i++) {
            System.out.println(pets[i].talk());
        }
    }
}
```

## Interface
## Abstract class

## A complete example
Suppose we create a program that calculates the interest rates of several types of bank accounts. Classes CheckingAccount and SavingAccount represent the types of accounts. Each class extends superclass BankAccount, which contains general methods such as deposit, withdraw and apply interest rate at the end of month. Each subclass implements its own version of the method ```ApplyInterestRate```. Our program maintains an array containing references to objects of various BankAccount subclasses. 
At the end of month, the program traverse the array and tell the object to apply interest rate. To each object, the instruction is the same: apply interest rate. But how the tasks are carried out varies depending on the class of the object. This programming paradigm is called polymorphism. 
