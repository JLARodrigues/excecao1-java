package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reservas;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Quarto n�mero: ");
		int numero = sc.nextInt();
		System.out.println("Check-in data (dd/MM/yyy)");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-out data (dd/MM/yyy)");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro a data de sa�da � anterior � de chegada. ");
		}
		else {
			Reservas reservas = new Reservas(numero, checkIn, checkOut);
			System.out.println("Reservas: " + reservas);
			
			System.out.println("Quarto n�mero: ");
			numero = sc.nextInt();
			System.out.println("Check-in data (dd/MM/yyy)");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-out data (dd/MM/yyy)");
			checkOut = sdf.parse(sc.next());
			
			Date agora = new Date();
			if (checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println("A data da reserva precisa ser futura.");
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("As datas da reserva precisam ser futuras");
			}
			else {
			reservas.atualData(checkIn, checkOut);
			System.out.println("Reservas: " + reservas);
		}

	}

}
}