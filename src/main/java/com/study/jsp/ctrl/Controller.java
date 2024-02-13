package com.study.jsp.ctrl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {  
  Map<String, String> execute(HttpServletRequest req, HttpServletResponse res);
  /*
   * {
        Map<String, String> viewInfo = new HashMap<String, String>();        
        viewInfo.put("name", "redirect");
        viewInfo.put("path", "/board/listAll.do");
        
        Map<String, String> viewInfo = new HashMap<String, String>();
        viewInfo.put("name", "forward");
        viewInfo.put("path", "/board/read.jsp");
   * }
   * 
   */
}
