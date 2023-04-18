import java.util.Scanner;
public class SeguroDeVida {
	 Scanner scanner = new Scanner(System.in);
	
	 public Double valorSegurado;
	
	public Double tributoSeguro ;
	
	
	 public SeguroDeVida() {
	        System.out.println("Qual valor será segurado?");
	        valorSegurado = scanner.nextDouble();
	        tributoSeguro = valorSegurado * 0.20;
	    }

	    public void mostrarTributo() {
	        System.out.println("O tributo do seguro de vida é: " + tributoSeguro);
	    }
	}
