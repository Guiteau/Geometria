package dad.javafx.geometria.controllers;

import dad.javafx.geometria.model.RectanguloModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.converter.NumberStringConverter;

public class RectanguloController extends VBox {
	
	// view
	
	private TextField anchoText;
	private TextField altoText;	
	private Label areaLabel;	
	private Rectangle rectanguloPolygon;
	
	// model
	
	private RectanguloModel rectanguloModel = new RectanguloModel(30.0, 50.0);

	public RectanguloController() {
		super();
		
		anchoText = new TextField();
		anchoText.setPrefColumnCount(5);
		
		HBox anchoBox = new HBox(5, new Label("Ancho:"), anchoText);
		anchoBox.setAlignment(Pos.BASELINE_CENTER);
		HBox.setMargin(anchoText, new Insets(10, 0, 0, 0));

		altoText = new TextField();
		altoText.setPrefColumnCount(5);
		
		HBox altoBox = new HBox(5, new Label("Alto:"), altoText);
		altoBox.setAlignment(Pos.BASELINE_CENTER);
				
		// área
		areaLabel = new Label();
		HBox areaBox = new HBox(5, new Label("Área:"), areaLabel);
		areaBox.setAlignment(Pos.BASELINE_CENTER);
		
		rectanguloPolygon = new Rectangle(100, 50);
		rectanguloPolygon.setFill(Color.BLACK);
		rectanguloPolygon.setStroke(Color.RED);
		rectanguloPolygon.setStrokeWidth(2);
		
		this.setSpacing(5);
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(anchoBox, altoBox, rectanguloPolygon, areaBox);
		this.setPadding(new Insets(5));
		this.setSpacing(10);
		
		// vista-modelo bindeos
		
		anchoText.textProperty().bindBidirectional(rectanguloModel.baseProperty(), new NumberStringConverter());
		altoText.textProperty().bindBidirectional(rectanguloModel.alturaProperty(), new NumberStringConverter());
		areaLabel.textProperty().bind(rectanguloModel.areaProperty().asString());
		
		rectanguloPolygon.widthProperty().bind(rectanguloModel.baseProperty());
		rectanguloPolygon.heightProperty().bind(rectanguloModel.alturaProperty());
		
	}
	
}
