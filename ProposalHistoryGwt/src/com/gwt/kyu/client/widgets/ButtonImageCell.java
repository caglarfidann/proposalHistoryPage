package com.gwt.kyu.client.widgets;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.Image;

public class ButtonImageCell extends ButtonCell{
	 @Override
	    public void render(com.google.gwt.cell.client.Cell.Context context, 
	            String value, SafeHtmlBuilder sb) {
      Image image = new Image(value);
      image.setSize("20px", "20px");
      image.getElement().getStyle().setCursor(Cursor.POINTER);
      SafeHtml html = SafeHtmlUtils.fromTrustedString(image.toString());
      sb.append(html);
		 
	    }

}
