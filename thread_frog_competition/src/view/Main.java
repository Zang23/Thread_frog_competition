package view;

import controller.ThreadFrog;

public class Main {

	public static void main(String[] args) {
		
		int qSapos = 3;
		double[] resultados = new double[qSapos];
		
		
		ThreadFrog[] sapos = new ThreadFrog[qSapos];
		for(int i = 0; i < qSapos; i++) {
			sapos[i] = new ThreadFrog(5, i+1 , 0, resultados);
			sapos[i].start();
		}
		
		
		while(true) {
			boolean todosChegaram = true;
			for(ThreadFrog sapo : sapos) {
				if(!sapo.isChegou()) {
					todosChegaram = false;
					break;
				}
			}
			
			if(todosChegaram) {
				break;
			}
			
			System.out.println("Verificando corrida...");
			try {
				Thread.sleep(200);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		double[][] posicoes = new double[qSapos][2];
		for(int i = 0; i < qSapos; i++) {
			posicoes[i][0] = i + 1;
			posicoes[i][1] = resultados[i]; 
		}
		
		
		for(int i = 0; i < qSapos - 1; i++) {
		    for(int j = 0; j < qSapos - 1 - i; j++) {
		        if(posicoes[j][1] > posicoes[j + 1][1]) {
		            double auxId = posicoes[j][0];
		            double auxTempo = posicoes[j][1];
		            
		            posicoes[j][0] = posicoes[j + 1][0];
		            posicoes[j][1] = posicoes[j + 1][1];
		            
		            posicoes[j + 1][0] = auxId;
		            posicoes[j + 1][1] = auxTempo;
		        }
		    }
		}

		System.out.println("\nRanking final:");
		for(int i = 0; i < qSapos; i++) {
		    System.out.printf("%d° lugar: Sapo %.0f (%.3f s)\n", i+1, posicoes[i][0], posicoes[i][1]);
		}

		
	}
	
	
		

}
