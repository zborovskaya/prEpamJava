public class Child extends MainClass{
    @Override
    public void method() {
        super.method();
        System.out.println("Child");
    }
    public static void main(String[ ] args) {
        MainClass mainClass=new Child();
        Child с= (Child)mainClass;
    }

}
