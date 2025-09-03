package controller;


public class ThreadFrog extends Thread{

	private int limitePulo;
	private int idSapo;
	private int totalPulado = 0;
	private double tempoChegada;
	private boolean chegou = false;
	private double[] resultado;
	
	public ThreadFrog(int limitePulo, int idSapo, int totalPulado, double[] resultado) {
		this.limitePulo = limitePulo;
		this.idSapo = idSapo;
		this.totalPulado = totalPulado;
		this.resultado = resultado;
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
		
		tempoChegada = System.nanoTime();
		resultado[idSapo - 1] = tempoChegada;
		chegou = true;
		
	}
	
	
	private int pulaSapo(int limitePulo) {
		int tamanhoPulo = (int) (Math.random()  * limitePulo+1);
		return tamanhoPulo;

	}
	
	public boolean isChegou() {
		return chegou;
	}
	
}
