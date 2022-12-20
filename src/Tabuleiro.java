public class Tabuleiro {

    private char symbol;

    public Tabuleiro() {
        this.symbol = ' ';
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        if(this.symbol == ' ') {
            this.symbol = symbol;
        } else
            System.out.println("Este campo já foi utilizado");
    }
}
