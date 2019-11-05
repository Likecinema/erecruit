package erecruit;
import java.sql.*;

public class Main {
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
											/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
											/*Main Class. Den uparxei parathiro, mono arxikopoieitai to programma
											 *Oi methodoi edw xrisimopoiountai gia recruiter alla kai candidate		*/
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		public static void main(String[] args) {
		LoginWindow ArxikoParathiro = new LoginWindow();
		ArxikoParathiro.createContents();
		ArxikoParathiro.open();
		try {
			Connection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
										/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
										/* 3 methodoi gia elegxo kai allagh tou kwdikou sto parathiro AllagiKwdikou */
										/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
		public boolean ElegxosPaliouKwdikou(String password) {
			if (password.equals(erecruit.LoginWindow.password)) {
				return true;
			}
			else return false;
		}
		public boolean AllagiKwdikou(String Kwdikos, String Epanalipsi) {
			if (Kwdikos.equals(Epanalipsi)) {
				erecruit.LoginWindow.password = Kwdikos;
				return true;
				//TODO allagi kwdikou se SQL
			}
			else return false;
				
		}
		public void UpdatePassword() {
			//TODO update ton kwdiko sthn SQL
		}
		
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
										/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
										/*Methodos dhmiourgias Statement gia efkolh epistrofh ResultSet opou xreiazetai*/
										/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		public static Statement Connection() throws SQLException  {

				//Sindesi ston Server
				String urlSindesis = "jdbc:mySQL://localhost:3306/erecruit?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
				String onomaSindesis = "root";
				String kodikosSindesis = "1234";
				Connection myConn = DriverManager.getConnection(urlSindesis, onomaSindesis, kodikosSindesis);
				//Dimiourgia Statement
				Statement NeaStatement = myConn.createStatement();
				return NeaStatement;

				
}
		
}

		
