package com.pizza.online.serv;

import javax.persistence.Query;

import org.hibernate.Session;

import com.pizza.online.model.UserCredential;
import com.pizza.online.model.util.UserReply;
import com.pizza.online.util.Utility;

public class CredentialService extends FactoryService {

	public CredentialService() {
		super();
	}

	public boolean availability(String emailId) {
		Session session = this.factory.openSession();
		boolean status = false;

		UserCredential credential = session.get(UserCredential.class, emailId);
		if (credential != null) {
			status = true;
		}

		session.close();
		return status;
	}

	public UserReply activate(String emailId, String authKey) {
		Session session = this.factory.openSession();
		UserReply reply = new UserReply();
		UserCredential credential = session.get(UserCredential.class, emailId);
		if (credential != null && authKey.equals(credential.getAuthKey())) {
			credential.setAuthKey("");
			credential.setActivated(true);
			reply.setStatus(true);
			session.beginTransaction();
			session.update(credential);
			session.getTransaction().commit();
		}
		reply.setCredential(credential);
		session.close();
		return reply;
	}

	public UserReply updatePassword(String emailId, String oldPassword, String newPassword) {
		Session session = this.factory.openSession();

		Query query = session.createQuery("from UserCredential where emailId = ? and password = ?");
		query.setParameter(0, emailId);
		query.setParameter(1, oldPassword);
		UserReply reply = new UserReply();
		UserCredential credential = (UserCredential) query.getSingleResult();
		if (credential != null && credential.getActivated()) {
			credential.setPassword(newPassword);
			reply.setStatus(true);
			session.beginTransaction();
			session.update(credential);
			session.getTransaction().commit();
		}
		reply.setCredential(credential);
		session.close();
		return reply;
	}

	public UserReply create(String emailId, String password) {
		Session session = this.factory.openSession();
		session.beginTransaction();
		UserCredential credential = session.get(UserCredential.class, emailId);
		UserReply reply = new UserReply();
		if (credential == null) {
			credential = new UserCredential();
			credential.setEmailId(emailId);
			credential.setPassword(password);
			credential.setAuthKey(Utility.generateKey(20));
			credential.setActivated(false);
			reply.setStatus(true);
			session.save(credential);

			session.getTransaction().commit();
		}
		reply.setCredential(credential);
		session.close();
		return reply;
	}

	public CredentialStatus validate(String emailId, String password) {
		Session session = this.factory.openSession();
		UserCredential credential = session.get(UserCredential.class, emailId);
		CredentialStatus status = null;
		if (credential == null) {
			status = CredentialStatus.NOT_AVAILABLE;
		} else {
			if (password.equals(credential.getPassword())) {
				if (!credential.getActivated()) {
					status = CredentialStatus.NOT_ACTIVATED;
				} else {
					if (credential.getAuthKey().isEmpty()) {
						session.beginTransaction();

						String authKey = Utility.generateKey(20);
						credential.setAuthKey(authKey);

						session.update(credential);

						session.getTransaction().commit();
						status = CredentialStatus.SUCCESS;
						status.setAuthKey(authKey);
					} else {
						status = CredentialStatus.LOGGED;
					}
				}
			} else {
				status = CredentialStatus.ERROR;
			}
		}
		session.close();
		return status;
	}

	public UserReply check(String emailId, String authKey) {
		Session session = this.factory.openSession();
		UserReply reply = new UserReply();

		UserCredential credential = session.get(UserCredential.class, emailId);
		if (credential != null && credential.getActivated() && authKey.equals(credential.getAuthKey())) {
			reply.setStatus(true);
		}
		reply.setCredential(credential);
		session.close();
		return reply;
	}

	public UserReply reset(String emailId, String password) {
		Session session = this.factory.openSession();
		UserReply reply = new UserReply();
		Query query = session.createQuery("from UserCredential where emailId = ? and password = ?");
		query.setParameter(0, emailId);
		query.setParameter(1, password);

		UserCredential credential = (UserCredential) query.getSingleResult();
		if (credential != null && credential.getActivated() && password.equals(credential.getPassword())
				&& !credential.getAuthKey().isEmpty()) {
			session.beginTransaction();
			reply.setStatus(true);
			credential.setAuthKey("");
			session.update(credential);
			session.getTransaction().commit();
		}
		reply.setCredential(credential);
		session.close();
		return reply;
	}

	public String request(String emailId) {
		Session session = this.factory.openSession();
		String authKey = null;
		UserCredential credential = session.get(UserCredential.class, emailId);
		if (credential != null && credential.getActivated()) {
			session.beginTransaction();
			authKey = Utility.generateKey(20);
			credential.setActivated(false);
			credential.setAuthKey(authKey);
			session.update(credential);
			session.getTransaction().commit();
		}

		session.close();
		return authKey;
	}

	public UserReply resetPassword(String emailId, String authKey, String password) {
		Session session = this.factory.openSession();

		Query query = session.createQuery("from UserCredential where emailId = ? and authKey = ?");
		query.setParameter(0, emailId);
		query.setParameter(1, authKey);
		UserReply reply = new UserReply();
		UserCredential credential = (UserCredential) query.getSingleResult();
		if (credential != null) {
			credential.setAuthKey("");
			credential.setPassword(password);
			credential.setActivated(true);

			reply.setStatus(true);

			session.beginTransaction();
			session.update(credential);
			session.getTransaction().commit();
		}
		reply.setCredential(credential);
		session.close();
		return reply;
	}
}
