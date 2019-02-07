package no.hvl.dat152;

import java.io.IOException;
import java.io.StringWriter;
import java.time.Year;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Forkorter extends SimpleTagSupport {
	private String tekst;
	
	@Override
	public void doTag() throws IOException, JspException{
		JspWriter out = getJspContext().getOut();
		StringWriter innleser = new StringWriter();
		getJspBody().invoke(innleser);
		tekst = innleser.toString();
		if(tekst.length() > 24) {
			out.print(tekst.substring(0, 24) + "...");
		}
		else {
			out.print(tekst);
		}
	}
	
}
