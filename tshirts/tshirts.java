public class Tshirts {
    static String size(int cms) {
        if (cms < 38) {
            return "S";
        } else if (cms <= 42) { // Fixed boundary condition
            return "M";
        } else {
            return "L";
        }
    }

    public static void main(String[] args) {
        assert("S".equals(size(37)));
        assert("M".equals(size(38)));
        assert("M".equals(size(40)));
        assert("L".equals(size(43)));
        assert("L".equals(size(100))); // Additional test case
        System.out.println("All is well (maybe!)");
    }
}
