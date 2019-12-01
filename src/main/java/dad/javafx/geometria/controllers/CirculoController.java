package dad.javafx.geometria.controllers;

import dad.javafx.geometria.model.CirculoModel;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.converter.NumberStringConverter;

public class CirculoController extends VBox {

	// view

	private TextField radioText;
	private Label areaLabel;
	private Circle circuloPolygon;

	// model

	private CirculoModel circuloModel = new CirculoModel(20.0);

	public CirculoController() {
		super();

		radioText = new TextField();
		radioText.setMaxWidth(50);

		HBox radioBox = new HBox(5, new Label("Radio:"), radioText);
		radioBox.setAlignment(Pos.BASELINE_CENTER);

		circuloPolygon = new Circle();
		circuloPolygon.setFill(Color.BLACK);
		circuloPolygon.setStroke(Color.RED);
		circuloPolygon.setStrokeWidth(2);

		// area y perimetro añadido

		areaLabel = new Label();
		HBox areaBox = new HBox(5, new Label("Área:"), areaLabel);
		areaBox.setAlignment(Pos.BASELINE_CENTER);

		this.setSpacing(5);
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(radioBox, circuloPolygon, areaBox);
		this.setSpacing(10);

		// vista-modelo bindeos

		radioText.textProperty().bindBidirectional(circuloModel.radioProperty(), new NumberStringConverter());
		circuloPolygon.radiusProperty().bind(circuloModel.radioProperty());

		areaLabel.textProperty().bind(Bindings.format("%,.2f", circuloModel.areaProperty()));

	}

}
