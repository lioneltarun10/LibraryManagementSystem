//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.airtribe.notification;

import java.io.PrintStream;
import org.airtribe.Patron.Patron;

public class SMSNotificationService implements NotificationService {
    public SMSNotificationService() {
    }

    public void sendNotification(Patron patron, String message) {
        PrintStream var10000 = System.out;
        String var10001 = patron.getName();
        var10000.println("SMS notification sent to " + var10001 + " message is " + message);
    }
}
