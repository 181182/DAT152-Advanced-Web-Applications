package no.hvl.dat152.modell;

public class Vare {
	
	private String navn;
	private Beskrivelse beskrivelse[];
	private float pris;
	private String imgFile;
	
	public Vare() {
		navn = "";
		beskrivelse = new Beskrivelse[2];
		pris = 0;
		imgFile = "";
	}
	public Vare(String n, Beskrivelse[] b, float p, String i) {
		navn = n;
		beskrivelse = b;
		pris = p;
		imgFile = i;
	}
	
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public Beskrivelse[] getBeskrivelse() {
		return beskrivelse;
	}
	public void setBeskrivelse(Beskrivelse beskrivelse[]) {
		this.beskrivelse = beskrivelse;
	}
	public float getPris() {
		return pris;
	}
	public void setPris(float pris) {
		this.pris = pris;
	}
	public String getImgFile() {
		return imgFile;
	}
	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}
	
	
}
