package Bo;

import java.util.ArrayList;

import Bean.Categorybean;
import Dao.Categorydao;





public class Categorybo {
	
	Categorydao ldao = new Categorydao();
	public ArrayList<Categorybean> getloai() throws Exception {
		return ldao.getloai();
	}
}
