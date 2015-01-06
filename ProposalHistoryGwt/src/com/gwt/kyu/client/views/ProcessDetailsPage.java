package com.gwt.kyu.client.views;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.kyu.shared.ProcessDetail;

public class ProcessDetailsPage extends DialogBox {

	private static ProcessDetailsPageUiBinder uiBinder = GWT
			.create(ProcessDetailsPageUiBinder.class);

	interface ProcessDetailsPageUiBinder extends
			UiBinder<Widget, ProcessDetailsPage> {
	}
	ArrayList<ProcessDetail> detailArray;
	private Label detailLabel=new Label("Surec Detaylari");
	public ProcessDetailsPage(ArrayList<ProcessDetail> detailArray) {
		setWidget(uiBinder.createAndBindUi(this));
		this.detailArray=detailArray;
		onInitialize(this);
	}
	@UiField
	AbsolutePanel absolutePanel;
	@UiField
	AbsolutePanel historyPanel;
	@UiField
	AbsolutePanel tablePanel;
	@UiField
	HorizontalPanel footerPanel;
	@UiField
	Button exitButton;
	@UiField
	CellTable<ProcessDetail> detailTable;
	
	public void onInitialize(final DialogBox box){	
		box.center();
		box.setPopupPositionAndShow(new PopupPanel.PositionCallback() {
	          public void setPosition(int offsetWidth, int offsetHeight) {
	            int left = (Window.getClientWidth() - offsetWidth) / 3;
	            int top = (Window.getClientHeight() - offsetHeight) / 3;
	            box.setPopupPosition(left, top);
	          }
	        });
		box.setStyleName("gwt-Bold-DialogBox");
		box.setText("PROCESS DETAIL");
		absolutePanel.setSize("850px", "400px");
		historyPanel.add(detailLabel);
		detailLabel.addStyleName("gwt-Style-TeklifLabel");
		historyPanel.setWidth("840px");
		historyPanel.addStyleName("gwt-Style-DetailPanel");
		absolutePanel.add(historyPanel);
		tablePanel.setWidth("840px");
		tablePanel.addStyleName("gwt-Style-DetailTablePanel");
		fillTable();
		absolutePanel.add(tablePanel);
		footerPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		footerPanel.addStyleName("gwt-Style-InfoPanel");
		footerPanel.setWidth("800px");
		exitButton.addStyleName("gwt-Style-ExitButton");
		footerPanel.add(exitButton);
		absolutePanel.add(footerPanel);
		exitButton.addClickHandler(new ClickHandler() {		
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				box.hide();
				detailTable.setRowCount(0);
			}
		});
	}
	
	public void fillTable(){
		TextColumn<ProcessDetail> SiraNo = new TextColumn<ProcessDetail>() {
			@Override
			public String getValue(ProcessDetail object) {
				return object.getSiraNo();
			}
		};
		TextColumn<ProcessDetail> KullaniciKodu = new TextColumn<ProcessDetail>() {
			@Override
			public String getValue(ProcessDetail object) {
				return object.getKullaniciKodu();
			}
		};
		TextColumn<ProcessDetail> BaslangicTarih = new TextColumn<ProcessDetail>() {
			@Override
			public String getValue(ProcessDetail object) {
				return object.getBaslangicTarih();
			}
		};
		TextColumn<ProcessDetail> BitisTarih = new TextColumn<ProcessDetail>() {
			@Override
			public String getValue(ProcessDetail object) {
				return object.getBitisTarih();
			}
		};
		TextColumn<ProcessDetail> Sure = new TextColumn<ProcessDetail>() {
			@Override
			public String getValue(ProcessDetail object) {
				return object.getSure();
			}
		};
		TextColumn<ProcessDetail> Sonuc = new TextColumn<ProcessDetail>() {
			@Override
			public String getValue(ProcessDetail object) {
				return object.getSonuc();
			}
		};
		detailTable.addColumn(SiraNo, "Sira No");
		detailTable.addColumn(KullaniciKodu, "Kullanici Kodu");
		detailTable.addColumn(BaslangicTarih, "Baslangic Tarihi-Saati");
		detailTable.addColumn(BitisTarih, "Bitis Tarihi-Saati");
		detailTable.addColumn(Sure, "Sure");
		detailTable.addColumn(Sonuc, "Sonuc");
		detailTable.setRowCount(detailArray.size(), true);
		detailTable.setRowData(0, detailArray);
	}
}
