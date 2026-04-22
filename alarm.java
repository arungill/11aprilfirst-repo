import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AlarmClock {

    public static void main(String[] args) {
        // Set your alarm time (HH:mm:ss)
        String alarmTime = "07:30:00";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println("Alarm set for " + alarmTime);

        while (true) {
            LocalTime currentTime = LocalTime.now();
            String now = currentTime.format(formatter);

            System.out.println("Current time: " + now);

            if (now.equals(alarmTime)) {
                System.out.println("⏰ Alarm! Wake up!");

                // Optional: beep sound
                java.awt.Toolkit.getDefaultToolkit().beep();

                break;
            }

            try {
                Thread.sleep(1000); // check every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
