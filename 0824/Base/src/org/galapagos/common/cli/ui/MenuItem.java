package org.galapagos.common.cli.ui;

import org.galapagos.common.cli.command.Command;

//1개의 메뉴를 나타냄
public class MenuItem {
	private String title;
	private Command cmd;

	// 생성자
	public MenuItem(String title, Command cmd) {
		super();
		this.title = title;
		this.cmd = cmd;
	}

	// Getter
	public String getTitle() {
		return title;
	}

	public void execute() {
		if (cmd != null) {
			cmd.execute();
		}
	}

}
