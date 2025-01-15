import java.util.Scanner;

public class Jogo {
    private int rodada=1, vez=1;
    private Jogador jogador1;
    private Jogador jogador2;
    public Scanner entrada = new Scanner(System.in);
    Tabuleiro tabuleiro = new Tabuleiro();
    
    public void iniciarJogadores(){
        System.out.println("Quem vai ser o Jogador 1 ?");
        int iOpcaoEscolhida = escolherJogador();
        this.jogador1 = iOpcaoEscolhida == 1 ? new Humano(1) : new Computador(2);

        System.out.println("----------------------");
        System.out.println("Quem vai ser o Jogador 2 ?");
        
        this.jogador2 = (iOpcaoEscolhida == 2) ? new Humano(2) : new Computador(2);     
    }
    
    public int escolherJogador(){
        int iOpcao = 0;
        
        do{
            System.out.println("1. Humano");
            System.out.println("2. Computador\n");
            System.out.print("Opção: ");
            iOpcao = entrada.nextInt();
            
            if(iOpcao != 1 && iOpcao != 2)
                System.out.println("Opção inválida! Tente novamente");
        }while(iOpcao != 1 && iOpcao != 2);
        
        return iOpcao;
    }
    
    public void Jogar(){
        boolean lResultadoJogo = true;
        while (lResultadoJogo) { 
            if(ganhou() == 0){
                System.out.println("----------------------");
                System.out.println("\nRodada " + rodada);
                System.out.println("É a vez do jogador " + vez());
                
                if(vez() == 1)
                    jogador1.jogar(tabuleiro);
                else
                    jogador2.jogar(tabuleiro);
                
                if(tabuleiro.tabuleiroCompleto()){
                    System.out.println("Tabuleiro Completo. Jogo empatado");
                    lResultadoJogo = false;
                }
    
                vez++;
                rodada++;
    
            } else {
                if(ganhou() == -1)
                    System.out.println("Jogador 1 ganhou!");
                else
                    System.out.println("Jogador 2 ganhou!");
    
                lResultadoJogo = false;
            }
        }      
    }
    
    
    public int vez(){
        if(vez%2 == 1)
            return 1;
        else
            return 2;
    }
    
    public int ganhou(){
        if(tabuleiro.checaLinhas() == 1)
            return 1;
        if(tabuleiro.checaColunas() == 1)
            return 1;
        if(tabuleiro.checaDiagonais() == 1)
            return 1;
        
        if(tabuleiro.checaLinhas() == -1)
            return -1;
        if(tabuleiro.checaColunas() == -1)
            return -1;
        if(tabuleiro.checaDiagonais() == -1)
            return -1;
        
        return 0;
    }
    
    
}
