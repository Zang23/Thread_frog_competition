package view;

import controller.ThreadFrog;

public class Main {

	public static void main(String[] args) {
		
		
		for(int i = 1; i <= 5; i++) {
			ThreadFrog tf = new ThreadFrog(5,i,0);
			tf.start();
		}
		
	}
	
	
		

}
