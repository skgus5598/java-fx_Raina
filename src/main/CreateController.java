package main;

import java.net.URL;
import java.util.ResourceBundle;

import db.DBCommon;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import service.IMainService;
import service.MainService;

public class CreateController implements Initializable{	

		Parent root;
		IMainService ms;
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			ms = new MainService();
			DBCommon.setDBConnection();			
		}

		public void setRoot(Parent createRoot) {
			this.root = createRoot;
			ms.setRoot(root);
			ms.genderCom();			
		}
		
		public void create() {
			ms.createAcc();
		}
		
	}


