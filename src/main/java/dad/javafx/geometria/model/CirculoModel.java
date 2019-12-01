package dad.javafx.geometria.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.SimpleDoubleProperty;

import static java.lang.Math.PI;

public class CirculoModel {
	private DoubleProperty radio;
	private ReadOnlyDoubleWrapper area;

	public CirculoModel(Double radio) {
		this.radio = new SimpleDoubleProperty(this, "radio", radio);
		
		this.area = new ReadOnlyDoubleWrapper(this, "area");
		this.area.bind( (this.radio.multiply(this.radio)).multiply(PI) );

	}

	public CirculoModel() {
		this(0.0);
	}

	public DoubleProperty radioProperty() {
		return this.radio;
	}


	public javafx.beans.property.ReadOnlyDoubleProperty areaProperty() {
		return this.area.getReadOnlyProperty();
	}

	public double getArea() {
		return this.areaProperty().get();
	}

}
