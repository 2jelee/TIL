package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;

public class SwitchingZari {
	 public static void main(String[] args) {
	        int cnt = 0;
	        
	        HashMap<Integer, String> rMap = new HashMap<Integer, String>();
	        // random 키값으로 사람 이름 넣는 map
	        String[] list = {
		        		             "김병권",  "김성은",  "김용갑",  "김현재",  "나기팔",  "문재웅",  "박영태",  
									 "박한수",  "방명철",  "서승범",  "신지훈",  "안민철",  "엄태광",  "윤은혜",  "이람", 
									 "이유경",  "정경수",  "정민석",  "주재철",  "최민혁",  "홍원기"									 
								 };
	        ArrayList<String[]> pList = new ArrayList<String[]>();
	        // 사람 이름 넣는 list
	        Random r = new Random();
	 
	        pList.add(list);
	        
	        while(true){
	            int rand = r.nextInt(21) + 1;
	            	           
	            if ( cnt == 21 ){
	                break;
	            } 
	    	            
	            if (rMap.containsKey(rand) ) {
	                continue;
	            } else if (!rMap.containsKey(rand)) {
	                rMap.put(rand, pList.get(0)[cnt]);
	                cnt++;
	                continue;
	            }        
	        }
	        
	 
	        Iterator it = rMap.entrySet().iterator();
	        while(it.hasNext()){
	            Entry e = (Entry)it.next();
	            int key = (Integer)e.getKey();
	            try {
	            	Thread.sleep(10);
	            	 System.out.print(key+ " : " + e.getValue() + "\t\t");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
	           
	            
	            if(key% 5 == 0){
	                System.out.println();
	            }  
	        }    
	    }
}
