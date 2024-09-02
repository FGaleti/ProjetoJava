package cursojava.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;
import cursojava.constantes.StatusAluno;

public class PrimeiraClasseJava {

	public static void main(String[] args) {

		String login = JOptionPane.showInputDialog("Informe o login ");
		String senha = JOptionPane.showInputDialog("Informe a senha ");

		if (login.equalsIgnoreCase("Admin") && senha.equalsIgnoreCase("Admin")) {

			List<Aluno> alunos = new ArrayList<Aluno>();
			/*
			 * é uma lista que dentro dela temos uma chave que identifica uma sequencia de
			 * valores também
			 */
			HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

			for (int qtd = 0; qtd <= 1; qtd++) {

				/* Objeto ainda não salvo na memória */
				/* new Aluno() é uma instancia (criação de objeto) */
				/* primeiro é uma referência ao "Aluno" */

				String nome = JOptionPane.showInputDialog("Qual o nome do aluno " + qtd + "?");

				String idade = JOptionPane.showInputDialog("Qual a Idade ? ");
				String DataNascimento = JOptionPane.showInputDialog("Qual a Data de Nascimento ? ");
				String RegistroGeral = JOptionPane.showInputDialog("Qual o RG ? ");
				String NumeroCpf = JOptionPane.showInputDialog("Qual o CPF ? ");
				String NomeMae = JOptionPane.showInputDialog("Qual o Nome da mãe ? ");
				String NomePai = JOptionPane.showInputDialog("Qual o Nome do Pai? ");
				String DataMatricula = JOptionPane.showInputDialog("Qual a Data da Matricula ? ");
				String SerieMatriculada = JOptionPane.showInputDialog("Qual a Série Matriculada ? ");
				String NomeEscola = JOptionPane.showInputDialog("Qual o Nome da Escola ? ");

				Aluno aluno1 = new Aluno();

				aluno1.setNome(nome);

				aluno1.setIdade(Integer.valueOf(idade));
				aluno1.setDataNascimento((DataNascimento));
				aluno1.setRegistroGeral((RegistroGeral));
				aluno1.setNumeroCpf((NumeroCpf));
				aluno1.setNomeMae(NomeMae);
				aluno1.setNomePai(NomePai);
				aluno1.setDataMatricula((DataMatricula));
				aluno1.setSerieMatriculada(SerieMatriculada);
				aluno1.setNomeEscola(NomeEscola);

				/* Quantidade de disciplinas */
				for (int pos = 1; pos <= 1; pos++) {
					String nomeDisciplina = JOptionPane.showInputDialog("Qual a disciplina  " + pos + " ?");
					String notaDisciplina = JOptionPane.showInputDialog("Qual a nota " + pos + "?");

					Disciplina disciplina = new Disciplina();
					disciplina.setDisciplina(nomeDisciplina);
					disciplina.setNota(Double.valueOf(notaDisciplina));

					aluno1.getDisciplinas().add(disciplina);

					System.out.println(aluno1.toString());// Descrição de objeto na memória
					System.out.println(aluno1.getAlunoAprovado2());
					System.out.println(aluno1.getMediaNota());

				}

				int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina ? ");
				if (escolha == 0) {
					/* SIM = 0 */
					int continuarRemover = 0;
					int posiçao = 1;
					while (continuarRemover == 0) {
						String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina 1,2,3,4 ? ");
						aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posiçao);
						posiçao++;
						continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar removendo ? ");
					}
				}
				alunos.add(aluno1);
			}
			maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
			maps.put(StatusAluno.RECUPERAÇAO, new ArrayList<Aluno>());
			maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());

			for (Aluno aluno : alunos) {

				if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
					maps.get(StatusAluno.APROVADO).add(aluno);
				} else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERAÇAO)) {
					maps.get(StatusAluno.RECUPERAÇAO).add(aluno);
				} else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.REPROVADO)) {
					maps.get(StatusAluno.REPROVADO).add(aluno);
				}
			}

			System.out.println("------------------------Lista dos Aprovados ---------------------------------");
			for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
				System.out.println(aluno.getNome() + " Resultado : " + aluno.getAlunoAprovado2());
			}

			System.out.println("------------------------Lista dos Recuperaçao --------------------------------");
			for (Aluno aluno : maps.get(StatusAluno.RECUPERAÇAO)) {
				System.out.println(aluno.getNome() + " Resultado : " + aluno.getAlunoAprovado2());
			}

			System.out.println("------------------------Lista dos Reprovados ----------------------------------");
			for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
				System.out.println(aluno.getNome() + " Resultado : " + aluno.getAlunoAprovado2());

			}
		}
	}
}
