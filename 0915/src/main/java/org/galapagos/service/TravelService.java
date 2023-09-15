package org.galapagos.service;

import java.util.List;

import org.galapagos.domain.BoardVO;
import org.galapagos.domain.Criteria;
import org.galapagos.domain.TravelVO;

public interface TravelService {
	// CRUD 기본 인터페이스
	
	public int getTotal(Criteria cri);
	
	public List<TravelVO> getList(Criteria cri);
	
	public TravelVO get(Long no);
	
	public void register(TravelVO travel);
	
	public boolean modify(TravelVO travel);
	
	public boolean remove(Long no);
	
	
	
	
}
