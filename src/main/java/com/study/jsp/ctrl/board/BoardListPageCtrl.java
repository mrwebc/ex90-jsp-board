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
import com.study.jsp.srv.BoardService;

public class BoardListPageCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    
    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("name", "forward");
    viewInfo.put("path", "/board/listPage.jsp");
    
    int page = 1;
    
    String page_ = req.getParameter("page");
    if(page_!=null) {
      page = Integer.valueOf(page_);
    }
    
    BoardService boardSrv = Factory.INSTANCE.getBoardService();
    List<BoardDTO> list = boardSrv.listPage(page);
    
    req.setAttribute("list", list);
    
    return viewInfo;
  }

}
