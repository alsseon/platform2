package com.spring.plt.scrap.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.page.vo.PageVO;
import com.spring.plt.scrap.service.ScrapService;
import com.spring.plt.scrap.vo.ScrapVO;

@Controller("scrapController")
public class ScrapControllerImpl implements ScrapController{
	@Autowired
	private ScrapService scrapService;
	@Autowired
	private ScrapVO scrapVO;
	
	
//	compId占쎈ご? �슖�돦裕꾬옙�쟽?占쎈데 ?占쎈쐩 session?�굢占�?�땻占� �뛾�룇猷뉔뇡占�?占쎄텕?占쎈츎 �뇦猿됲뜑占쎈さ�슖占�? ?占쎈빢?占쎌젧?�뜮占�?�뜮占�?�뜮占�?占쎈퉵?占쎈펲  - parent key ?占쎄텕占쎈ご?
	
//	scrap占쎈퉲占쎈츊占쎌졑
	//?占쎌쓧占쎈닱筌롳옙? * 占쎈퉲占쎈츊占쎌졑
	@Override
	@RequestMapping(value="/scrap/printExpertScrap.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView printExpertScrapAll(PageVO pageVO, @RequestParam(value="nowPage", required = false) String nowPage, @RequestParam(value="cntPerPage", required=false)String cntPerPage,
			@RequestParam("compId") String compId,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		HttpSession session = request.getSession();
		
//		String compId = "op3838";
//		String compId = (String) session.getAttribute("member");
		
//		paging code
		int total = scrapService.listExpScrapCount(compId);
	    if(nowPage == null && cntPerPage == null) {
	        nowPage = "1";
	        cntPerPage = "8";
	    }else if(nowPage == null) {
	        nowPage = "1";
	    }else if(cntPerPage == null) {
	        cntPerPage = "8";
	    } //nowPage ?占쎄껑?占쎌궨 ?占쎌쓡?占쎈턄嶺뚳옙?, cntPerPage = ?�뇡占�?占쎌쓡?占쎈턄嶺뚳옙??占쎈샬 �뼨占�? �뤆�룇裕뉛옙�빢
	    pageVO = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
	    Map compMap = new HashMap();
	    compMap.put("compId", compId);//占쎄쉭占쎈�∽옙肉됵옙苑� 揶쏉옙占쎌죬占쎌궞野껓옙
	    compMap.put("pageVO", pageVO);
		List expertScrapAllList = scrapService.printExpertScrapAll(compMap);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("expertScrapAllList", expertScrapAllList);
		mav.addObject("pageVO", pageVO);
		return mav;		
	}
	
	
	//?占쎌젷�댖怨뚰�ｆ캆�룞�럸? * 占쎈퉲占쎈츊占쎌졑
	@Override
	@RequestMapping(value="/scrap/printManuScrap.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView printManuScrapAll(PageVO pageVO, @RequestParam(value="nowPage", required = false) String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage, 
			@RequestParam("compId") String compId,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		
		HttpSession session = request.getSession();
//		String compId = "op3838";
//		String compId = (String) session.getAttribute("member");
		
//		paging code
		int total = scrapService.listCount(compId);
	    if(nowPage == null && cntPerPage == null) {
	        nowPage = "1";
	        cntPerPage = "8";
	    }else if(nowPage == null) {
	        nowPage = "1";
	    }else if(cntPerPage == null) {
	        cntPerPage = "8";
	    } //nowPage ?占쎄껑?占쎌궨 ?占쎌쓡?占쎈턄嶺뚳옙?, cntPerPage = ?�뇡占�?占쎌쓡?占쎈턄嶺뚳옙??占쎈샬 �뼨占�? �뤆�룇裕뉛옙�빢
	    pageVO = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
	    Map compMap = new HashMap();
	    compMap.put("compId", compId);
	    compMap.put("pageVO", pageVO);
		List manuScrapAllList = scrapService.printManuScrapAll(compMap);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("manuScrapAllList", manuScrapAllList);
		mav.addObject("pageVO", pageVO);
		return mav;
	}
	
