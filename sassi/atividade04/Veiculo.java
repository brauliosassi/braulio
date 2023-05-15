package braulio.sassi.atividade04;

public abstract class Veiculo {

	private String placa;
	private String marca;
	private String modelo;
	private String cor;
	private float velocMax;
	private int qtdRodas;
	private Motor motor;

	public Veiculo() {
		marca = "";
		modelo = "";
		cor = "";
		placa = "";
		velocMax = 0;
		qtdRodas = 0;
		motor = new Motor();

	}

	public Veiculo(String marca, String modelo, String cor, String placa, float velocMax, int qtdRodas, int potencia,
						int qtdPistao) {
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.velocMax = velocMax;
		this.qtdRodas = qtdRodas;
		this.motor = new Motor(potencia, qtdPistao);

	}
	
	public String getPlaca() {
		return placa;
	}

	public final void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public final void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public final void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public final void setCor(String cor) {
		this.cor = cor;
	}

	public float getVelocMax() {
		return velocMax;
	}

	public final void setVelocMax(float velocMax) {
		this.velocMax = velocMax;
	}

	public int getQtdRodas() {
		return qtdRodas;
	}

	public final void setQtdRodas(int qtdRodas) {
		this.qtdRodas = qtdRodas;
	}

	public Motor getMotor() {
		return motor;
	}

	public final void setMotor(Motor motor) {
		this.motor = motor;
	}
	//chamar o metodo pra calcular a km na classe filha
	public abstract void calcVel();

	@Override
	public String toString() {
		return "Veiculo marca " + marca + ", modelo " + modelo + ", placa " + placa + ", cor " + cor
				+ ", velocidade maxima " + velocMax + " km, qtdRodas " + qtdRodas + ", potencia "
				+ motor.getPotencia() + " e quantidade de pistoes " + motor.getQtdPis();
				
	}
}
