package ex18lambda;

interface IKosmo1
{
	void studyLamdbda(String str);
}
class KosmoStudent1 implements IKosmo1
{
	@Override
	public void studyLamdbda(String str) {
		System.out.println(str + "을(를) 공부합니다.");
	}
}
public class Ex01NormalClass {

	public static void main(String[] args) {

		IKosmo1 kosmo = new KosmoStudent1();
		kosmo.studyLamdbda("람다식");
	}
}
