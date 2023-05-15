package braulio.sassi.atividade04;

public final class Passeio extends Veiculo implements Calc{

	private int qtdPassageiros;

	public Passeio() {
		qtdPassageiros = 0;
			
	}

	public Passeio(int qtdPassageiros) {
		this.qtdPassageiros = qtdPassageiros;		
	}
//==========================================================
	public void calcVel() {
		float x = (getVelocMax()*1000);
		System.out.println("\nVelocidade - PASSEIO:: "+x+"M/H");

	}
//==========================================================
	public int calcular(){
		int somaLetras = 0;
		somaLetras+= getPlaca().length();
		somaLetras+= getMarca().length();
		somaLetras+= getModelo().length();
		somaLetras+= getCor().length();	

		return somaLetras;
	}
//==========================================================
	public int getQtdPassageiros() {
		return qtdPassageiros;
	}

	public void setQtdPassageiros(int qtdPAssageiros) {
		this.qtdPassageiros = qtdPAssageiros;
	}

}
