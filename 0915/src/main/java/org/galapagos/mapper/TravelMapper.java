package org.galapagos.mapper;

import java.util.List;

import org.galapagos.domain.BoardVO;
import org.galapagos.domain.Criteria;
import org.galapagos.domain.TravelVO;

public interface TravelMapper {
	
	public int getTotalCount(Criteria cri);
	
	// 페이지 목록 추출
	public List<TravelVO> getList(Criteria cri);
	
	public TravelVO read(Long no);
	
	//insert 후에 no를 추출 (프라이머리 키를 얻음)
	public void insert(TravelVO travel);
	
	public int update(TravelVO travel);
	
	public int delete(Long no);

	}
