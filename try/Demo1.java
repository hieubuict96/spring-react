import java.lang.reflect.*;
import java.lang.ClassNotFoundException;

class Person {
  public String address;
}

class Customer extends Person {
  private int age;
  protected String gender;
  public String name;
  String phone;

  public Customer() {
  }

  public Customer(int age, String name) {
    this.age = age;
    this.name = name;
  }
  // setter - getter

  @Override
  public String toString() {
    return "Customer [age=" + age + ", gender=" + gender + ", name=" + name + ", phone=" + phone + "]";
  }
}

public class Demo1 {
  public static void main(String[] args) throws ClassNotFoundException {
    Customer customer = new Customer();
    customer.setName("kai");
    customer.setAge(25);

    demoReflection(customer);

  }

  public static void demoReflection(Object object) throws ClassNotFoundException {
    Class myClass = object.getClass();
    // Class myClass = Class.forName("stackjava.com.reflection.Customer");

    System.out.println("Class name: " + myClass.getName());
    System.out.println("Super Class name: " + myClass.getSuperclass().getName());
    System.out.println("Is interface: " + myClass.isInterface());
    System.out.println("Constructors: ");
    Constructor[] constructors = myClass.getDeclaredConstructors();
    for (Constructor constructor : constructors) {
      System.out.println(" Number of parameters: " + constructor.getParameterCount() + " - modifier: "
          + getModifierName(constructor.getModifiers()));
    }

    System.out.println("Fields:");
    Field[] allFields = myClass.getDeclaredFields();
    for (Field field : allFields) {
      System.out.println(" " + field.getName() + " - type: " + field.getType() + " - modifier: "
          + getModifierName(field.getModifiers()));
    }

    System.out.println("Methods: ");
    Method[] methods = myClass.getDeclaredMethods();
    for (Method field : methods) {
      System.out.println(" " + field.getName() + " - modifier: " + getModifierName(field.getModifiers()));
    }
  }

  public static String getModifierName(int mod) {
    if (Modifier.isPrivate(mod)) {
      return "private";
    }
    if (Modifier.isProtected(mod)) {
      return "protected";
    }
    if (Modifier.isPublic(mod)) {
      return "public";
    }
    if (Modifier.isPrivate(mod)) {
      return "private";
    }
    return "default";
  }

}