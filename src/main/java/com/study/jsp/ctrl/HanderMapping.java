package com.study.jsp.ctrl;

import java.util.HashMap;
import java.util.Map;

import com.study.jsp.ctrl.board.BoardDeleteCtrl;
import com.study.jsp.ctrl.board.BoardDeletePageCtrl;
import com.study.jsp.ctrl.board.BoardListAllCtrl;
import com.study.jsp.ctrl.board.BoardListCriCtrl;
import com.study.jsp.ctrl.board.BoardListPageCtrl;
import com.study.jsp.ctrl.board.BoardListPagingCtrl;
import com.study.jsp.ctrl.board.BoardReadCtrl;
import com.study.jsp.ctrl.board.BoardReadPageCtrl;
import com.study.jsp.ctrl.board.BoardRegisterCtrl;
import com.study.jsp.ctrl.board.BoardUpdateCtrl;
import com.study.jsp.ctrl.board.BoardUpdateOkCtrl;
import com.study.jsp.ctrl.board.BoardUpdatePageCtrl;
import com.study.jsp.ctrl.board.BoardUpdatePageOkCtrl;

public class HanderMapping {

  Map<String, Controller> urlMap = null;// url과 command 객체를 서로 연결시켜 주는 역할

  // 생성자에서 맵초기화
  public HanderMapping() {
    urlMap = new HashMap<String, Controller>();
    urlMap.put("/board/register.do", new BoardRegisterCtrl());
    urlMap.put("/board/listAll.do", new BoardListAllCtrl());
    urlMap.put("/board/listPage.do", new BoardListPageCtrl());
    urlMap.put("/board/listCri.do", new BoardListCriCtrl());
    urlMap.put("/board/listPaging.do", new BoardListPagingCtrl());
    urlMap.put("/board/read.do", new BoardReadCtrl());
    urlMap.put("/board/readPage.do", new BoardReadPageCtrl());
    urlMap.put("/board/delete.do", new BoardDeleteCtrl());
    urlMap.put("/board/deletePage.do", new BoardDeletePageCtrl());
    urlMap.put("/board/update.do", new BoardUpdateCtrl());
    urlMap.put("/board/updateOk.do", new BoardUpdateOkCtrl());
    urlMap.put("/board/updatePage.do", new BoardUpdatePageCtrl());
    urlMap.put("/board/updatePageOk.do", new BoardUpdatePageOkCtrl());
  }

  public Controller getController(String path) {
    return urlMap.get(path);
  }
}
