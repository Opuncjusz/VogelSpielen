package service;

import model.Stakeholder;

public interface NotificationService {

	void notifyClients();

	public void sendNotification(Stakeholder stakeholder);

}
