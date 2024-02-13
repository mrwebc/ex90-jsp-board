package com.study.jsp.persistence;

import java.util.List;

import org.junit.Test;

import com.study.jsp.conf.Factory;
import com.study.jsp.model.BoardDTO;
import com.study.jsp.model.Criteria;
import com.study.jsp.srv.BoardService;

public class BoardMapperDaoTest {

  private BoardService boardSrv = Factory.INSTANCE.getBoardService();
  
  @Test
  public void listCriTest() {
    Criteria cri = new Criteria();
    cri.setPage(2);//요청페이지
    cri.setSpp(20);
    
    List<BoardDTO> list = boardSrv.listCri(cri);
    
    list.stream().forEach(dto->System.out.println(dto.toString()));
  }
  
  
  //@Test
  public void listPageTest() {
    int page = 3;
    List<BoardDTO> list = boardSrv.listPage(page);
    
    list.stream().forEach(dto->System.out.println(dto.toString()));
    
  }

  //@Test
  public void deleteTest() {
    boardSrv.delete(406);
  }
  
  //@Test
  public void readTest() {
    BoardDTO dto = boardSrv.read(406);
    System.out.println(dto.toString());
  }
  
  //@Test
  public void updateTest() {
    
    BoardDTO dto = BoardDTO.builder()
        .bno(406)
        .title("들장미소녀")
        .content("외로워도 슬퍼도 나는 안울어~!")
        .writer("candy")
        .build();
    
    boardSrv.update(dto);
  }
  
  //@Test
  public void createTest() {
    
    BoardDTO dto = BoardDTO.builder()
        .title("달려라하니")
        .content("이세상 끝까지~!")
        .writer("hani")
        .build();
    
    boardSrv.create(dto);    
  }
}
