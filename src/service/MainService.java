package service;

import db.DBService;
import db.IDBService;
import dto.MemDTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.CreateController;

public class MainService implements IMainService {

	Parent root;   // 로그인 컨트롤러 루트 
	Parent createRoot = null;   // 회원가입 컨트롤러 루트 
	AlertCommon ac = new AlertCommon();
	IDBService db;
	int result;
	
	public MainService() {
		db = new DBService();
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	

	
	@Override
	public void login() {
		System.out.println("Sign In has clicked");
		TextField id = (TextField)root.lookup("#fxId");
		TextField pw = (TextField)root.lookup("#fxPwd");
		
		MemDTO dto = db.chkId(id.getText());
		if(dto != null) {
			if(dto.getPassword().equals(pw.getText())) {
				ac.confirmMsg("로그인 성공!!!!");
				//나의페이지로 이동 ?
				
			}else {
				ac.errorMsg("비밀번호가 틀렸습니다.");
			}
		}else {
			ac.errorMsg("존재하지 않는 아이디 입니다.");
		}
	}

public void createPage() {
	System.out.println("로그인 창에서 Sign Up has been clicked");
	//	Stage stage = new Stage();  새 창으로 이동..
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/CreateView.fxml"));
	
			try {
				createRoot = loader.load();  //initialize가 여기서 실행됨 
			} catch (Exception e) {
				e.printStackTrace();			
			}
			CreateController ctrl =  loader.getController();
			ctrl.setRoot(createRoot);
			
			Scene scene = new Scene(createRoot);
			Stage s = (Stage)root.getScene().getWindow();
			s.setScene(scene);   //위를 createRoot가 아닌 root로 하니까 창 뜸 
			s.show();
			System.out.println("문제없습니다~");
			
	//		stage.setScene(scene);
	//		stage.show();
}
	
	@Override
	//회원가입 
	public void createAcc() {		
		System.out.println("회원가입 창에서 Sign Up has been clicked");
		
		createVal();   
		String gender = getGenderCom();
		System.out.println(gender);
		
	}
	
	public void genderCom() {
		ComboBox<String> gender = (ComboBox<String>)root.lookup("#fxGender");
		if (gender != null) {
			gender.getItems().addAll("Female", "Male", "Other");
		} 
	}
	
	private void createVal() {
		TextField id = (TextField)root.lookup("#fxId"); 
		System.out.println("입력한 아이디  : " + id.getText());
		TextField pwd = (TextField)root.lookup("#fxPwd");
		System.out.println("비번:" + pwd.getText());
		TextField pwd2 = (TextField)root.lookup("#fxPwd2");
		System.out.println("비번확인: " + pwd2.getText());
		TextField fName = (TextField)root.lookup("#fxFName");
		System.out.println("이름 : " + fName.getText());
		TextField lName = (TextField)root.lookup("#fxLName");
		System.out.println("성:" + lName.getText());
		TextField email = (TextField)root.lookup("#fxEmail");
	
		if(!id.getText().isEmpty()) {
			//일단 아이디값이 primary key니까, 중복이 있는지 없는지 확인 후 나머지 다 등록!
			MemDTO d = db.chkId(id.getText()); 
			if(d == null) {
				MemDTO dto = new MemDTO();
				if(pwd.getText().equals(pwd2.getText())) {  
					dto.setId(id.getText());   
					dto.setPassword(pwd.getText());
					dto.setfName(fName.getText());
					dto.setlName(lName.getText());	
					dto.setGender(getGenderCom());
					dto.setEmail(email.getText());
					
					db.insertMem(dto);
					ac.confirmMsg("회원가입이 완료되었습니다!");
					//회원가입 성공 시 창에 입력된 값들 지우기~
					id.clear();
					pwd.clear();
					pwd2.clear();
					lName.clear();
					fName.clear();
					email.clear();
				} else {
					ac.errorMsg("비밀번호가 서로 다릅니다");
				}
			} else {
				ac.errorMsg("이미 등록된 아이디입니다.");
			}		
		} else {
			ac.errorMsg("Username을 입력해 주세요.");
		}
	}
	
	private String getGenderCom() {
		ComboBox<String> gender = (ComboBox<String>) root.lookup("#fxGender");
		String a = null;
		if (gender.getValue() == null) {
			ac.errorMsg("Please select Gender");
		} else {
			a = gender.getValue();
		}
		return a;
	}
	


}
