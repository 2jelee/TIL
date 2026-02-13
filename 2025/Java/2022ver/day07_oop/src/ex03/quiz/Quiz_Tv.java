package ex03.quiz;

/*
[문제] TV class
채널, 색상, 소리 
 */

public class Quiz_Tv {
	//멤버변수
	private String channel, color;	//채널, 색상
	private int volumn;				//소리
	
	//생성자함수
	public Quiz_Tv() {
		channel = "KBS";
		color = "gray";
		volumn = 10;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getVolumn() {
		return volumn;
	}

	public void setVolumn(int volumn) {
		this.volumn = volumn;
	}
	
	public void display() {
		System.out.println("채널 : " + channel + " / 색상 : " +color+ " / 소리 : "+volumn);
	}
	
	public static void main(String[] args) {
		Quiz_Tv tv = new Quiz_Tv();
		tv.display();
	}
}
