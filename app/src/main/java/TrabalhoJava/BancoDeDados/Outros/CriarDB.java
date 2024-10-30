package TrabalhoJava.BancoDeDados.Outros;

import java.io.File;
import java.io.IOException;

public class CriarDB {
    public static final String localbanco = "banco.data";
    public static boolean bancoExiste() {
        File file = new File(localbanco);
        return file.exists();
    }

    public static void criarArquivo() {
            File file = new File("banco.data");
            try {
                if (file.createNewFile()) {
                    System.out.println("Arquivo criado em: " + localbanco);
                } else {
                    System.out.println("Falha ao criar o arquivo.");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
