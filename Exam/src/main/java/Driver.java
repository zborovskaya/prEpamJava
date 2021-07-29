import java.util.function.Function;

public class Driver implements Cloneable {
    private String name;
    private int age;
    private static int sr;

    public Driver(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public Driver clone() throws CloneNotSupportedException {
        return (Driver) super.clone();
    }

    public class InnerDriver{
        private  int rer;
        public void me(){
            sr++;
        }
    }
    public static Function<String, Integer> build(String strNum) {
        int[] count = {1};
        ++count[0];
        return t -> Integer.valueOf(strNum + t) + ++count[0];
    }
}
