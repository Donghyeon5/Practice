package org.galapagos.common.cli.ui;

import org.galapagos.common.cli.command.ExitCommand;

public abstract class Application {

	private Menu menu;

	public void createMenu(Menu menu) {
	}

	public void init() {
		menu = new Menu();
		createMenu(menu);
		menu.add(new MenuItem("종료", new ExitCommand(this)));
	}

	public void cleanup() {

	}

	public void run() {
		init();
		while (true) {
			menu.print();
			MenuItem item = menu.select();
			if (item != null)
				item.execute();
			System.out.println("\n");
		}
	}
}

//while (true) {
//	System.out.println("1.목록 2.검색 3.종료");
//	int sel = Input.readInt("선택 > ");
//	if (sel == 1) {
//		System.out.println("목록 실행");
//	} else if (sel == 2) {
//		System.out.println("검색 실행");
//	} else if (sel == 3) {
//		System.exit(0);
//	} else {
//		System.out.println("잘못된 선택입니다.");
//	}
//}
//}