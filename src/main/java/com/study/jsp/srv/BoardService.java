package com.study.jsp.srv;

import java.util.List;

import com.study.jsp.model.BoardDTO;
import com.study.jsp.model.BoardVO;
import com.study.jsp.model.Criteria;

public interface BoardService {
  void create(BoardDTO dto);
  
  List<BoardDTO> listAll();

  List<BoardDTO> listPage(int page);// page를 받아서 offset을 계산 
  
  List<BoardDTO> listCri(Criteria cri);
  
  //필요한 offset, spp 값을 멤소드를 통해 전달받는 Criteria 이용
  List<BoardDTO> listPaging(Criteria cri);
  
  BoardDTO read(int bno);
  
  void addcnt(int bno);
  
  void update(BoardDTO dto);
  
  void delete(int bno);
  
  
}
