
public class Main {

	public static void main(String[] args) {
		// 1. 기존의 방법 
		LGCDPlayer lgcdPlater = new LGCDPlayer();
		lgcdPlater.play();
		lgcdPlater.stop();
		lgcdPlater.prev();
		lgcdPlater.next();
		System.out.println("-----구분선------");
		
		// 2. IS A 관계를 이용한 방법
		// 관계의 정의 
		// Sub class is a Super class
		// LGCDPlayer is a CDPlayer
		CDPlayer lgPlayer = new LGCDPlayer();
		lgPlayer.play();
		lgPlayer.stop();
		lgPlayer.prev();
		lgPlayer.next();
		lgcdPlater.shuffle();
		System.out.println("-----구분선------");
		
		CDPlayer samsungPlayer = new SamsungCDPlayer();
		samsungPlayer.play();
		samsungPlayer.stop();
		samsungPlayer.prev();
		samsungPlayer.next();
	}
}
