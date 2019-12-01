package dad.javafx.geometria.controllers;

import dad.javafx.geometria.model.TrianguloModel;
import dad.javafx.geometria.polygon.Triangle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.converter.NumberStringConverter;

public class TrianguloController extends VBox {
	
	// view
	
	private TextField baseText;
	private TextField alturaText;	
	private Label areaLabel;
	private Triangle trianguloPolygon;
	
	// model
	
	private TrianguloModel trianguloModel = new TrianguloModel(30.0, 50.0);

	public TrianguloController() {
		
		super();

		baseText = new TextField();
		baseText.setPrefColumnCount(5);
		
		HBox baseBox = new HBox(5, new Label("Base:"), baseText);
		baseBox.setAlignment(Pos.BASELINE_CENTER);
		HBox.setMargin(baseText, new Insets(10, 0, 0, 0));

		alturaText = new TextField();
		alturaText.setPrefColumnCount(5);
		
		HBox alturaBox = new HBox(5, new Label("Altura:"), alturaText);
		alturaBox.setAlignment(Pos.BASELINE_CENTER);
		
		// área
		
		areaLabel = new Label();
		HBox areaBox = new HBox(5, new Label("Área:"), areaLabel);
		areaBox.setAlignment(Pos.BASELINE_CENTER);

		trianguloPolygon = new Triangle();
		trianguloPolygon.setFill(Color.BLACK);
		trianguloPolygon.setStroke(Color.RED);
		trianguloPolygon.setStrokeWidth(2);
		
		this.setSpacing(10);
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(baseBox, alturaBox, trianguloPolygon, areaBox);
		this.setPadding(new Insets(5));
		
		// vista-modelo bindeos
		
		baseText.textProperty().bindBidirectional(trianguloModel.baseProperty(), new NumberStringConverter());
		alturaText.textProperty().bindBidirectional(trianguloModel.alturaProperty(), new NumberStringConverter());
		
		areaLabel.textProperty().bind(trianguloModel.areaProperty().asString());
		
		trianguloPolygon.baseProperty().bind(trianguloModel.baseProperty());
		trianguloPolygon.heightProperty().bind(trianguloModel.alturaProperty());
		

	}
	
}
