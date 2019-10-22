package com.ksa.model;

public class MainModel {

	private static String databaseContent;

	public static String getDatabaseContent() {
		return databaseContent;
	}

	public static void setDatabaseContent(String databaseContent) {
		MainModel.databaseContent = databaseContent;
	}
}
