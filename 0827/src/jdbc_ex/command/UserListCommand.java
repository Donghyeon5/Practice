package jdbc_ex.command;

import java.util.List;

import org.galapagos.common.cli.command.Command;

import jdbc_ex.dao.UserDAO;
import jdbc_ex.dao.UserDAOImpl;
import jdbc_ex.domain.UserVo;

public class UserListCommand implements Command {
	UserDAO dao = UserDAOImpl.getInstance();

	@Override
	public void execute() {
		System.out.println("[User 목록 보기]");
		List<UserVo> list = dao.getUserList();

		System.out.println("-----------------------------");
		for (int i = 0; i < list.size(); i++) {
			UserVo user = list.get(i);
			System.out.printf("%d] %s\n", (i + 1), user.getId());
		}
		System.out.println("-----------------------------");
		System.out.printf("총 %d건 \n", list.size());
	}

}
