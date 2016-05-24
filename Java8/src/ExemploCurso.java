import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class ExemploCurso { 
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Java 8",200));
		cursos.add(new Curso("Ruby on Rails",187));
		cursos.add(new Curso("Python",50));
		cursos.add(new Curso("C",4));
		
		cursos.sort(Comparator.comparing(Curso::getNome));
		//cursos.forEach(System.out::println); não da pra explicitar o que será impresso
		cursos.forEach(c -> System.out.println(c.getNome() + " " + c.getAlunos()));
		 
		
		cursos.stream()
			.filter(c -> c.getAlunos()>=100)
			.forEach(c -> System.out.println(c.getNome()));

		
		cursos.stream()
			.filter(c -> c.getAlunos()>=100)
			.sorted(Comparator.comparing(Curso::getAlunos))
			.map(c -> c.getAlunos())
			.forEach(alunos -> System.out.println(alunos));

		
		Optional<Curso> optionalCurso = 
				cursos.stream()
					.filter(c -> c.getAlunos()>=100)
					.findAny();
		
		Curso cursoOrElse = optionalCurso.orElse(null);
		System.out.println(cursoOrElse.getNome());
		
		optionalCurso.ifPresent(curso -> System.out.println(curso.getNome()));
		
		OptionalDouble average = 
			cursos.stream()
				.filter(c -> c.getAlunos()>=100)
				.mapToDouble(c -> c.getAlunos())
				.average();
		
		System.out.println("Nova Lista");
		List<Curso> cursos2 = 
				cursos.stream()
					.filter(c -> c.getAlunos()>=100)
					.collect(Collectors.toList());
		cursos2.forEach(c -> System.out.println(c.getNome()));

		System.out.println("Nova Map");
		Map<String, Integer> mapCursos = 
				cursos.stream()
					.filter(c -> c.getAlunos()>=100)
					.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
		System.out.println(mapCursos);


	}
}

class Curso {
	private String nome;
	private int alunos;
	
	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;		
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}
}


