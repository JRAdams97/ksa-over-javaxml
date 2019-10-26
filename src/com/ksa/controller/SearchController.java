package com.ksa.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ksa.model.MainModel;
import com.ksa.model.SearchModel;
import com.ksa.model.entity.Database;
import com.ksa.model.entity.Movie;
import com.ksa.view.SearchView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class SearchController implements EventHandler {

	private Stage mainStage;
	private final SearchView view = new SearchView(this);
	private final SearchModel model = new SearchModel(this);

	public Stage getMainStage() {
		return mainStage;
	}

	public SearchView getView() {
		return view;
	}

	public SearchModel getModel() {
		return model;
	}

	public SearchController(final Stage mainStage) {
		this.mainStage = mainStage;
	}

	@Override
	public void handle(final Event event) {
		Object source = event.getSource();
		
		if (source.equals(view.getSearchBtn())) {
			String searchkeyword = view.getSearchField().getText();
			String database =  MainModel.getDatabaseContent();
			Hashtable<String,Integer> countTable =  new Hashtable<String,Integer>(); 
			
			// get the number of keywords and all kwscontent from database
			int kwsNo = 0;
			String kwsContent = "";
			String regx = "<kw>(.*?)</kw>";
			Pattern pattern = Pattern.compile(regx);
			Matcher kwsMatcher = pattern.matcher(database);
			
			while(kwsMatcher.find()) 
			{
				kwsNo++;
				kwsContent += kwsMatcher.group(1)+"\n";
			}

			MainModel.setTotalKeywords(kwsNo);
			
			// get all movie content from database
			String movieContent = "";
			String newdatabase = database.replaceAll(System.lineSeparator(), "");
			String regx2 = "<movie>(.*?)</movie>";  
			Pattern pattern2 = Pattern.compile(regx2);
			Matcher movieMatcher = pattern2.matcher(newdatabase);		
			while(movieMatcher.find())
			{
				movieContent += movieMatcher.group(1)+ System.lineSeparator();
			}
			String[] movies = movieContent.split(System.getProperty("line.separator"));

			Database movieDatabase = MainModel.getDatabaseEntity();
			String[] titles = movieDatabase.movies.stream()
					.map(Movie::getTitle).toArray(String[]::new);

			String titleResult = "Search Keyword: "+searchkeyword + System.lineSeparator();
			String  movieResult = "Matched Movie: "+searchkeyword + System.lineSeparator();
			String  movieKws = "Keywords of matched movie: "+searchkeyword + System.lineSeparator();
			
			for(String title:titles) 
			{
				if(title.indexOf(searchkeyword)!= -1) 
					{
					
						// display matched title in textarea
						titleResult+= title + System.lineSeparator();
						view.getSearchResults().setText(titleResult);
						
						// search movie by matched title
						for(String movie:movies) 
						{
							if(movie.indexOf(title)!= -1) 
							{
								movieResult+=movie+ System.lineSeparator();
								
								//get all keywords of matched movie
								Matcher movieKwsMatcher = pattern.matcher(movie);
								while(movieKwsMatcher.find()) 
								{
									movieKws += movieKwsMatcher.group(1)+ System.lineSeparator();
								}
								
								String[] movieKeywords = movieKws.split(System.getProperty("line.separator"));

								List<String> list = new ArrayList<String>();
								//get each keyword's occurrences in database keywords content
								for(String movieKeyword:movieKeywords) 
								{	
									String[] eachKeywords = movieKeyword.split(System.lineSeparator());
									for(String eachKeyword:eachKeywords ) 
									{
										int count = 0;
									    int index = 0;
									    while ((index = kwsContent.indexOf(eachKeyword, index)) != -1) {
									        index = index + eachKeyword.length();
									        count++;   
									    }
									
										// store the each keyword and it's occurrences in hashtable
									    countTable.put(eachKeyword, count);
									    System.out.println("keyword : "+eachKeyword);
										System.out.println("count : "+countTable.get(eachKeyword));
									}								

								}
										
							}
							
						}

						MainModel.setCorrelatedKeywords(countTable);
						Hashtable visualTable = MainModel.getCorrelatedKeywords();

//						MainModel.setKwsContent(kwsinfo);
						
						
					}
			}
			
		}
	}
}
