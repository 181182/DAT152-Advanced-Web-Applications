package no.hvl.dat152.modell;

public class Handlekurv {

	public Vare vare[];
	public int antall;
	
	public Handlekurv() {
		antall = 0;
		vare = new Vare[10];
	}
	
	public void addVare(Vare v) {
		vare[antall] = v;
		antall++;
	}
	
	
	
}
