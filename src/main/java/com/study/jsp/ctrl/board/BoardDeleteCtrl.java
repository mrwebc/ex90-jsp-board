package com.study.jsp.ctrl.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.conf.Factory;
import com.study.jsp.ctrl.Controller;
import com.study.jsp.except.NotExistPostException;
import com.study.jsp.srv.BoardService;

public class BoardDeleteCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    Map<String, String> viewInfo = new HashMap<String, String>();        
    viewInfo.put("name", "redirect");
    viewInfo.put("path", "/board/listAll.do");
    
    int bno = 0;
    String bno_ = req.getParameter("bno");
    if(!bno_.isEmpty()) {
      bno = Integer.valueOf(bno_);
    }
    
    BoardService boardSrv = Factory.INSTANCE.getBoardService();
    
    
    try {
      boardSrv.delete(bno);
      
    }catch(NotExistPostException e) {
      System.out.println(e.getMessage());
    }

    return viewInfo;
  }

}
