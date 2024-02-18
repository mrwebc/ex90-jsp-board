package com.study.jsp.ctrl.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.ctrl.Controller;
import com.study.jsp.ioc.Factory;
import com.study.jsp.model.BoardDTO;
import com.study.jsp.srv.BoardService;

public class BoardUpdatePageOkCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    
    Map<String, String> viewInfo = new HashMap<String, String>();        
    viewInfo.put("mode", "redirect");
    
    int bno = 0;
    String bno_ = req.getParameter("bno");
    if(!bno_.isEmpty()) {
      bno = Integer.valueOf(bno_);
    }
    
    
    int page = 1;
    int spp = 10;
    
    String page_ = req.getParameter("page");
    if(page_!=null) {
      page = Integer.valueOf(page_);
    }
    
    String spp_ = req.getParameter("spp");
    if(spp_!=null) {
      spp = Integer.valueOf(spp_);
    }
            
    String title = req.getParameter("title");
    String content = req.getParameter("content");
    String writer = req.getParameter("writer");
    
    BoardDTO dto = BoardDTO.builder()
        .bno(bno)
        .title(title)
        .content(content)
        .writer(writer)
        .build();
       
    
    BoardService boardSrv = Factory.INSTANCE.getBoardService();
    boardSrv.update(dto);
    
    String viewName = String.format("/board/listPaging.do?page=%d&spp=%d", page,spp);
    viewInfo.put("viewName", viewName);
    
    return viewInfo;
  }

}
