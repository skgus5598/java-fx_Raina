package service;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertCommon {

	public void confirmMsg(String msg) {
	Alert alert  = new Alert(AlertType.CONFIRMATION);
	alert.setContentText(msg);
	alert.show();
	}
	
	public void errorMsg(String msg) {
		Alert alert  = new Alert(AlertType.ERROR);
		alert.setContentText(msg);
		alert.show();
	}
	
}
