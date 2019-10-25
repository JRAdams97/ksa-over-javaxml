package com.ksa.controller;

import java.util.Hashtable;
import java.util.Set;

import com.ksa.model.MainModel;
import com.ksa.view.VisualizationView;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class VisualizationController implements EventHandler {

	private final Stage stage;
	private final VisualizationView view = new VisualizationView(this);

	public Stage getStage() {
		return stage;
	}

	public VisualizationView getView() {
		return view;
	}

	public VisualizationController(Stage primaryStage) {
		this.stage = primaryStage;
	}
	
	@Override
	public void handle(final Event event) {
		final Object source = event.getSource();
		Hashtable visualTable = MainModel.getCorrelatedKeywords();
		System.out.println(visualTable);
		Set<String> keys = visualTable.keySet();
		
		if(source.equals(view.getTop3Keywords()))
				{
					for(String key: keys) {
						System.out.println(key+"--"+visualTable.get(key));
			    }
			
				}
	    
		
		
		
		
		
	}
	
	
	
	
}
