package com.collection.list.music.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.collection.list.music.model.vo.Music;

public class MusicManager {
	
	Scanner sc = new Scanner(System.in);
	private List<Music> mList = new ArrayList<Music>();
	// 초기화 블럭을 사용하여 5곡을 미리 만들어두기
	{
	       mList.add(new Music("고백" , "포맨"));
	       mList.add(new Music("겨울이야기" , "포맨"));
	       mList.add(new Music("이름에게" , "아이유"));
	       mList.add(new Music("블루밍" , "아이유"));
	       mList.add(new Music("선물" , "윤미래"));
	       
	}      
	//1. 음악리스트 리턴
	public List <Music> selectList(){
		return mList;
	}
	
	//2. 마지막에 음악추가 : 사용자로부터 곡명과 가수를 입력받아 리스트에 저장하는 메소드
	public void addList(Music m) {
		mList.add(m);
		
	}
	//3. 맨처음에 음악추가 : 리스트 최상위(0번지)에 음악을 추가하는 메소드
	public void addAtZero(Music m) {
		mList.add(0,m);
	}
	//4. 특정곡을 삭제하는 메소드(제목을 전달받아 검색후, 최초로 검색된 음악을 삭제)
	삭제여부를 리턴
	public boolean removeMusic(String s) {
		
		if(mList.contains(new Music(s,""))) {
			int delIdx = mList.indexOf(new Music(s,""));
			mList.remove(delIdx);
			return true;
		}
		else System.out.println("검색하신 제목의 곡은 없습니다.");
		return false;
	}

	


}
