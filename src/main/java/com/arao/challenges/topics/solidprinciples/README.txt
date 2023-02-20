SOLID principles

1. Single Responsibility:
    One class should have one and only one responsibility, and it should not be mixed with different tasks.

2. Open and Close principle:
    One class must be open for extension but close for modifications
    ie: There is a class that manage the login through username and password (class A), then if we need to add another functionality to handle the login using JWT token working
    alongside functionality inb class A, this principle states, creates a new class (class B) and extends class A in class B but never modify class A for adding that new
    functionality.

3. Liskov Substitution:
    This principle states that any representation of an interface must work exactly the same way if we interchange the implementation of it
    IE: class List and implementation ArrayList and Vector, if we use one of other implementation the functionality must be the same

4. Interface segregation:
    This principle states if we use an implementation of an interface but the implementation does not need all the interface methods, then, it´s better split(segregate)
    the interface into two interfaces so that the implementation class only use the one with the method it requires and don't have to implement all the methods the interface provides

5. Dependency Inversion:
    1. High-level modules should not depend on Low-level modules, both should depend on abstractions.
    2. Abstractions should not depend on details, the details should depend on abstractions.
