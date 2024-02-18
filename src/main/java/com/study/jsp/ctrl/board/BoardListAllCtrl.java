package com.study.jsp.ctrl.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.ctrl.Controller;
import com.study.jsp.ioc.Factory;
import com.study.jsp.model.BoardDTO;
import com.study.jsp.srv.BoardService;

public class BoardListAllCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    
    Map<String, String> viewInfo = new HashMap<String, String>();
    viewInfo.put("mode", "forward");
    viewInfo.put("viewName", "/board/listAll.jsp");
    
    BoardService boardSrv = Factory.INSTANCE.getBoardService();
    List<BoardDTO> list = boardSrv.listAll();
    
    req.setAttribute("list", list);
    
    return viewInfo;
  }

}
