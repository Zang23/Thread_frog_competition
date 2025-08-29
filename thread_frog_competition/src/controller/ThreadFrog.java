package controller;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadFrog extends Thread{

	private int limitePulo;
	private int idSapo;
	private int totalPulado = 0;
	private static AtomicInteger contadorColocacao = new AtomicInteger(0);
	private int minhaColocacao = 0;
	
	public ThreadFrog(int limitePulo, int idSapo, int totalPulado) {
		this.limitePulo = limitePulo;
		this.idSapo = idSapo;
		this.totalPulado = totalPulado;
	}
	
	
	
	public void run() {
		int distanciaMaxima = 50;
		
		while(totalPulado < distanciaMaxima) {
			int tamanhoPulo = pulaSapo(limitePulo);
			totalPulado +=  tamanhoPulo;
			
			StringBuffer buffer = new StringBuffer();
			buffer.append("Sapo ").append(idSapo).append(": Pulou nesta rodada: ").append(tamanhoPulo).append(" - Total pulado: ").append(totalPulado);
			System.out.println(buffer);	
		}
		
		if(totalPulado >= distanciaMaxima && minhaColocacao == 0) {
			minhaColocacao = contadorColocacao.incrementAndGet();
			System.out.println("Sapo " + idSapo + " Chegou em " + minhaColocacao + "° lugar" );
		}
		
		
	}
	
	
	private int pulaSapo(int limitePulo) {
		int tamanhoPulo = (int) (Math.random()  * limitePulo+1);
		return tamanhoPulo;
	}
	
	
	
	
}
