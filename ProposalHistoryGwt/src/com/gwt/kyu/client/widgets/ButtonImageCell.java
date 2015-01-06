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
//	        SafeHtml html = SafeHtmlUtils.fromTrustedString(new Image(value).toString());
//	        sb.append(html);	 
		//String icon = "/image/seeDetail.png";
      Image image = new Image(value);
      image.setSize("20px", "20px");
      //fix the mouse pointer   
      image.getElement().getStyle().setCursor(Cursor.POINTER);
      //Do something with the DATA
      //image.setTitle("Delete " + data.asString());
      SafeHtml html = SafeHtmlUtils.fromTrustedString(image.toString());
      sb.append(html);
		 
	    }

}
