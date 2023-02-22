public class pgmOne {
    public void print(int c) {

        System.out.println(c);
        c++;
        if (c == 10) {
            return;
        } else {
            print(c);
        }
    }

    public static void main(String[] args) {
        pgmOne p = new pgmOne();
        int count = 0;
        p.print(count);
    }
}
