package jdbc_ex.command;

import org.galapagos.common.cli.Input;
import org.galapagos.common.cli.command.Command;

import jdbc_ex.dao.UserDAO;
import jdbc_ex.dao.UserDAOImpl;
import jdbc_ex.domain.UserVo;

public class UserAddCommand implements Command {
	UserDAO dao = UserDAOImpl.getInstance();

	@Override
	public void execute() {
		System.out.println("[사용자 추가]");
		String userid = Input.read("사용자 ID : ");
		// id 중복 체크
		UserVo user = dao.getUser(userid);
		if (user != null) { // 이미 존재하는 id
			System.out.println("이미 사용 중인 ID입니다.");
			return;
		}

		String password = Input.read("비밀번호 : ");
		String name = Input.read("이름 : ");
		String role = Input.read("역할 : ");

		user = new UserVo(userid, password, name, role);
		dao.insertUser(user);
		System.out.println("-----------------------------");
	}

}
