package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.exception.DomainException;
import modelo.entidades.Reservas;

public class Programa {


	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		System.out.println("Quarto número: ");
		int numero = sc.nextInt();
		System.out.print("Check-in data (dd/MM/yyy)");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-out data (dd/MM/yyy)");
		Date checkOut = sdf.parse(sc.next());
		
		Reservas reservas = new Reservas(numero, checkIn, checkOut);
		System.out.println("Reservas: " + reservas);
		
		System.out.println();
		System.out.println("Entre com a data para atualização: ");
		System.out.println("Check-in data (dd/MM/yyyy):");
		checkIn = sdf.parse(sc.next());
		System.out.println("Check-out data (dd/MM/yyy)");
		checkOut = sdf.parse(sc.next());
		
		reservas.atualData(checkIn, checkOut);
		System.out.println("Reserva: " + reservas);
		}
		catch(ParseException e) {
			System.out.println("Data com formato inválido.");
		}
		catch(DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		
			
		sc.close();

}
}
            

