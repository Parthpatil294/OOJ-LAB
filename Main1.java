class WrongAge extends Exception {
    public WrongAge(String message) {
        super(message);
    }
}

// Base Class: Father
class Father {
    int fatherAge;

    // Constructor that accepts father's age and throws exception if age < 0
    public Father(int age) throws WrongAge {
        if (age < 0) {
            throw new WrongAge("Father's age cannot be negative.");
        }
        this.fatherAge = age;
    }
}

// Derived Class: Son, extends Father
class Son extends Father {
    int sonAge;

    // Constructor that accepts both father's and son's age
    public Son(int fatherAge, int sonAge) throws WrongAge {
        super(fatherAge); // Calling the Father constructor

        if (sonAge >= fatherAge) {
            throw new WrongAge("Son's age cannot be greater than or equal to father's age.");
        }
        this.sonAge = sonAge;
    }
}

// Main Class: FamilyTest1
public class Main1 {
    public static void main(String args[]) {
        try {
            // Valid case: Son's age < Father's age
            Son son1 = new Son(40, 30);  
            System.out.println("Father's age: 40, Son's age: 30\n");

            // Invalid case: Son's age >= Father's age
            Son son2 = new Son(30, 35);  
        } catch (WrongAge e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            // Invalid case: Father's age < 0
            Son son3 = new Son(-10, 20);  
        } catch (WrongAge e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}