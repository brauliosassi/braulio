package braulio.sassi.atividade04;

public class Motor {

     	private int qtdPistao;
	private int potencia;

	/*public Motor(Motor potencia2, Motor qtdPistao) {
		
	}*/

	public Motor(){
    		this.potencia = 0;
       		this.qtdPistao = 0;
    	}

	public Motor (int potencia, int qtdPistao){
	     	   this.potencia = potencia;
      		   this.qtdPistao = qtdPistao;
    	}

	public int getQtdPis() {
		  return qtdPistao;
	}

	public void setQtdPis(int qtdPistao) {
		   this.qtdPistao = qtdPistao;
	}

	public int getPotencia() {
			return potencia;
	}

	public void setPotencia(int potencia) {
			this.potencia = potencia;
	}

}
