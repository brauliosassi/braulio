package braulio.sassi.atividade04;

public final class Carga extends Veiculo implements Calc{
    
    private int cargaMax;
    private int tara;
    
    public Carga() {
    	tara = 0;
	cargaMax = 0;
    }

//==========================================================
    public void calcVel() {	 
	 float x = (getVelocMax()*10000);
	System.out.println("\nVelocidade CARGA:: "+x+"CM/H");
    }
//==========================================================    
    public int calcular(){
	int somaNum = 0;
	somaNum+=getMotor().getQtdPis();
	somaNum+=getMotor().getPotencia();
	somaNum+= getQtdRodas();
	somaNum+= getVelocMax();
	somaNum+= getTara();
	somaNum+= getCargaMax();

    return somaNum;
}
//==========================================================    			
    public int getCargaMax(){
        return cargaMax;
    }
    public void setCargaMax(int cargaMax){
        this.cargaMax = cargaMax;
    }
    public int getTara(){
        return tara;
    }
    public void setTara(int tara){
        this.tara = tara;
    }

}
