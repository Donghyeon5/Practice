package org.galapagos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.galapagos.domain.BoardVO;
import org.galapagos.domain.Criteria;

public interface BoardMapper {

//	@Select("select * from tbl_board")
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	// insert 후에 bno를 모름
	public void insert(BoardVO board);
	
	// insert 후에 bno를 추출
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
	
	public int getTotalCount(Criteria cri);

	
}
