package ex04.util;
import java.text.*;

/*
DecimalFormat ★★★
*/

class DecimalFormatEx1 {
	public static void main(String[] args) throws Exception	{
		double number  = 1234567.89;

		String[] pattern = {
							"0",
							"#",
							"0.0",
							"#.#",
							"0000000000.0000",		//소숫점 4자리까지 표현해라.			>> 0일 경우 0도 표현
							"##########.####",											//	>> (앞, 뒤) 필요없는 0표현 X
							"#.#-",					// - : 부호비트
							"-#.#",
							"#,###.##",
							"#,####.##",
							"#E0",
							"0E0",
							"##E0",
							"00E0",
							"####E0",
							"0000E0",
							"#.#E0",
							"0.0E0",
							"0.000000000E0",
							"00.00000000E0",
							"000.0000000E0",
							"#.#########E0",
							"##.########E0",
							"###.#######E0",
							"#,###.##+;#,###.##-",
							"#.#%",
							"#.#\u2030",
							"\u00A4 #,###",
							"'#'#,###",
							"''#,###",
		};
		
		for(int i=0; i < pattern.length; i++) {
		    DecimalFormat df = new DecimalFormat(pattern[i]);
		    System.out.printf("%19s : %s\n",pattern[i], df.format(number));		// 여기서 19 => 자릿수
		}
	} // main
}