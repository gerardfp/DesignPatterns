package factory.notificationsystem;

abstract class Notification {
    String destination;

    Notification(String destination) {
        this.destination = destination;
    }

    abstract void send();

    static Notification to(String destination) {
        if (destination.contains("@")) {
            return new EmailNotification(destination);
        } else if (destination.startsWith("http")) {
            return new PushNotification(destination);
        }
        return new SMSNotification(destination);
    }
}

class EmailNotification extends Notification {

    EmailNotification(String destination) {
        super(destination);
    }

    @Override
    void send() {
        System.out.println("Sending EMAIL to: " + destination);
    }
}

class SMSNotification extends Notification {

    SMSNotification(String destination) {
        super(destination);
    }

    @Override
    void send() {
        System.out.println("Sending SMS to: " + destination);
    }
}

class PushNotification extends Notification {

    PushNotification(String destination) {
        super(destination);
    }

    @Override
    void send() {
        System.out.println("Sending PUSH to: " + destination);
    }
}

public class Main {
    public static void main(String[] args) {
        Notification.to("gerard@benigaslo.com").send();
        Notification.to("http://benigaslo.com/gerard").send();
        Notification.to("+34 678 789 890").send();
    }
}
