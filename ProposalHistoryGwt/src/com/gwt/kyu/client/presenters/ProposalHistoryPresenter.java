package com.gwt.kyu.client.presenters;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.kyu.shared.ProposalHistory;

public class ProposalHistoryPresenter implements Presenter {

	Display view;
	ArrayList<ProposalHistory> historyList;
	public interface Display{
		public void clear();
		public Widget asWidget();
		public void setPresenter(ProposalHistoryPresenter historyPresenter);
		public void fillWidget(HasWidgets container);
		public void fillHistoryTable(ArrayList<ProposalHistory> historyList);
		public Button exitButton();
		
	}
	public ProposalHistoryPresenter(ArrayList<ProposalHistory> historyList,Display view) {
	// TODO Auto-generated constructor stub
		this.historyList=historyList;
		this.view=view;
		bind();
	}
	@Override
	public void bind() {
		// TODO Auto-generated method stub
		view.clear();
		view.setPresenter(this);
		view.fillHistoryTable(historyList);
	}

	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		container.clear();
		container.add(view.asWidget());
		view.fillWidget(container);
	}

}
