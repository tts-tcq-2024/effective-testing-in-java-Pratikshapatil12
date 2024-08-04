public class Alerter {
    private static int alertFailureCount = 0;
    private static NetworkAlert networkAlert = new StubNetworkAlert(); // Default to stub
    
    static void setNetworkAlert(NetworkAlert alert) {
        networkAlert = alert;
    }

    static void alertInCelsius(float fahrenheit) {
        float celsius = (fahrenheit - 32) * 5 / 9;
        int returnCode = networkAlert.sendAlert(celsius);
        if (returnCode != 200) {
            // increment failure count correctly
            alertFailureCount++;
        }
    }

    public static void main(String[] args) {
        // Use the stub by default
        alertInCelsius(400.5f);
        alertInCelsius(303.6f);
        System.out.printf("%d alerts failed.\n", alertFailureCount);
        System.out.println("All is well (maybe!)\n");
    }
}
interface NetworkAlert {
    int sendAlert(float celsius);
}
class StubNetworkAlert implements NetworkAlert {
    @Override
    public int sendAlert(float celsius) {
        System.out.println("ALERT: Temperature is " + celsius + " Celsius");
        return 200;
    }
}
