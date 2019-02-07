package no.hvl.dat152.modell;

public class Beskrivelse {

	public String landKode;
	public String text;
	
	public Beskrivelse() {
		landKode = "";
		text = "";
	}
	public Beskrivelse(String l, String t) {
		landKode = l;
		text = t;
	}
	public String getLandKode() {
		return landKode;
	}
	public void setLandKode(String landKode) {
		this.landKode = landKode;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
