//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.airtribe.notification;

public class NotificationFactory {
    public NotificationFactory() {
    }

    public static NotificationService createNotification(String type) {
        if (type.equalsIgnoreCase("SMS")) {
            return new SMSNotificationService();
        } else if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotificationService();
        } else {
            throw new IllegalArgumentException("Invalid notification type: " + type);
        }
    }
}
