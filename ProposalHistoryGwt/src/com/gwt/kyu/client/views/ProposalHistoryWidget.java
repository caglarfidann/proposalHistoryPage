package com.gwt.kyu.client.views;

import java.util.ArrayList;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.gwt.kyu.client.presenters.ProposalHistoryPresenter;
import com.gwt.kyu.client.widgets.ButtonImageCell;
import com.gwt.kyu.shared.ProposalHistory;

public class ProposalHistoryWidget extends Composite implements ProposalHistoryPresenter.Display{
	private ProposalHistoryPresenter historyPresenter;
	private static ProposalHistoryWidgetUiBinder uiBinder = GWT
			.create(ProposalHistoryWidgetUiBinder.class);

	interface ProposalHistoryWidgetUiBinder extends
			UiBinder<Widget, ProposalHistoryWidget> {
	}

	public ProposalHistoryWidget() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	@UiField
	AbsolutePanel mainPanel;
	@UiField
	AbsolutePanel historyPanel;
	@UiField
	AbsolutePanel tablePanel;
	@UiField
	HorizontalPanel infoPanel;
	@UiField
	Label historyLabel;
	@UiField
	Label commentLabel;
	@UiField
	Label detailLabel;
	@UiField
	Label docLabel;
	@UiField
	Image commentImg;
	@UiField
	Image detailImg;
	@UiField
	Image docImg;
	@UiField
	CellTable<ProposalHistory> proposalHistoryTable;
	@UiField
	SimplePager simplePager;
	@UiField
	HorizontalPanel pagerPanel;
	@UiField
	HorizontalPanel footerPanel;
	@UiField
	Button cikButton;
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		proposalHistoryTable.setRowCount(0);
	}
	private Label proposalLabel=new Label("Teklif Tarihcesi");
	@Override
	public void setPresenter(ProposalHistoryPresenter historyPresenter) {
		// TODO Auto-generated method stub
		this.historyPresenter=historyPresenter;
	}

	@Override
	public void fillWidget(HasWidgets container) {
		// TODO Auto-generated method stub
		int width=Window.getClientWidth();
		int height=Window.getClientHeight();
		mainPanel = new AbsolutePanel();
		mainPanel.setSize(String.valueOf(width)+"px",String.valueOf(height)+"px");
		mainPanel.addStyleName("gwt-Style-MainPanel");
		
		mainPanel.add(historyLabel);
		historyLabel.addStyleName("gwt-Style-TitleLabel");
		
		historyPanel.add(proposalLabel);
		proposalLabel.addStyleName("gwt-Style-TeklifLabel");
		mainPanel.add(historyPanel);
		historyPanel.setWidth(String.valueOf((width/2)+250)+"px");
		historyPanel.addStyleName("gwt-Style-HistoryPanel");
		mainPanel.add(infoPanel);
		
		infoPanel.addStyleName("gwt-Style-InfoPanel");
		infoPanel.setWidth(String.valueOf((width/2)+250)+"px");
		commentImg.setUrl("/image/seeComment.png");
		commentLabel.setText("Gorus ve Yorumlar");
		
		detailImg.setUrl("/image/seeDetail.png");
		detailLabel.setText("Surec Detaylarini Goster");
		detailLabel.addStyleName("gwt-Style-InfoLabel");
		docImg.setUrl("/image/seeDoc.png");
		docLabel.setText("Dokumani Goster");
		docLabel.addStyleName("gwt-Style-InfoLabel");
		commentImg.setSize("20px","20px");
		detailImg.setSize("20px","20px");
		docImg.setSize("20px","20px");
		proposalHistoryTable.setWidth(String.valueOf((width/2)+250)+"px");
		tablePanel.addStyleName("gwt-Style-TablePanel");
		tablePanel.setWidth(String.valueOf((width/2)+250)+"px");
		pagerPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		pagerPanel.setWidth(String.valueOf((width/2)+250)+"px");
		pagerPanel.add(simplePager);
		mainPanel.add(tablePanel);
		footerPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		footerPanel.addStyleName("gwt-Style-FooterPanel");
		footerPanel.setWidth(String.valueOf((width/2)+250)+"px");
		footerPanel.add(cikButton);
		cikButton.addStyleName("gwt-Style-ExitButton");
		mainPanel.add(footerPanel);
		container.add(mainPanel);
	}

	@Override
	public void fillHistoryTable(ArrayList<ProposalHistory> historyList) {
		// TODO Auto-generated method stub
		TextColumn<ProposalHistory> SiraNo = new TextColumn<ProposalHistory>() {
			@Override
			public String getValue(ProposalHistory object) {
				return object.getSiraNo();
			}
		};
		TextColumn<ProposalHistory> TeklifNo = new TextColumn<ProposalHistory>() {
			@Override
			public String getValue(ProposalHistory object) {
				return object.getTeklifNo();
			}
		};
		TextColumn<ProposalHistory> Durum = new TextColumn<ProposalHistory>() {
			@Override
			public String getValue(ProposalHistory object) {
				return object.getDurum();
			}
		};
		TextColumn<ProposalHistory> SubeTeklifGiris = new TextColumn<ProposalHistory>() {
			@Override
			public String getValue(ProposalHistory object) {
				return object.getTeklifGirisTarih();
			}
		};
		TextColumn<ProposalHistory> SubeOnayTarih = new TextColumn<ProposalHistory>() {
			@Override
			public String getValue(ProposalHistory object) {
				return object.getSubeOnayTarihi();
			}
		};
		TextColumn<ProposalHistory> OnayTarih = new TextColumn<ProposalHistory>() {
			@Override
			public String getValue(ProposalHistory object) {
				return object.getOnayTarihi();
			}
		};
		TextColumn<ProposalHistory> RetTarih = new TextColumn<ProposalHistory>() {
			@Override
			public String getValue(ProposalHistory object) {
				return object.getRetTarihi();
			}
		};
		TextColumn<ProposalHistory> SarfinazarTarih = new TextColumn<ProposalHistory>() {
			@Override
			public String getValue(ProposalHistory object) {
				return object.getSarfinazarTarihi();
			}
		};
		TextColumn<ProposalHistory> SonOnaylayanKullanici = new TextColumn<ProposalHistory>() {
			@Override
			public String getValue(ProposalHistory object) {
				return object.getSonOnaylayanKullanici();
			}
		};
		TextColumn<ProposalHistory> ReddedenKullanici = new TextColumn<ProposalHistory>() {
			@Override
			public String getValue(ProposalHistory object) {
				return object.getReddedenKullanici();
			}
		};
		TextColumn<ProposalHistory> SarfinazarEdenKullanici = new TextColumn<ProposalHistory>() {
			@Override
			public String getValue(ProposalHistory object) {
				return object.getSarfinazarEdenKullanici();
			}
		};
		Column<ProposalHistory, String> imageSeeDoc = new Column<ProposalHistory, String>(
				new ButtonImageCell()) {
			@Override
			public String getValue(ProposalHistory object) {
				return "/image/seeDoc.png";
			}
		};
		imageSeeDoc.setFieldUpdater(new FieldUpdater<ProposalHistory, String>() {
			public void update(int index, ProposalHistory object, String value) {
				Window.alert("See Doc :"+object.getTeklifNo());
			}
		});
		Column<ProposalHistory, String> imageDetail = new Column<ProposalHistory, String>(
				new ButtonImageCell()) {
			@Override
			public String getValue(ProposalHistory object) {
				return "/image/seeDetail.png";
			}
		};
		imageDetail.setFieldUpdater(new FieldUpdater<ProposalHistory, String>() {
			public void update(int index, ProposalHistory object, String value) {
				Window.alert("See Detail :"+object.getTeklifNo());
			}
		});
		Column<ProposalHistory, String> imageComment = new Column<ProposalHistory, String>(
				new ButtonImageCell()) {
			@Override
			public String getValue(ProposalHistory object) {
				return "/image/seeComment.png";
			}
		};
		imageComment.setFieldUpdater(new FieldUpdater<ProposalHistory, String>() {
			public void update(int index, ProposalHistory object, String value) {
				Window.alert("See Comment :"+object.getTeklifNo());
			}
		});
		proposalHistoryTable.addColumn(SiraNo, "Sira No");
		proposalHistoryTable.addColumn(TeklifNo, "Teklif No");
		proposalHistoryTable.addColumn(Durum, "Durum");
		proposalHistoryTable.addColumn(SubeTeklifGiris, "Sube Teklif Giris Tarihi");
		proposalHistoryTable.addColumn(SubeOnayTarih, "Sube Onay Tarihi");
		proposalHistoryTable.addColumn(OnayTarih, "Onay Tarihi");
		proposalHistoryTable.addColumn(RetTarih, "Ret Tarihi");
		proposalHistoryTable.addColumn(SarfinazarTarih, "Sarfinazar Tarihi");
		proposalHistoryTable.addColumn(SonOnaylayanKullanici, "Son Onaylayan Kullanici");
		proposalHistoryTable.addColumn(ReddedenKullanici, "Reddeden Kullanici");
		proposalHistoryTable.addColumn(SarfinazarEdenKullanici, "Sarfinazar Eden Kullanici");
		proposalHistoryTable.addColumn(imageSeeDoc, SafeHtmlUtils.fromSafeConstant("<br/>"));
		proposalHistoryTable.addColumn(imageDetail, SafeHtmlUtils.fromSafeConstant("<br/>"));
		proposalHistoryTable.addColumn(imageComment, SafeHtmlUtils.fromSafeConstant("<br/>"));
		proposalHistoryTable.setRowCount(historyList.size(), true);
		proposalHistoryTable.setRowData(0, historyList);
		ListDataProvider<ProposalHistory> dataProvider = new ListDataProvider<ProposalHistory>();
		dataProvider.addDataDisplay(proposalHistoryTable);
	    dataProvider.setList(historyList);
	    simplePager.setDisplay(proposalHistoryTable);
	    simplePager.setPageSize(7);
	}

	@Override
	public Button exitButton() {
		// TODO Auto-generated method stub
		return cikButton;
	}
}
