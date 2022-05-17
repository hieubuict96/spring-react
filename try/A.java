public class A {
  public static void main(String[] args) {
    B b = new B();
    b.fun();
  }
}

class B {

  public String b = "b";

  String c = "c";

  protected String d = "d";

  public void fun() {
    G c = new G();
    System.out.println(c.g);
  }

  public class C {
    public String c = "cc";

    public void g() {
      G g = new G();
    }

    class G {
      public String g = "gg";
    }
  }

  class D {
    public String d = "dd";
  }

  protected class E {
    public String e = "eee";
  }

  private class F {
    public String f = "ff";
  }
}