	//?占쎌젷�댖怨뚰�ｆ캆�룞�럸?/?占쎌쓧占쎈닱筌롳옙? 4�뤆�룇裕뉔�억옙 占쎈퉲占쎈츊占쎌졑
	@Override
	@RequestMapping(value="/scrap/printScrapAll.do",method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView printScrapAll(@RequestParam("compId") String compId,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		Map allScrapMap = scrapService.printScrap(compId);
		List expertScrapList = scrapService.printExpertScrap(compId);
		List manuScrapList = scrapService.printManuScrap(compId);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("expertScrapList", expertScrapList);
		mav.addObject("manuScrapList", manuScrapList);
		mav.addObject("allScrapMap", allScrapMap);
		return mav;
	}
	
	//insert scrap
	@Override
	@RequestMapping(value="/scrap/scrapExpert.do", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ResponseEntity scrapExpert(@RequestParam("expId") String expId, @RequestParam("compId") String compId,
							HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		int Overlapped = scrapService.isOverlapE(expId);
		if(Overlapped == 0) {
			try {
				scrapVO.setCompid(compId);
				scrapVO.setExpid(expId);
				scrapService.scrapExpert(scrapVO);
				message = "<script>";
				message += " alert('스크랩 되었습니다.');";
				message += " location.href='"+request.getContextPath()+"/expSearch/allExpert.do';";
				message += "</script>";
				resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			}catch(Exception e) {
				message = "<script>";
				message += " alert('스크랩하지 못했습니다.');";
				message += " location.href='"+request.getContextPath()+"/expSearch/allExpert.do';";
				message += "</script>";
				resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			}
		}
		else {
			System.out.println("===========controller scrapExpert() 繞벿살탮占쎄텢?筌랃옙 expid?占쎈엷?占쎈퉵?占쎈펲===========");
			message = "<script>";
			message += " alert('이미 스크랩된 항목입니다.');";
			message += " location.href='"+request.getContextPath()+"/expSearch/allExpert.do';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}
		return resEnt;
	}
	
	@Override
	@RequestMapping(value="/scrap/scrapManu.do", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ResponseEntity scrapManu(@RequestParam("manuId") String manuId, @RequestParam("compId") String compId,
							HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		int Overlapped = scrapService.isOverlapM(manuId);
		if(Overlapped == 0) {
			try {
				scrapVO.setCompid(compId);
				scrapVO.setManuid(manuId);
				scrapService.scrapManu(scrapVO);
				message = "<script>";
				message += " alert('스크랩 되었습니다.');";
				message += " location.href='"+request.getContextPath()+"/manufacSearch/allManufac.do';";
				message += "</script>";
				resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			}catch(Exception e) {
				message = "<script>";
				message += " alert('스크랩하지 못했습니다.');";
				message += " location.href='"+request.getContextPath()+"/manufacSearch/allManufac.do';";
				message += "</script>";
				resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			}
		}
		else {
//			繞벿살탮占쎄텢?筌랃옙 ?占쎈뭵嶺뚳옙? ?占쎈뻣 alert�뤆占�? ?�뤃占�?占쎄텕?�뙴袁ｌ뿉? ?占쎈빢?占쎌젧?�뜮占�?�뜮占� ?�뜮占�?占쎈퉵?占쎈펲
//			System.out.println("===========controller scrapExpert() 繞벿살탮占쎄텢?筌랃옙 manuid?占쎈엷?占쎈퉵?占쎈펲===========");
			message = "<script>";
			message += " alert('이미 스크랩된 항목입니다.');";
			message += " location.href='"+request.getContextPath()+"/manufacSearch/allManufac.do';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}
		return resEnt;
	}
	
	
	//delete scrap
	@Override
	@RequestMapping(value="/scrap/deleteExpertScrap.do", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteExpertScrap(@RequestParam("no") int no,
						HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
//		String compId = (String)session.getAttribute("compId"); 占쎈쐻占쎈뼢繹먮씮�굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻? 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈뼄筌뤿슣�굲 占쎈쐻占쎈셾筌뚭쑴�굲 占쎈쐻占쎈솂占쎈닰占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쏙옙�ⓦ끉�굲
		String compId = "compId";
		scrapService.deleteExpertScrap(no);
		ModelAndView mav = new ModelAndView("redirect:/scrap/printExpertScrap.do?compId=" + compId);
		return mav;
		
		
	}
	
	@Override
	@RequestMapping(value="/scrap/deleteManuScrap.do", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteManuScrap(@RequestParam("no") int no, 
						HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		scrapService.deleteManuScrap(no);
		HttpSession session = request.getSession();
//		String compId = (String)session.getAttribute("compId"); 占쎈쐻占쎈뼢繹먮씮�굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻? 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈뼄筌뤿슣�굲 占쎈쐻占쎈셾筌뚭쑴�굲 占쎈쐻占쎈솂占쎈닰占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쏙옙�ⓦ끉�굲
		String compId = "compId";
		ModelAndView mav = new ModelAndView("redirect:/scrap/printManuScrap.do?compId=" + compId);
		return mav;
	}

}
