package com.study.jsp.ctrl.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.conf.Factory;
import com.study.jsp.ctrl.Controller;
import com.study.jsp.model.BoardDTO;
import com.study.jsp.srv.BoardService;

public class BoardUpdateCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    
    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("name", "forward");
    viewInfo.put("path", "/board/update.jsp");
    
    int bno = 0;
    String bno_ = req.getParameter("bno");
    if(!bno_.isEmpty()) {
      bno = Integer.valueOf(bno_);
    }
    
    BoardService boardSrv = Factory.INSTANCE.getBoardService();
    BoardDTO dto = boardSrv.read(bno);
    
    req.setAttribute("dto", dto);
    
    return viewInfo;
  }

}
