package com.gwt.kyu.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwt.kyu.client.presenters.Presenter;
import com.gwt.kyu.client.presenters.ProposalHistoryPresenter;
import com.gwt.kyu.client.views.ProposalHistoryWidget;
import com.gwt.kyu.shared.ProposalHistory;


public class proposalHistoryEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		ProposalHistory history=new ProposalHistory();	
		Presenter presenter=new ProposalHistoryPresenter(history.addProposal(), new ProposalHistoryWidget());
		presenter.go(RootPanel.get());
	}

}
