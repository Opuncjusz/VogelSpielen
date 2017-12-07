package service;

public interface NotificationService {

    void notifyClients();

    public void sendNotificationToOlek(String notificationTitle, String notificationBody);
}
