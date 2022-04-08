package ui;

import java.io.IOException;

import core.Operation;

public class Menu {

	public void mainMenu() throws IOException {
		String[] menu = { "SALIR [->", };
		switch (IO.menuChoice("OPERACIONES PRINCIPALES:", menu)) {
		case 0:
			System.exit(0);
			break;
		case 1:
			Operation.createDepartment(IO.getUserInput("> Nombre: "));
			mainMenu();
			break;
		}
	}
}
