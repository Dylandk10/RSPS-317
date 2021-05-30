package server.task;

import server.model.players.Client;
import server.model.players.PlayerHandler;


public class TaskFactory {

	public static Task getDelayedTask(final String callbackFunction,
			final Client client, final int actionX, final int actionY) {
		Task task = new Task(client, false) {
			@Override
			public void run() {
				synchronized (PlayerHandler.players) {
				}
			}
		};
		return task;
	}

	public static Task getDelayedTask(final String callbackFunction,
			final Client client, final int actionID, final int actionX,
			final int actionY) {
		Task task = new Task(client, false) {
			@Override
			public void run() {
				synchronized (PlayerHandler.players) {
				}
			}
		};
		return task;
	}

	public static Task getDelayedGlobalTask(final String callbackFunction,
			final int actionID, final int actionX, final int actionY) {
		Task task = new Task(null, true) {
			@Override
			public void run() {
				synchronized (PlayerHandler.players) {
				}
			}
		};
		return task;
	}

	protected static class Task implements Runnable {

		private Client client;
		private boolean global;

		public Task(Client client, boolean global) {
			this.client = client;
			this.global = global;
		}

		public void run() {
		}

		public Client getClient() {
			return client;
		}

		public boolean isGlobal() {
			return global;
		}

	}

}
