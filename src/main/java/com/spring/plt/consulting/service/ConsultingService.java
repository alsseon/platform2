package com.spring.plt.consulting.service;

import java.util.List;

import com.spring.plt.consulting.vo.ConsultingVO;
import com.spring.plt.quotation.vo.QuotationVO;

public interface ConsultingService {
	void insertConsulting(ConsultingVO consultingVO);

	List<ConsultingVO> ConsultingList();

	ConsultingVO viewOneConsulting(String no);

	List<QuotationVO> alarmConsulting(String compId);
}
