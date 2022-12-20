import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Tabuleiro[][] jogoVelha  = new Tabuleiro[3][3];
        char currentSymbol = 'X';
        boolean game = true;
        char win = ' ';

        iniciaJogo(jogoVelha);

        while(game) {
            desenhaTabuleiro(jogoVelha);
            win = verificarVitoria(jogoVelha);
            if(win != (' ')) {
                System.out.printf("Jogador %s venceu!%n", win);
                break;
            }
            try {
                if(verificarJogada(jogoVelha, jogar(sc, currentSymbol), currentSymbol)) {
                    if(currentSymbol == 'X') {
                        currentSymbol = 'O';
                    } else {
                        currentSymbol = 'X';
                    }
                }

            }catch(Exception e) {
                System.out.println("ERRO");
            }
        }
    }

    public static void desenhaTabuleiro(Tabuleiro[][] jogoVelha) {
        limpaTela();
        System.out.println("     0   1   2");
        System.out.printf ("0    %c | %c | %c \n", jogoVelha[0][0].getSymbol(), jogoVelha[0][1].getSymbol(), jogoVelha[0][2].getSymbol());
        System.out.printf ("1    %c | %c | %c \n", jogoVelha[1][0].getSymbol(), jogoVelha[1][1].getSymbol(), jogoVelha[1][2].getSymbol());
        System.out.printf ("2    %c | %c | %c \n", jogoVelha[2][0].getSymbol(), jogoVelha[2][1].getSymbol(), jogoVelha[2][2].getSymbol());
    }

    public static void limpaTela() {
        for(int i = 0; i < 200; i++){
            System.out.println("");
        }
    }

    public static int[] jogar(Scanner sc, char cs) {
        int p[] = new int[2];
        System.out.printf("%s %c%n", "Quem joga: ", cs);
        System.out.print("Informe a linha: ");
        p[0] = sc.nextInt();
        System.out.print("Informe a coluna: ");
        p[1] = sc.nextInt();
        return p;
    }

    public static boolean verificarJogada(Tabuleiro[][] jogoVelha, int[] p, char currentSymbol) {
        if(jogoVelha[p[0]][p[1]].getSymbol() == ' ') {
            jogoVelha[p[0]][p[1]].setSymbol(currentSymbol);

            return true;
        } else
            return false;
    }

    public static void iniciaJogo(Tabuleiro[][] jogoVelha){
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++){
                jogoVelha[i][j] = new Tabuleiro();
            }
        }


    }

    public static char verificarVitoria(Tabuleiro[][] jogoVelha){
        for(int i=0;i<3;i++){
            if((jogoVelha[i][0].getSymbol()=='X' && jogoVelha[i][1].getSymbol()=='X' && jogoVelha[i][2].getSymbol()=='X')||(jogoVelha[i][0].getSymbol()=='O' && jogoVelha[i][1].getSymbol()=='O' && jogoVelha[i][2].getSymbol()=='O')) {
                return jogoVelha[i][0].getSymbol();
            }
        }
        for(int i=0;i<3;i++){
            if((jogoVelha[0][i].getSymbol()=='X' && jogoVelha[1][i].getSymbol()=='X' && jogoVelha[2][i].getSymbol()=='X')||(jogoVelha[0][i].getSymbol()=='O' && jogoVelha[1][i].getSymbol()=='O' && jogoVelha[2][i].getSymbol()=='O')) {
                return jogoVelha[0][i].getSymbol();
            }
        }
        if((jogoVelha[0][0].getSymbol()=='X' && jogoVelha[1][1].getSymbol()=='X' && jogoVelha[2][2].getSymbol()=='X')||(jogoVelha[0][2].getSymbol()=='O' && jogoVelha[1][1].getSymbol()=='O' && jogoVelha[2][0].getSymbol()=='O')) {
            return jogoVelha[0][0].getSymbol();
        }
        return ' ';
    }
}
