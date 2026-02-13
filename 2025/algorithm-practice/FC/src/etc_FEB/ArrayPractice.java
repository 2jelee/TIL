package etc_FEB;
  
import java.util.*;


public class ArrayPractice {
	public static void main(String[] args) {
//		ArrayList<Integer> dataset = new ArrayList<Integer>();
		
		String dataset[] = {
		    "Braund, Mr. Owen Harris",
		    "Cumings, Mrs. John Bradley (Florence Briggs Thayer)",
		    "Heikkinen, Miss. Laina",
		    "Futrelle, Mrs. Jacques Heath (Lily May Peel)",
		    "Allen, Mr. William Henry",
		    "Moran, Mr. James",
		    "McCarthy, Mr. Timothy J",
		    "Palsson, Master. Gosta Leonard",
		    "Johnson, Mrs. Oscar W (Elisabeth Vilhelmina Berg)",
		    "Nasser, Mrs. Nicholas (Adele Achem)",
		    "Sandstrom, Miss. Marguerite Rut",
		    "Bonnell, Miss. Elizabeth",
		    "Saundercock, Mr. William Henry",
		    "Andersson, Mr. Anders Johan",
		    "Vestrom, Miss. Hulda Amanda Adolfina",
		    "Hewlett, Mrs. (Mary D Kingcome) ",
		    "Rice, Master. Eugene",
		    "Williams, Mr. Charles Eugene",
		    "Vander Planke, Mrs. Julius (Emelia Maria Vandemoortele)",
		    "Masselmani, Mrs. Fatima",
		    "Fynney, Mr. Joseph J",
		    "Beesley, Mr. Lawrence",
		    "McGowan, Miss. Anna",
		    "Sloper, Mr. William Thompson",
		    "Palsson, Miss. Torborg Danira",
		    "Asplund, Mrs. Carl Oscar (Selma Augusta Emilia Johansson)",
		    "Emir, Mr. Farred Chehab",
		    "Fortune, Mr. Charles Alexander",
		    "Dwyer, Miss. Ellen",
		    "Todoroff, Mr. Lalio"
		}; 
		
		System.out.println("toString 메소드 사용 : " + Arrays.toString(dataset));
		System.out.println("배열 dataset에 들어있는 아이템 갯수 : " + dataset.length);
		
		// "M"이 들어있는 값을 찾아서 갯수를 하나씩 증가시켜줄 변수
		Integer count = 0;
		
		for(Integer item = 0; item<dataset.length; item++) {
			if(dataset[item].indexOf("M") >= 0) {
				count++;
			}
//				System.out.println("indexof 사용 : " + dataset[item].indexOf("M"));
		}
		System.out.println(count);
 
		System.out.println("===========================");
		
		int cnt=0;
		for(int i=0; i<dataset.length; i++) {
			if(dataset[i].indexOf("M") >= 0) {
				cnt++;
			}
		}
		System.out.println("cnt로 변환 : " + cnt);
	}
}
