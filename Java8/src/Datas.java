import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {

	public Datas() {
	}

	public static void main(String[] args) {
		
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		LocalDate olimpiadas =  LocalDate.of(2016, Month.JULY, 5);
	
		Period periodo = Period.between(hoje, olimpiadas);
		System.out.println("Falta :" + 
							periodo.getYears() + " anos, " +
							periodo.getMonths() + " meses e " +
							periodo.getDays() + " dias" );
		
		
		LocalDate proximasolimpiadas = olimpiadas.plusYears(4);
		System.out.println(proximasolimpiadas);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String valorFormatado = proximasolimpiadas.format(dtf);
		System.out.println(valorFormatado);
		 
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(dtf2));
		
		LocalTime horaIntervalo = LocalTime.of(15, 30);
		System.out.println(horaIntervalo);
		
	}

}
