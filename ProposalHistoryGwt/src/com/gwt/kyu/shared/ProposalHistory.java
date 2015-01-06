package com.gwt.kyu.shared;

import java.util.ArrayList;

public class ProposalHistory {
	private String SiraNo;
	private String TeklifNo;
	private String Durum;
	private String TeklifGirisTarih;
	private String SubeOnayTarihi;
	private String OnayTarihi;
	private String RetTarihi;
	private String SarfinazarTarihi;
	private String SarfinazarEdenKullanici;
	private String SonOnaylayanKullanici;
	private String ReddedenKullanici;
	private ArrayList<ProposalHistory> proposalHistoryList;
	public String getSiraNo() {
		return SiraNo;
	}
	public void setSiraNo(String siraNo) {
		SiraNo = siraNo;
	}
	public String getTeklifNo() {
		return TeklifNo;
	}
	public void setTeklifNo(String teklifNo) {
		TeklifNo = teklifNo;
	}
	public String getDurum() {
		return Durum;
	}
	public void setDurum(String durum) {
		Durum = durum;
	}
	public String getTeklifGirisTarih() {
		return TeklifGirisTarih;
	}
	public void setTeklifGirisTarih(String teklifGirisTarih) {
		TeklifGirisTarih = teklifGirisTarih;
	}
	public String getSubeOnayTarihi() {
		return SubeOnayTarihi;
	}
	public void setSubeOnayTarihi(String subeOnayTarihi) {
		SubeOnayTarihi = subeOnayTarihi;
	}
	public String getOnayTarihi() {
		return OnayTarihi;
	}
	public void setOnayTarihi(String onayTarihi) {
		OnayTarihi = onayTarihi;
	}
	public String getRetTarihi() {
		return RetTarihi;
	}
	public void setRetTarihi(String retTarihi) {
		RetTarihi = retTarihi;
	}
	public String getSarfinazarTarihi() {
		return SarfinazarTarihi;
	}
	public void setSarfinazarTarihi(String sarfinazarTarihi) {
		SarfinazarTarihi = sarfinazarTarihi;
	}
	public String getSarfinazarEdenKullanici() {
		return SarfinazarEdenKullanici;
	}
	public void setSarfinazarEdenKullanici(String sarfinazarEdenKullanici) {
		SarfinazarEdenKullanici = sarfinazarEdenKullanici;
	}
	public String getSonOnaylayanKullanici() {
		return SonOnaylayanKullanici;
	}
	public void setSonOnaylayanKullanici(String sonOnaylayanKullanici) {
		SonOnaylayanKullanici = sonOnaylayanKullanici;
	}
	public String getReddedenKullanici() {
		return ReddedenKullanici;
	}
	public void setReddedenKullanici(String reddedenKullanici) {
		ReddedenKullanici = reddedenKullanici;
	}
	public ArrayList<ProposalHistory> getProposalHistoryList() {
		return proposalHistoryList;
	}
	public void setProposalHistoryList(
			ArrayList<ProposalHistory> proposalHistoryList) {
		this.proposalHistoryList = proposalHistoryList;
	}
	
	public ArrayList<ProposalHistory> addProposal(){
		ProposalHistory history;
		ArrayList<ProposalHistory> history_temp=new ArrayList<ProposalHistory>();
		for(int i=1;i<31;i++){
			history = new ProposalHistory();
			
			history.setSiraNo(String.valueOf(i));
			history.setTeklifNo("1000"+(i));
			history.setDurum("Onayli");
			history.setTeklifGirisTarih((i)+".01.2015");
			history.setSubeOnayTarihi((i+1)+".01.2015");
			history.setOnayTarihi((i+1)+".01.2015");
			history.setRetTarihi("");
			history.setSarfinazarTarihi("");
			history.setSonOnaylayanKullanici("1140"+(i));
			history.setReddedenKullanici("");
			history.setSarfinazarEdenKullanici("");
			history_temp.add(history);
		}
		setProposalHistoryList(history_temp);
		return history_temp;
	}
	
}
