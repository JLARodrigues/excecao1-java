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
		
		System.out.println("Quarto número: ");
		int numero = sc.nextInt();
		System.out.print("Check-in data (dd/MM/yyy)");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-out data (dd/MM/yyy)");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro a data de saída é anterior à de chegada. ");
		}
		else {
			Reservas reservas = new Reservas(numero, checkIn, checkOut);
			System.out.println("Reservas: " + reservas);
			
			System.out.println();
			System.out.println("Entre com a data para atualização: ");
			System.out.println("Check-in data (dd/MM/yyyy):");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-out data (dd/MM/yyy)");
			checkOut = sdf.parse(sc.next());
			
			
			Date agora = new Date();
			if (checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println("Erro na reserva: a reserva está sendo feita para datas futuras. ");
			}
			else if (!checkOut.after(checkIn)){
			    System.out.println("Erro na reserva: Check-out data precisa ser depois do check-in data.");
			    String erro = reservas.atualData(checkIn, checkOut);
			    if (erro != null) {
			    	System.out.println("Erro na reserva: " + erro);
			    }
			    else {
			    	reservas.atualData(checkIn, checkOut);
			    	System.out.println("Reserva: " + reservas);
			    }
			}
			
			sc.close();

	}
            
}
}
