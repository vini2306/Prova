package aplicativos;

import java.io.IOException;
import java.util.Scanner;
import Classes.Pessoa;

public class AppPilotos {

    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 20;
        int opcao, qtdCadastrados = 0;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;

                    
                    
                }

                Pessoa piloto = new Pessoa();
                
                System.out.print("Nome do piloto: ");
                piloto.setNome(in.nextLine());

                System.out.print("CPF do piloto: ");
                piloto.setCpf(in.nextLine());

                System.out.print("Brevê do piloto: ");
                piloto.setBrevê(in.nextLine());  
                
                pilotos[qtdCadastrados] = piloto;

                //Cadastre seu piloto aqui

                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(in);
                qtdCadastrados = qtdCadastrados +1;
            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há motoristas cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                // Exiba os pilotos aqui
                
                 System.out.println("===================");
                 System.out.println("LISTAGEM DE PILOTOS");
                 System.out.println("===================");

                 for (int i = 0; i < qtdCadastrados; i++) {
                   Pessoa piloto = pilotos [i];
                    System.out.printf("Nome do piloto: %s - CPF do piloto: %s - Brevê do piloto: %s\n",
                     piloto.getNome(), piloto.getCpf(), piloto.getBrevê());
                    
                 }
                voltarMenu(in);

                
                } else if (opcao == 3) { 
                System.out.print("Por favor, digite o cpf: ");
                String CPFdigitado = (in.nextLine());
                for(int i = 0; i < qtdCadastrados; i++){
                  Pessoa piloto = pilotos [i];
                if(piloto.getCpf() == CPFdigitado);
                System.out.printf("Nome: %s - CPF: %s - Brevê: %s \n",piloto.getNome(), piloto.getCpf(),
                piloto.getBrevê());
                continue;
                } 
                }
                

            else if (opcao == 4) {
            
                }                
            
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}