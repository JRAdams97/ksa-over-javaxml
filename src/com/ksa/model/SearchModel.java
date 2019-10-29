package com.ksa.model;

import com.ksa.controller.SearchController;

public class SearchModel {

	public static final String TITLE_SEARCH = "title";
	public static final String KEYWORD_SEARCH = "keyword";
	private String searchType = TITLE_SEARCH;

	private final SearchController controller;

	public SearchModel(final SearchController controller) {
		this.controller = controller;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
}
