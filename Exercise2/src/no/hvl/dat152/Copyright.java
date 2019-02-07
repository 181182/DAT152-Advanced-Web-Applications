package no.hvl.dat152;

import java.io.IOException;
import java.time.Year;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import no.hvl.dat152.Converter;

public class Copyright extends SimpleTagSupport {
	private int since;

	@Override
	public void doTag() throws IOException, JspException {
		JspWriter out = getJspContext().getOut();
		out.print("© " + Converter.convert(since) + "-" + Converter.convert(Year.now().getValue()) + " ");
		getJspBody().invoke(null);
	}

	public void setSince(String since) {
		try {
			this.since = Integer.parseInt(since);
		} catch (Exception e) {
			this.since = 1;
		}
	}
}
