public class  HorribleSteve {
    public static void main(String [] args) throws Exception {
        int i = 0;
        int j=0;
        for (; i < 1000; i=4+i, j=j+4) {
            if (!Flik.isSameNumber(i, j)) {
                throw new Exception(
                        String.format("i:%d not same as j:%d ??", i, j));
            }
        }
        System.out.println("i is " + i);
    }
}
