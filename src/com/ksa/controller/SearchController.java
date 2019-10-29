package com.ksa.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ksa.model.MainModel;
import com.ksa.model.SearchModel;
import com.ksa.model.entity.Database;
import com.ksa.model.entity.Movie;
import com.ksa.model.SourceModel;
import com.ksa.view.SearchView;
import com.ksa.view.SourceView;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * This controller handles events and user actions that execute on the 'Search'
 * page of the application. It contains a reference to the application
 * {@link Stage}. References the MVC pattern by aggregating an associated
 * {@code view} ({@link SearchView}) and {@code model} ({@link SearchModel})
 *
 * @author jradams97
 * @author tianlu102238612
 * @version 0.3
 */
public class SearchController implements EventHandler {
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//  Fields
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Reference to application stage.
	 */
	private Stage mainStage;
	
	/**
	 * Associated view. Provided a controller instance on initialization.
	 */
	private final SearchView view = new SearchView(this);
	
	/**
	 * Associated model. Provided a controller instance on initialization.
	 */
	private final SearchModel model = new SearchModel(this);

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//  Accessors and Mutators
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public Stage getMainStage() {
		return mainStage;
	}

	public SearchView getView() {
		return view;
	}

	public SearchModel getModel() {
		return model;
	}
	
	/**
	 * Class constructor. References the main stage of the application
	 *
	 * @param mainStage  Global stage used for all application classes.
	 */
	public SearchController(final Stage mainStage) {
		this.mainStage = mainStage;
	}
	
	
	/**
	 * Overridden implementation of {@link EventHandler#handle(Event)} that
	 * determines actions to perform when user actions are performed.
	 * {@code searchField} is handled to prompt for search keyword input
	 * {@code SearchBtn} is handled to prompt a search for title in database
	 * based on input keyword. The matched movie data is display it in the
	 * text area ({@code searchResults}) and stored in a global model
	 * ({@link MainModel}) for easy access on other scenes.
	 * @param event  Obtained from the {@link javafx.event.EventDispatcher}.
	 *               Defines a "notification" when a specific action occurs.
	 */
	@Override
	public void handle(final Event event) {
		Object source = event.getSource();

		if (source.equals(view.getSearchTitle())) {
			model.setSearchType(SearchModel.TITLE_SEARCH);
		} else if (source.equals(view.getSearchKeyword())) {
			model.setSearchType(SearchModel.KEYWORD_SEARCH);
		} else if (source.equals(view.getSearchBtn())) {
			String searchkeyword = view.getSearchField().getText();
			String database =  MainModel.getDatabaseContent();
			HashMap<String,Integer> countTable = new HashMap<String,Integer>();
			
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

			String[] movies;
			String movieContent = "";
			List<Movie> movieList = new ArrayList<>();

			if (SearchModel.KEYWORD_SEARCH.equals(model.getSearchType())) {
				 movieList = findMoviesByKeyword(searchkeyword);
				 movies = movieList.stream().map(Movie::getTitle).toArray(String[]::new);

				 for (int i = 0; i < movies.length; i++) {
					 movieContent += movies[i] + System.lineSeparator();
				 }

			} else {

				// get all movie content from database
				String newdatabase = database.replaceAll(System.lineSeparator(), "");
				String regx2 = "<movie>(.*?)</movie>";
				Pattern pattern2 = Pattern.compile(regx2);
				Matcher movieMatcher = pattern2.matcher(newdatabase);
				while (movieMatcher.find()) {
					movieContent += movieMatcher.group(1) + System.lineSeparator();
				}

				movies = movieContent.split(System.getProperty("line.separator"));
			}

			Database movieDatabase = MainModel.getDatabaseEntity();
			String[] titles = movieDatabase.getMovies().stream()
					.map(Movie::getTitle).toArray(String[]::new);

			String searchTerm = "Search Term: " + searchkeyword + System.lineSeparator();

			view.getSearchTermLbl().setText(searchTerm);

			String titleResult = "";
			String  movieResult = "Matched Movie: "+searchkeyword + System.lineSeparator();
			String  movieKws = "";

			for(String title:titles) {
				if(title.indexOf(searchkeyword) != -1 ||
						(SearchModel.KEYWORD_SEARCH.equals(model.getSearchType()) && matchesMovie(title, movieContent)))
					{

						// display matched title in textarea
						titleResult+= title + System.lineSeparator();
						view.getSearchResults().setText(titleResult);

						// search movie by matched title
						for(String movie:movies)
						{
							if(movie.indexOf(title)!= -1 ||
									(SearchModel.KEYWORD_SEARCH.equals(model.getSearchType()) && matchesMovie(title, movieContent)))
							{
								movieResult+=movie+ System.lineSeparator();

								//get all keywords of matched movie

								if (SearchModel.TITLE_SEARCH.equals(model.getSearchType())) {
									Matcher movieKwsMatcher = pattern.matcher(movie);
									while (movieKwsMatcher.find()) {
										movieKws += movieKwsMatcher.group(1) + System.lineSeparator();
									}
								} else {
									if (movieList != null) {
										String[] keywordArray = movieList.stream()
												.map(Movie::getKeywords)
												.flatMap(Collection::stream)
												.toArray(String[]::new);

										keywordArray = new HashSet<>(Arrays.asList(keywordArray)).toArray(new String[0]);

										for (int i = 0; i < keywordArray.length; i++) {
											movieKws += keywordArray[i] + System.lineSeparator();
										}
									}
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
					}
			}

			MainModel.setCorrelatedKeywords(countTable);
		}
	}

	private List<Movie> findMoviesByKeyword(String searchKeyword) {
		if (MainModel.getDatabaseEntity() != null) {
			Database database = MainModel.getDatabaseEntity();

			List<Movie> movies = database.getMovies().stream()
					.filter(movie -> movie.getKeywords().contains(searchKeyword))
					.collect(Collectors.toList());

			return movies;
		}

		return null;
	}

	private boolean matchesMovie(String title, String movieList) {
		String titleRegEx = title + System.lineSeparator();
		Pattern boundaryPattern = Pattern.compile(titleRegEx);
		Matcher matcher = boundaryPattern.matcher(movieList);

		return matcher.find();
	}
}
