import java.util.Random;

public class Computador extends Jogador {
    private final Random random;

    public Computador(int jogador) {
        super(jogador);
        this.random = new Random();
        System.out.println("Jogador 'Computador' criado!");
    }

    @Override
    public void jogar(Tabuleiro tabuleiro) {
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
        System.out.println("Computador jogou em: Linha " + (tentativa[0] + 1) + ", Coluna " + (tentativa[1] + 1));
    }

    @Override
    public void Tentativa(Tabuleiro tabuleiro) {
        do {
            tentativa[0] = random.nextInt(3);
            tentativa[1] = random.nextInt(3);
        } while (!checaTentativa(tentativa, tabuleiro));
    }
}
