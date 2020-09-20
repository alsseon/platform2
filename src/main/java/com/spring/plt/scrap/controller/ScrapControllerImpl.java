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
	
	
//	compId�몴? 嚥≪뮄�젃?�뵥 ?�뜎 session?肉�?苑� 獄쏆룇釉�?�궎?�뮉 野껉퍔�몵嚥�? ?�땾?�젟?鍮�?鍮�?鍮�?�빍?�뼄  - parent key ?�궎�몴?
	
//	scrap�빊�뮆�젾
	//?�읈�눧硫�? * �빊�뮆�젾
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
	    } //nowPage ?�겱?�삺 ?�읂?�뵠筌�?, cntPerPage = ?釉�?�읂?�뵠筌�??�뼣 疫�? 揶쏆뮇�땾
	    pageVO = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
	    Map compMap = new HashMap();
	    compMap.put("compId", compId);//�꽭�뀡�뿉�꽌 媛��졇�삱寃�
	    compMap.put("pageVO", pageVO);
		List expertScrapAllList = scrapService.printExpertScrapAll(compMap);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("expertScrapAllList", expertScrapAllList);
		mav.addObject("pageVO", pageVO);
		return mav;		
	}
	
	
	//?�젫鈺곌퀣毓쏙㎗? * �빊�뮆�젾
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
	    } //nowPage ?�겱?�삺 ?�읂?�뵠筌�?, cntPerPage = ?釉�?�읂?�뵠筌�??�뼣 疫�? 揶쏆뮇�땾
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
	
	//?�젫鈺곌퀣毓쏙㎗?/?�읈�눧硫�? 4揶쏆뮇逾� �빊�뮆�젾
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
				message += " alert('정상적으로 스크랩 되었습니다.');";
				message += " location.href='"+request.getContextPath()+"/expSearch/allExpert.do';";
				message += "</script>";
				resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			}catch(Exception e) {
				message = "<script>";
				message += " alert('스크랩 중 오류가 발생하였습니다.');";
				message += " location.href='"+request.getContextPath()+"/expSearch/allExpert.do';";
				message += "</script>";
				resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			}
		}
		else {
			System.out.println("===========controller scrapExpert() 餓λ쵎�궗?留� expid?�뿯?�빍?�뼄===========");
			message = "<script>";
			message += " alert('이미 스크랩 하셨습니다.');";
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
				message += " alert('정상적으로 스크랩 되었습니다.');";
				message += " location.href='"+request.getContextPath()+"/manufacSearch/allManufac.do';";
				message += "</script>";
				resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			}catch(Exception e) {
				message = "<script>";
				message += " alert('스크랩 중 오류가 발생하였습니다.');";
				message += " location.href='"+request.getContextPath()+"/manufacSearch/allManufac.do';";
				message += "</script>";
				resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			}
		}
		else {
//			餓λ쵎�궗?留� ?�뒄筌�? ?�뻻 alert揶�? ?援�?�궎?猷꾣에? ?�땾?�젟?鍮�?鍮� ?鍮�?�빍?�뼄
//			System.out.println("===========controller scrapExpert() 餓λ쵎�궗?留� manuid?�뿯?�빍?�뼄===========");
			message = "<script>";
			message += " alert('이미 스크랩 하셨습니다.');";
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
//		String compId = (String)session.getAttribute("compId"); �뜝�떥源띿삕�뜝�룞�삕 �뜝�룞�삕�뜝? �뜝�룞�삕�뜝�룞�삕 �뜝�떎紐뚯삕 �뜝�뙃琉꾩삕 �뜝�뙇�눦�삕 �뜝�룞�삕�뜝�룞�삕 �뜝��怨ㅼ삕
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
//		String compId = (String)session.getAttribute("compId"); �뜝�떥源띿삕�뜝�룞�삕 �뜝�룞�삕�뜝? �뜝�룞�삕�뜝�룞�삕 �뜝�떎紐뚯삕 �뜝�뙃琉꾩삕 �뜝�뙇�눦�삕 �뜝�룞�삕�뜝�룞�삕 �뜝��怨ㅼ삕
		String compId = "compId";
		ModelAndView mav = new ModelAndView("redirect:/scrap/printManuScrap.do?compId=" + compId);
		return mav;
	}

}
