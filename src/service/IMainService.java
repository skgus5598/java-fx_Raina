package service;

import javafx.scene.Parent;

public interface IMainService {
	
	public void setRoot(Parent root); // 로그인페이지 루트 
	public void login();   //  로그인 	
	public void createPage();
	public void createAcc();    //회원가입 
	public void genderCom();
		
}
