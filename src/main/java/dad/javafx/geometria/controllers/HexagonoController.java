package dad.javafx.geometria.controllers;

import dad.javafx.geometria.model.HexagonoModel;
import dad.javafx.geometria.polygon.Hexagon;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.converter.NumberStringConverter;

public class HexagonoController extends VBox {
	
	// view
	
	private TextField radioText;
	private Hexagon hexagonPolygon;	
	private Label areaLabel;
	
	// model
	
	private HexagonoModel hexagonoModel = new HexagonoModel(20.0);

	public HexagonoController() {
		super();
		
		radioText = new TextField();
		radioText.setMaxWidth(50);
		
		HBox radioBox = new HBox(5, new Label("Apotema:"), radioText);
		radioBox.setAlignment(Pos.BASELINE_CENTER);
		
		// area y perimetro añadido
		
		areaLabel = new Label();
		HBox areaBox = new HBox(5, new Label("Área:"), areaLabel);
		areaBox.setAlignment(Pos.BASELINE_CENTER);
		
		hexagonPolygon = new Hexagon();
		hexagonPolygon.setFill(Color.BLACK);
		hexagonPolygon.setStroke(Color.RED);
		hexagonPolygon.setStrokeWidth(2);
		
		this.setSpacing(5);
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(radioBox, hexagonPolygon, areaBox);
		this.setSpacing(10);
		
		// vista-modelo bindeos
		
		radioText.textProperty().bindBidirectional(hexagonoModel.apotemaProperty(), new NumberStringConverter());
		hexagonPolygon.radiusProperty().bind(hexagonoModel.apotemaProperty());	
		
		areaLabel.textProperty().bind(Bindings.format("%,.2f",hexagonoModel.areaProperty()));
		
		
	}
	
}
