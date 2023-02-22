public class bOne {
    private String name;
    private Integer age;

    public bOne(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        bOne john = new bOne("John", 30);
    }
}
