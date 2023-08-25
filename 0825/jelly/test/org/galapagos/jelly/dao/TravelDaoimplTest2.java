package org.galapagos.jelly.dao;

import org.galapagos.jelly.vo.TravelVO;

class TravelDaoimplTest2 {

	public static void main(String[] args) {
		TravelDao dao = TravelDaoimpl.getInstance();

		TravelVO travel = dao.findById(10);
		System.out.println(travel);
	}

}
