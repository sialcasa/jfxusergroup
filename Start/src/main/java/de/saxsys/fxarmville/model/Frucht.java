package de.saxsys.fxarmville.model;

import javafx.animation.SequentialTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.Image;
import de.saxsys.fxarmville.model.util.FruchtBildLader;

public class Frucht {

	// Zeit für Reifung / Faulung
	private final DoubleProperty reifedauerProperty = new SimpleDoubleProperty();

	// Aktuelle Reifedauer
	private final DoubleProperty aktuelleReifeDauerProperty = new SimpleDoubleProperty();

	/*
	 * Lebensabschnitte
	 */
	private final BooleanProperty istReifProperty = new SimpleBooleanProperty();
	private final BooleanProperty istFauligProperty = new SimpleBooleanProperty();
	private final BooleanProperty istEingegangenProperty = new SimpleBooleanProperty();
	private final BooleanProperty istGeerntetWordenProperty = new SimpleBooleanProperty();

	private final LebensZyklus lebensZyklus = new LebensZyklus();
	private final String bildName;

	public Frucht(String bildName, double reifedauer) {
		this.bildName = bildName;
		reifedauerProperty.set(reifedauer);
	}

	public Image getBild() {
		return FruchtBildLader.getInstance().getBild(bildName);
	}

	public void baueAn() {
		// FIXME
	}

	public void ernten() {
		lebensZyklus.ernten();
		istGeerntetWordenProperty.set(true);
	}

	/*
	 * WACHSDAUER
	 */
	public ReadOnlyDoubleProperty wachsdauerProperty() {
		return reifedauerProperty;
	}

	public double getWachsdauer() {
		return reifedauerProperty.get();
	}

	/*
	 * REIFEGRAD
	 */
	public double getReifegrad() {
		return aktuelleReifeDauerProperty.get();
	}

	public ReadOnlyDoubleProperty reifegradProperty() {
		return aktuelleReifeDauerProperty;
	}

	/*
	 * AKTUELLER ZUSTAND
	 */

	public ReadOnlyBooleanProperty istReifProperty() {
		return istReifProperty;
	}

	public ReadOnlyBooleanProperty istFauligProperty() {
		return istFauligProperty;
	}

	public ReadOnlyBooleanProperty istEingegangenProperty() {
		return istEingegangenProperty;
	}

	public ReadOnlyBooleanProperty istGeerntetWordenProperty() {
		return istGeerntetWordenProperty;
	}

	/**
	 * Private Klasse welche den Lebenszyklus einer Frucht abbildet.
	 * 
	 * @author sialcasa
	 * 
	 */
	private class LebensZyklus {

		private SequentialTransition lebensZyklus;

		public void wachse() {
			// FIXME
			// Wachstum
			// Zeit, wann die Frucht reif ist

			// Faulen der Frucht

			// Leben starten
		}

		public void ernten() {
			lebensZyklus.stop();
		}
	}
}
