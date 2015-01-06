package com.gwt.kyu.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.gwt.kyu.shared.ProcessDetail;

public class ProposalHistoryDetailOperation {
	public HashMap<String, ArrayList<ProcessDetail>> getHistoryProposalDetail() {
		HashMap<String, ArrayList<ProcessDetail>> hm = new HashMap<String, ArrayList<ProcessDetail>>();
		hm.clear();
		ProcessDetail detail;
		for (int i = 1; i < 31; i++) {
			ArrayList<ProcessDetail> temp_array=new ArrayList<ProcessDetail>();
			for (int j = 1; j < 8; j++) {
				detail=new ProcessDetail();
				detail.setSiraNo(String.valueOf(j));
				detail.setKullaniciKodu("1140"+(i));
				detail.setBaslangicTarih("04/12/2014 14:00:1"+j);
				detail.setBitisTarih("04/12/2014 14:00:2"+j);
				detail.setSüre("00 Saat:0"+j+" dakika");
				detail.setSonuc("SONUC "+j);
				temp_array.add(detail);
			}
			hm.put(String.valueOf(i), temp_array);
		}
		return hm;
	}
	public ArrayList<ProcessDetail> getDetail(String no) {
		ArrayList<ProcessDetail> answerArray = null;
		HashMap<String,ArrayList<ProcessDetail>> hm = getHistoryProposalDetail();
		Set<String> keys = hm.keySet();
		for (String key : keys) {
			if (key.equals(no)) {
				answerArray = hm.get(key);
				break;
			}
		}
		return answerArray;
	}
}
