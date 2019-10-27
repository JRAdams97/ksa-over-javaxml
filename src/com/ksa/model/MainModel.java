package com.ksa.model;

import com.ksa.model.entity.Database;

import java.util.HashMap;
import java.util.Hashtable;

public class MainModel {

	private static String databaseContent;
	private static Database databaseEntity;
	private static String titleContent;
	private static String movieContent;
	private static HashMap correlatedKeywords;
	
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
	
	public static String getTitleContent() {
		return titleContent;
	}

	public static void setTitleContent(String titleContent) {
		MainModel.titleContent = titleContent;
	}
	
	public static HashMap getCorrelatedKeywords() {
		return correlatedKeywords;
	}

	public static void setCorrelatedKeywords(HashMap correlatedKeywords) {
		MainModel.correlatedKeywords = correlatedKeywords;
	}
}
