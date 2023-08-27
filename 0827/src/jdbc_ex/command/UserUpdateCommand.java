package jdbc_ex.command;

import org.galapagos.common.cli.Input;
import org.galapagos.common.cli.command.Command;

import jdbc_ex.dao.UserDAO;
import jdbc_ex.dao.UserDAOImpl;
import jdbc_ex.domain.UserVo;

public class UserUpdateCommand implements Command {
	UserDAO dao = UserDAOImpl.getInstance();

	@Override
	public void execute() {
		System.out.println("[사용자 정보 수정]");
		// 1. 수정할 userid 입력 받기
		// 2. 기존 데이터를 얻기
		// 3. 기존 데이터 보여주면서 업데이트 할 내용 입력 받기
		// 4. 업데이트

		String userid = Input.read("사용자 ID : ");
		UserVo user = dao.getUser(userid);
		if (user == null) {
			System.out.println("존재하지 않는 ID입니다.");
			return;
		}
		// 이름 파트
		// 이름(김길동) :
		String name = Input.read("이름", user.getName());
		String role = Input.read("역할", user.getRole());

		user.setName(name);
		user.setRole(role);

		dao.updateUser(user);
	}
}
