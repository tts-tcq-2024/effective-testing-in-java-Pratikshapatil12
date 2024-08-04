public class AlerterTest {
    public static void testAlertFailures() {
        NetworkAlert mockNetworkAlert = new NetworkAlert() {
            @Override
            public int sendAlert(float celsius) {
                return 500; // Simulate a failure
            }
        };
        Alerter.setNetworkAlert(mockNetworkAlert);
        Alerter.alertInCelsius(400.5f);
        Alerter.alertInCelsius(303.6f);
        assert(Alerter.alertFailureCount == 2);
    }

    public static void main(String[] args) {
        testAlertFailures();
        System.out.println("Alerter tests completed.");
    }
}
