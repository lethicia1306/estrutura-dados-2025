import java.util.Random;

public class Calculadoradimensao {
    protected static final int X = 1, O = -1;
    protected static final int VAZIO = 0;
    protected int tabuleiro[][];
    protected int jogador;
    protected int dms;

    public Calculadoradimensao(int dimensao) {
        limpaTabuleiro();
        this.tabuleiro = new int[dimensao][dimensao];
        this.dms = dimensao;
    };

    public void limpaTabuleiro() {
        for (int l = 0; l < dms; l++) {
            for (int c = 0; c < dms; c++) {
                tabuleiro[l][c] = VAZIO;
            }
        }
        jogador = X;
    };

    public void poePeca(int l, int c) {
        if (l < 0 || l > 4 || c < 0 || c > 4) {
            throw new IllegalArgumentException("Esta posição é inválida para por peça");
        }
        if (tabuleiro[l][c] != VAZIO)
            throw new IllegalArgumentException("Esta posição está ocupada");
        tabuleiro[l][c] = jogador;

        jogador = -jogador;
    }

    public int[] gerarLinhaColuna() {
        Random gerador = new Random();
        int linha = gerador.nextInt(0, dms);
        int coluna = gerador.nextInt(0, dms);
        return new int[] { linha, coluna };
    }

    public int poePecaAutomatico() {
        int[] posicao = gerarLinhaColuna();
        while (tabuleiro[posicao[0]][posicao[1]] != VAZIO) {
            posicao = gerarLinhaColuna();
        }
        tabuleiro[posicao[0]][posicao[1]] = jogador;
        int acabou = vencedor();

        if (acabou == 1) {
            return 1;
        } else if (acabou == -1) {
            return -1;
        } else if (acabou == 0) {
            return 0;
        } 

        jogador = -jogador;
        return 2;
    }

    public boolean descVencedor(int marca) {
        int somaDiagonal1 = 0;
        int somaDiagonal2 = 0;
        for (int l = 0; l < dms; l++) {
            int somaLinha = 0;
            for (int c = 0; c < dms; c++) {
                somaLinha += tabuleiro[l][c];
                if (l == c) {
                    somaDiagonal1 += tabuleiro[l][c];
                }

                if (l + c == 2) {
                    somaDiagonal2 += tabuleiro[l][c];
                }
            }
            if (somaLinha == marca * dms) {
                return true;
            }
        }

        if (somaDiagonal1 == marca * dms) {
            return true;
        }

        if (somaDiagonal2 == marca * dms) {
            return true;
        }

        for (int c = 0; c < dms; c++) {
            int somaColuna = 0;
            for (int l = 0; l < dms; l++) {
                somaColuna += tabuleiro[l][c];
            }
            if (somaColuna == marca * dms) {
                return true;
            }
        }

        return false;
    }

    public int vencedor() {
        if (descVencedor(X)) {
            return X;
        } else if (descVencedor(O)) {
            return O;
        } else {
            for (int l = 0; l < dms; l++) {
                for (int c = 0; c < dms; c++) {
                    if (tabuleiro[l][c] == VAZIO) {
                        return 2;
                    }
                }
            }
        }
        return 0;
    }

    public String toString() {
        String j = "";
        for (int l = 0; l < dms; l++) {
            for (int c = 0; c < dms; c++) {
                switch (tabuleiro[l][c]) {
                    case X:
                        j += "X";
                        break;
                    case O:
                        j += "O";
                        break;
                    case VAZIO:
                        j += " ";
                        break;
                }
                if (c < dms - 1)
                    j += "|"; // limite da coluna
            }
            if (l < dms - 1) {
                String tracos = "-".repeat(dms * 2 - 1); // limite da linha
                j += "\n" + tracos + "\n"; // limite da linha
            }
        }
        return j;
    }

    public int getJogador() {
        return jogador;
    }
}
