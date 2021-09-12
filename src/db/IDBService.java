package db;

import dto.MemDTO;

public interface IDBService {

	//id값으로 (primary key) 중복인지 아닌지 확인
	public MemDTO chkId(String id);
	
	// 중복이 아니면 나머지 값 모두 insert하여 회원가입 
	public void insertMem(MemDTO d);
	
}
