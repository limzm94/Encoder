public class Main {
    public static void main(String[] args) {
        Encoder encoder = new Encoder();
        System.out.println(encoder.encode("HELLO WORLD?"));
        System.out.println(encoder.decode("HA-EEH PHKE,?"));
    }
}