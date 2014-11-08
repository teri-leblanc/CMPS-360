package inheritance;

public class Main extends a {

    public Main() {
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        // System.out.println(f); private access
    }

    public static void main(String []args) {
        Main demo = new Main();
    }
}
