package com.ksa.model;

import com.ksa.model.entity.Database;

public class MainModel {

	private static String databaseContent;
	private static Database databaseEntity;

	public static String getDatabaseContent() {
		return databaseContent;
	}

	public static void setDatabaseContent(String databaseContent) {
		MainModel.databaseContent = databaseContent;
	}

	public static Database getDatabaseEntity() {
		return databaseEntity;
	}

	public static void setDatabaseEntity(Database databaseEntity) {
		MainModel.databaseEntity = databaseEntity;
	}
}
