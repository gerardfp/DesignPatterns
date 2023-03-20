package builder.textbox;

import java.util.Random;

class TextBox {
    String texto;
    int ancho, alto;

    static class Builder {
        String texto;
        int ancho, alto;

        Builder setTexto(String texto) {
            this.texto = texto;
            return this;
        }

        Builder setAncho(int ancho) {
            this.ancho = ancho;
            return this;
        }

        Builder setAlto(int alto) {
            this.alto = alto;
            return this;
        }

        TextBox build() {
            TextBox textBox = new TextBox();
            textBox.texto = texto != null ? texto : "";
            textBox.alto = textBox.texto.isEmpty() ? Math.max(0,alto) : Math.max(1, alto);
            textBox.ancho = textBox.texto.isEmpty() ? Math.max(0,ancho) : Math.max(textBox.texto.length(), ancho);
            return textBox;
        }
    }

    @Override
    public String toString() {
        return "┏" + "━".repeat(ancho) + "┓\n" +
                ("┃" + " ".repeat(ancho) + "┃\n").repeat((alto - 1) / 2) +
                (alto > 0 ? "┃" + " ".repeat((ancho - texto.length() + 1) / 2) + texto + " ".repeat((ancho - texto.length()) / 2) + "┃\n" : "") +
                ("┃" + " ".repeat(ancho) + "┃\n").repeat(alto / 2) +
                "┗" + "━".repeat(ancho) + "┛\n";
    }
}

public class Main {
    public static void main(String[] args) {
        TextBox textBox = new TextBox.Builder()
                .setAncho(25 - new Random().nextInt(50))
                .setAlto(10 - new Random().nextInt(20))
                .setTexto(new Random().nextBoolean() ? "hello world" : null)
                .build();

        System.out.println(textBox);
    }
}