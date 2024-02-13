package com.study.jsp.ctrl.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.conf.Factory;
import com.study.jsp.ctrl.Controller;
import com.study.jsp.model.BoardDTO;
import com.study.jsp.srv.BoardService;

public class BoardRegisterCtrl implements Controller {

  @Override
  public Map<String, String> execute(HttpServletRequest req, HttpServletResponse res) {
    
    Map<String, String> viewInfo = new HashMap<String, String>();
    
    viewInfo.put("name", "forward");
    viewInfo.put("path", "/board/success.jsp");
    
    viewInfo.put("name", "redirect");
    viewInfo.put("path", "/board/listAll.do");
    
    String title = req.getParameter("title");
    String content = req.getParameter("content");
    String writer = req.getParameter("writer");
    
    BoardDTO dto = BoardDTO.builder()
        .title(title)
        .content(content)
        .writer(writer)
        .build();
       
    System.out.println("BoardRegisterCtrl 컨트롤러 호출~!");
    System.out.println(dto.toString());
    
    BoardService boardSrv = Factory.INSTANCE.getBoardService();
    boardSrv.create(dto);   
    
    req.setAttribute("result", "success");
    
    return viewInfo;
  }

}
