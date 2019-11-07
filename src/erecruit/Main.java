package erecruit;
import java.sql.*;

public class Main {
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
											/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
											/*Main Class. Den uparxei parathiro, mono arxikopoieitai to programma
											 *Oi methodoi edw xrisimopoiountai gia recruiter alla kai candidate		*/
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
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
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
					/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
					/* 3 methodoi gia elegxo kai allagh tou kwdikou sto parathiro AllagiKwdikou */
					/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
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
			}
			else return false;
				
		}
		public static void UpdatePassword(String kwdikos) {
			try {
				Main.Connection().executeUpdate("UPDATE user SET password = '" + kwdikos + "' WHERE username = '" + LoginWindow.username +"'" );
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
				/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
				/*Methodos dhmiourgias Statement gia efkolh epistrofh ResultSet opou xreiazetai*/
				/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
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
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
				/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++/*
				/*Triggers gia recruiter. To onoma gia update ston pinaka logs erxetai apo LoginWindow.username*/
				/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		public static void ExecuteTriggers() {
			try {
				//Trigger after insert on job gia logkeeping
				Main.Connection().execute("drop trigger if exists logkeeping1");
				Main.Connection().execute("create trigger logkeeping1 after insert on job\r\n" + 
						"for each row\r\n" + 
						"begin\r\n" + 
						"declare recruiter_name varchar(35);\r\n" + 
						"declare current_datetime datetime;\r\n" + 
						"set recruiter_name = (select recruiter from job order by id desc limit 1);\r\n" + 
						"set current_datetime=(NOW());\r\n" + 
						"insert into logs (username, datetime, success, action, pinakas) values\r\n" + 
						"(recruiter_name, current_datetime, 'yes', 'insert','job');\r\n" + 
						"end;\r\n");
				//triger after update on job gia logkeeping
				Main.Connection().execute("Drop trigger if exists logkeeping2;");
				Main.Connection().execute("create trigger logkeeping2 after update on job\r\n" + 
						"for each row\r\n" + 
						"begin\r\n" + 
						"declare current_datetime datetime;\r\n" +  
						"set current_datetime=(NOW());\r\n" + 
						"insert into logs (username, datetime, success, action, pinakas) values\r\n" + 
						"('"+LoginWindow.username+"', current_datetime, 'yes', 'update','job');\r\n" + 
						"end;\r\n");
				//triger after delete on job gia logkeeping, Den efarmozetai sto programma kathws kaneis den mporei na diagrapsei theseis
				Main.Connection().execute("drop trigger if exists logkeeping3;");
				Main.Connection().execute("create trigger logkeeping3 after delete on job\r\n" + 
						"for each row\r\n" + 
						"begin \r\n" + 
						"declare current_datetime datetime;\r\n" +
						"set current_datetime=(NOW());\r\n" + 
						"insert into logs (username, datetime, success, action, pinakas) values\r\n" + 
						"('"+LoginWindow.username+"', current_datetime, 'yes', 'delete','job');\r\n" + 
						"end;\r\n");
				//triger after update on etaireia gia logkeeping
				Main.Connection().execute("Drop trigger if exists logkeeping4;");
				Main.Connection().execute("create trigger logkeeping4 after update on etaireia\r\n" + 
						"for each row\r\n" + 
						"begin\r\n" + 
						"declare current_datetime datetime;\r\n" +  
						"set current_datetime=(NOW());\r\n" + 
						"insert into logs (username, datetime, success, action, pinakas) values\r\n" + 
						"('"+LoginWindow.username+"', current_datetime, 'yes', 'update','etaireia');\r\n" + 
						"end;\r\n");
				//triger after update on user gia logkeeping
				Main.Connection().execute("Drop trigger if exists logkeeping5;");
				Main.Connection().execute("create trigger logkeeping5 after update on user\r\n" + 
						"for each row\r\n" + 
						"begin\r\n" + 
						"declare current_datetime datetime;\r\n" +  
						"set current_datetime=(NOW());\r\n" + 
						"insert into logs (username, datetime, success, action, pinakas) values\r\n" + 
						"('"+LoginWindow.username+"', current_datetime, 'yes', 'update','user');\r\n" + 
						"end;\r\n");
				//triger after insert on user gia logkeeping
				Main.Connection().execute("Drop trigger if exists logkeeping6;");
				Main.Connection().execute("create trigger logkeeping6 after insert on user\r\n" + 
						"for each row\r\n" + 
						"begin\r\n" + 
						"declare current_datetime datetime;\r\n" +  
						"set current_datetime=(NOW());\r\n" + 
						"insert into logs (username, datetime, success, action, pinakas) values\r\n" + 
						"('"+LoginWindow.username+"', current_datetime, 'yes', 'insert','user');\r\n" + 
						"end;\r\n");
				//trigger after delete on user gia logkeeping. Den efarmozetai sto programma, einai adunath h diagrafi xristi
				Main.Connection().execute("Drop trigger if exists logkeeping6;");
				Main.Connection().execute("create trigger logkeeping6 after delete on user\r\n" + 
						"for each row\r\n" + 
						"begin\r\n" + 
						"declare current_datetime datetime;\r\n" +  
						"set current_datetime=(NOW());\r\n" + 
						"insert into logs (username, datetime, success, action, pinakas) values\r\n" + 
						"('"+LoginWindow.username+"', current_datetime, 'yes', 'delete','user');\r\n" + 
						"end;\r\n");
				//trigger after update on candidate
				Main.Connection().execute("Drop trigger if exists logkeeping7;");
				Main.Connection().execute("create trigger logkeeping7 after update on candidate\r\n" + 
						"for each row\r\n" + 
						"begin\r\n" + 
						"declare current_datetime datetime;\r\n" +  
						"set current_datetime=(NOW());\r\n" + 
						"insert into logs (username, datetime, success, action, pinakas) values\r\n" + 
						"('"+LoginWindow.username+"', current_datetime, 'yes', 'update','candidate');\r\n" + 
						"end;\r\n");
				//trigger after insert on candidate
				Main.Connection().execute("Drop trigger if exists logkeeping8;");
				Main.Connection().execute("create trigger logkeeping8 after insert on candidate\r\n" + 
						"for each row\r\n" + 
						"begin\r\n" + 
						"declare current_datetime datetime;\r\n" +  
						"set current_datetime=(NOW());\r\n" + 
						"insert into logs (username, datetime, success, action, pinakas) values\r\n" + 
						"('"+LoginWindow.username+"', current_datetime, 'yes', 'insert','candidate');\r\n" +
						"end;\r\n");
				//trigger after delete on candidate. Den efarmozetai sto programma, einai adunath h diagrafi ipopsifiou
				Main.Connection().execute("Drop trigger if exists logkeeping7;");
				Main.Connection().execute("create trigger logkeeping7 after delete on candidate\r\n" + 
						"for each row\r\n" + 
						"begin\r\n" + 
						"declare current_datetime datetime;\r\n" +  
						"set current_datetime=(NOW());\r\n" + 
						"insert into logs (username, datetime, success, action, pinakas) values\r\n" + 
						"('"+LoginWindow.username+"', current_datetime, 'yes', 'delete','candidate');\r\n" + 
						"end;\r\n");
				//trigger after insert on etaireia
				Main.Connection().execute("Drop trigger if exists logkeeping8;");
				Main.Connection().execute("create trigger logkeeping8 after insert on etaireia\r\n" + 
						"for each row\r\n" + 
						"begin\r\n" + 
						"declare current_datetime datetime;\r\n" +  
						"set current_datetime=(NOW());\r\n" + 
						"insert into logs (username, datetime, success, action, pinakas) values\r\n" + 
						"('"+LoginWindow.username+"', current_datetime, 'yes', 'insert','etaireia');\r\n" + 
						"end;\r\n");
				//trigger after delete on etaireia. Den efarmozetai sto programma, einai adunath h diagrafi etaireias
				Main.Connection().execute("Drop trigger if exists logkeeping9;");
				Main.Connection().execute("create trigger logkeeping9 after delete on etaireia\r\n" + 
						"for each row\r\n" + 
						"begin\r\n" + 
						"declare current_datetime datetime;\r\n" +  
						"set current_datetime=(NOW());\r\n" + 
						"insert into logs (username, datetime, success, action, pinakas) values\r\n" + 
						"('"+LoginWindow.username+"', current_datetime, 'yes', 'delete','etaireia');\r\n" + 
						"end;\r\n");
				//trigger after update on recruiter
				Main.Connection().execute("Drop trigger if exists logkeeping10;");
				Main.Connection().execute("create trigger logkeeping10 after update on recruiter\r\n" + 
						"for each row\r\n" + 
						"begin\r\n" + 
						"declare current_datetime datetime;\r\n" +  
						"set current_datetime=(NOW());\r\n" + 
						"insert into logs (username, datetime, success, action, pinakas) values\r\n" + 
						"('"+LoginWindow.username+"', current_datetime, 'yes', 'update','recruiter');\r\n" + 
						"end;\r\n");
				//trigger after insert on recruiter
				Main.Connection().execute("Drop trigger if exists logkeeping11;");
				Main.Connection().execute("create trigger logkeeping11 after insert on recruiter\r\n" + 
						"for each row\r\n" + 
						"begin\r\n" + 
						"declare current_datetime datetime;\r\n" +  
						"set current_datetime=(NOW());\r\n" + 
						"insert into logs (username, datetime, success, action, pinakas) values\r\n" + 
						"('"+LoginWindow.username+"', current_datetime, 'yes', 'insert','recruiter');\r\n" + 
						"end;\r\n");
				//trigger after delete on recruiter. Den efarmozetai, einai adunath h diagrafh recruiter
				Main.Connection().execute("Drop trigger if exists logkeeping12;");
				Main.Connection().execute("create trigger logkeeping12 after delete on recruiter\r\n" + 
						"for each row\r\n" + 
						"begin\r\n" + 
						"declare current_datetime datetime;\r\n" +  
						"set current_datetime=(NOW());\r\n" + 
						"insert into logs (username, datetime, success, action, pinakas) values\r\n" + 
						"("+LoginWindow.username+", current_datetime, 'yes', 'delete','recruiter');\r\n" + 
						"end;\r\n");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
		
}

		
