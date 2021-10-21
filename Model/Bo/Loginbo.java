package Bo;

import java.util.ArrayList;

import Bean.Login;
import Dao.Logindao;

public class Loginbo {
	Logindao lg = new Logindao();
	public ArrayList<Login> getlogin(){
		return lg.getLogin();
	}
	public Login checkLogin(String tendn, String matkhau) {
		for(Login e:getlogin()) {
			if(e.getTendn().equals(tendn) && e.getMatkhau().equals(matkhau))
				return e;
		}		
		return null;
	}
	public boolean createLogin(Login user) {
		if(lg.createLogin(user))
			return true;
		return false;
	}
	public boolean updateLogin(Login user) {
		if(lg.updateLogin(user))
			return true;
		return false;
	}
	public boolean checkExists(String tendn) {
		for(Login e:getlogin()) {
			if(e.getTendn().equals(tendn))
				return true;
		}
		return false;
	}
	public boolean checkAdmin(Login user) {
		for(Login e:getlogin()) {
			if(e.getTendn().equals(user.getTendn()) 
			&& e.getMatkhau().equals(user.getMatkhau()) 
			&& e.isIsadmin()==true)
				return true;
		}
		return false;
	}
}
