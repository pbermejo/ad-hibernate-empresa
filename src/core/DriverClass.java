package core;

import java.io.IOException;
import java.sql.Connection;

import ui.Menu;
import utils.HibernateUtil;

public class DriverClass {

	public static void main(String[] args) {
        try {
        	Menu menu = new Menu();
			menu.mainMenu();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
