package com.spring.plt.consulting.dao;

import java.util.List;

import com.spring.plt.consulting.vo.ConsultingVO;
import com.spring.plt.quotation.vo.QuotationVO;

public interface ConsultingDAO {
	void insertConsulting(ConsultingVO consultingVO);

	List<ConsultingVO> ConsultingList();

	ConsultingVO viewOneConsulting(String no);

	List<QuotationVO> alarmConsulting(String compId);
}
