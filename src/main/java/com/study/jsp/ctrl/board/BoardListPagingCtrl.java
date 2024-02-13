package com.study.jsp.ctrl.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.conf.Factory;
import com.study.jsp.ctrl.Controller;
import com.study.jsp.model.BoardDTO;
import com.study.jsp.model.Criteria;
import com.study.jsp.model.PaginationMaker;
import com.study.jsp.srv.BoardService;

public class BoardListPagingCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("name", "forward");
    viewInfo.put("path", "/board/listPaging.jsp");
    
    
    int page = 0;
    int spp = 0;
    
    String page_ = req.getParameter("page");
    if(page_!=null) {
      page = Integer.valueOf(page_);
    }
    
    String spp_ = req.getParameter("spp");
    if(spp_!=null) {
      spp = Integer.valueOf(spp_);
    }
    
    Criteria cri = new Criteria();
    cri.setPage(page);
    cri.setSpp(spp);
    
    PaginationMaker pagiMaker = new PaginationMaker();
    pagiMaker.setCri(cri);
    pagiMaker.setdisplayPagiNum(10);
    pagiMaker.setTotalCount(322);
    
    BoardService boardSrv = Factory.INSTANCE.getBoardService();
    List<BoardDTO> list = boardSrv.listPaging(cri);
    
    req.setAttribute("list", list);
    req.setAttribute("pagiMaker", pagiMaker);
    
    return viewInfo;
  }

}
