public class GenericsEg {
    public static void main(String[] args) {
        Printer<String> p = new Printer<>("raisan");
        Printer<Double> t = new Printer<>(0.23);
        p.print();
        t.print();
    }
}
