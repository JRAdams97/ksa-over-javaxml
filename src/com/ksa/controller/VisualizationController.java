package com.ksa.controller;

import com.ksa.model.MainModel;
import com.ksa.model.VisualizationModel;
import com.ksa.view.VisualizationView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This controller handles events and user actions that execute on the 'Visualization'
 * page of the application. It contains a reference to the application  {@link Stage}.
 * References the MVC pattern by aggregating an associated {@code view} ({@link VisualizationView}) 
 * @author jradams97
 * @author tianlu102238612
 * @version 0.3
 */
public class VisualizationController implements EventHandler {

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//  Fields
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Reference to application stage.
	 */
	private final Stage stage;
	
	/**
	 * Associated view. Provided a controller instance on initialization.
	 */
	private final VisualizationView view = new VisualizationView(this);
	private final VisualizationModel model = new VisualizationModel(this);

	private HashMap<String, Integer> top3Keywords = new HashMap<>();
	
	/**
	 * initialize a String Array to store top keywords
	 */
	private String[] topKeyword = new String[10];
	
	/**
	 * initialize the number of top keywords
	 */
	private int count = 0;
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//  Accessors and Mutators
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public Stage getStage() {
		return stage;
	}

	public VisualizationView getView() {
		return view;
	}

	public VisualizationController(Stage primaryStage) {
		this.stage = primaryStage;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//  Methods
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Method to sort HashMap by value in descending order
	 * @param hashmap 	The HashMap need to be sorted
	 * @return tempMap	A temp HashMap to store key value pair in descending order by value
	 */
	
	 public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hashmap) 
	    { 
	        // Create a list from elements of HashMap 
	        List<Map.Entry<String, Integer> > keyValueList = 
	               new LinkedList<Map.Entry<String, Integer> >(hashmap.entrySet()); 
	        		// Sort the list 
	        		Collections.sort(keyValueList, new Comparator<Map.Entry<String, Integer> >() 
	        		{ 
	        			public int compare(Map.Entry<String, Integer> o2,Map.Entry<String, Integer> o1) 
	        				{ 
	        					return (o1.getValue()).compareTo(o2.getValue()); 
	        				} 
	        		}); 
	  
	        		// put data from sorted list to hashmap  
	        		HashMap<String, Integer> tempMap = new LinkedHashMap<String, Integer>(); 
	        
	        		for (Map.Entry<String, Integer> keyvalue : keyValueList) 
	        		{ 
	        			tempMap.put(keyvalue.getKey(), keyvalue.getValue()); 
	        		} 
	        		return tempMap; 
	      } 
	 


	 /**
	 *Overridden implementation of {@link EventHandler#handle(Event)} that
	 * determines actions to perform when user actions are performed.
	 * {@code top3Keywords} is handled to get only the first three key in the keySet() of sortedMap
	 * {@code top5Keywords} is handled to get only the first five key in the keySet() of sortedMap
	 * {@code top8Keywords} is handled to get only the first three key in the keySet() of sortedMap
	 * {@code top10Keywords} is handled to get only the first three key in the keySet() of sortedMap
	 * {@code barChartBtn} is handled to draw a bar chart in {@code chartPanel},
	 * @param event  Obtained from the {@link javafx.event.EventDispatcher}.
	 *               Defines a "notification" when a specific action occurs.
	 */
	@Override
	public void handle(final Event event) {
		
		final Object source = event.getSource();

		HashMap<String, Integer> visualTable = MainModel.getCorrelatedKeywords();
		HashMap<String, Integer> sortedMap = sortByValue(visualTable);
		Set<String> keywords = sortedMap.keySet();
	
		if(source.equals(view.getTop3Keywords())) 
		{
			for(String keyword:keywords) 
			{
				if(count>2) 
				{
					break;
				}
				count++;
				topKeyword[count]=keyword;
				System.out.println(topKeyword[count]);
				System.out.println(sortedMap.get(keyword));
			}
		}else if(source.equals(view.getTop5Keywords())) 
		{
			for(String keyword:keywords) 
			{
				if(count>4) 
				{
					break;
				}
				count++;
				topKeyword[count]=keyword;
				System.out.println(topKeyword[count]);
				System.out.println(sortedMap.get(keyword));
			}
		}else if(source.equals(view.getTop8Keywords())) 
		{
			for(String keyword:keywords) 
			{
				if(count>7) 
				{
					break;
				}
				count++;
				topKeyword[count]=keyword;
				System.out.println(topKeyword[count]);
				System.out.println(sortedMap.get(keyword));
			}
		}else if(source.equals(view.getTop10Keywords())) 
		{
			for(String keyword:keywords) 
			{
				if(count>9) 
				{
					break;
				}
				count++;
				topKeyword[count]=keyword;
				System.out.println(topKeyword[count]);
				System.out.println(sortedMap.get(keyword));
			}
		} else if (source.equals(view.getPieChartBtn())) {
			if (model.isChartVisible()) {
				view.removeChart();
			}

			HashMap pieChartData = prepareData();
			view.buildPieChart(pieChartData);

			model.setChartVisible(true);
		} else if(source.equals(view.getBarChartBtn())) 
		{
			if (model.isChartVisible()) {
				view.removeChart();
			}

			CategoryAxis xaxis = new CategoryAxis();
			NumberAxis yaxis = new NumberAxis(0,10,1);
			xaxis.setLabel("Keyword");
			yaxis.setLabel("Frequency");
			BarChart<String,Double> keywordBar = new BarChart(xaxis,yaxis);
			keywordBar.setTitle("Keyword Frequency Barchart");
			
			for(int i=1;i<count+1;i++) 
			{
				XYChart.Series<String,Double> series = new XYChart.Series<>();
				series.getData().add(new XYChart.Data(topKeyword[i],sortedMap.get(topKeyword[i]) ));
				keywordBar.getData().add(series);
				System.out.print(topKeyword[i]);
			}
			this.view.getChildren().add(keywordBar);
			
		}	
	}
	
  private HashMap<String, Double> prepareData() {
		Integer totalKeywords = MainModel.getTotalKeywords();
		HashMap<String, Double> keywordPortionData = new HashMap<>();
		HashMap<String, Integer> correlatedKeywords;

		if (top3Keywords != null) {
			correlatedKeywords = top3Keywords;
		} else {
			correlatedKeywords = MainModel.getCorrelatedKeywords();
		}

		Set<String> keys = correlatedKeywords.keySet();
		double keywordPortion;

		while (keys.iterator().hasNext()) {
			String key = keys.iterator().next();
			keywordPortion = (double) correlatedKeywords.get(key) / totalKeywords;

			keywordPortionData.put(key, keywordPortion);
		}

		return keywordPortionData;
	}
}
