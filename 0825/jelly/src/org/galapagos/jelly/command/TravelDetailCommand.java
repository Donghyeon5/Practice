package org.galapagos.jelly.command;

import org.galapagos.common.cli.Input;
import org.galapagos.common.cli.command.Command;
import org.galapagos.jelly.dao.TravelDao;
import org.galapagos.jelly.dao.TravelDaoimpl;
import org.galapagos.jelly.vo.TravelVO;

public class TravelDetailCommand implements Command {
	TravelDao dao = TravelDaoimpl.getInstance();

	@Override
	public void execute() {
		// NO : 104 -> 입력
		int no = Input.readInt("No: ");

		TravelVO travel = dao.findById(no);
		if (travel == null) {
			System.out.println("잘못된 번호입니다.");
			return;
		}

		// 권역 : xxxx
		// 관광지명 : xxxxx
		// 주소 : xxx
		// 전화번호 : xxx..
		// xxxxxxxxxxxx...

		System.out.println("권역    -> " + travel.getRegion());
		System.out.println("관광지명 ->  " + travel.getTitle());
		System.out.println("주소    -> " + travel.getAddress());
		System.out.println("전화번호 -> " + travel.getPhone());
		System.out.println(travel.getDescription().replace(". ", ".\n"));
		// .을 기준으로 개행시키기
	}

}
