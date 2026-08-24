public class Exemplo01 {
  public static void main(String[] args) {
    System.out.println("Olá, Turma!");
    for (int i = 2; i <= 20; i += 2) {
      System.out.print(i);
      if (i < 20) {
        System.out.print(", ");
      }
    }
  }
}
