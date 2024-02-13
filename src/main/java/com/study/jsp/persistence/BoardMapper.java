package com.study.jsp.persistence;

import java.util.List;

import com.study.jsp.model.BoardVO;
import com.study.jsp.model.Criteria;

public interface BoardMapper {

  int create(BoardVO vo);
  
  List<BoardVO> listAll();
  
  List<BoardVO> listPage(int page);// page를 받아서 offset을 계산 
  
  List<BoardVO> listCri(Criteria cri);//필요한 offset, spp 값을 멤소드를 통해 전달받는 Criteria 이용

  List<BoardVO> listPaging(Criteria cri);
  
  BoardVO read(int bno);
  
  int addcnt(int bno);
  
  int update(BoardVO vo);
  
  int delete(int bno);
  
}
