package dad.javafx.geometria.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.SimpleDoubleProperty;

public class HexagonoModel {
	private DoubleProperty apotema;

	private ReadOnlyDoubleWrapper area;

	public HexagonoModel(Double apotema) {
		this.apotema = new SimpleDoubleProperty(this, "apotema", apotema);
		
		this.area = new ReadOnlyDoubleWrapper(this, "area");
		
		/*
		 * EXPLICACION DE LA FORMULA:
		 * 
		 * En el siguiente ejercicio se nos dispone el c�lculo del área de un hexágono que debe ser "geométricamente
		 * sim�trico", por lo que en consideraci�n con este punto, tanto la apotema como el lado son considerados iguales.
		 * 
		 * La formula es: A= (P*a)/2 => (6(t)*a)/2
		 * 
		 * A = area
		 * P = perimetro
		 * a = longuitud de la apotema
		 * 6 hace referencia al n�mero de lados
		 * t = longitud de cada lado
		 * 
		 * */
		
		// Esta sería la fórmula del área extendida
		this.area.bind( ((this.apotema.multiply(6).divide(2)).multiply(this.apotema)).divide(2) );
		
		
	}

	public HexagonoModel() {
		this(0.0);
	}

	public DoubleProperty apotemaProperty() {
		return this.apotema;
	}

	public double getApotema() {
		return this.apotemaProperty().get();
	}

	public void setBase(final double apotema) {
		this.apotemaProperty().set(apotema);
	}

	public javafx.beans.property.ReadOnlyDoubleProperty areaProperty() {
		return this.area.getReadOnlyProperty();
	}

	public double getArea() {
		return this.areaProperty().get();
	}	

}
