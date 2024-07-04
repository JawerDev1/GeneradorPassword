    import javax.print.DocFlavor;
    import java.security.SecureRandom;
    import java.util.Scanner;

    public class GeneradorPassword {

        private static final String LETRAS_MINUSCULAS = "abcdefghijklmnñopqrstuvwxyz";
        private static final String LETRAS_MAYUSCULAS = "ABCDEFGHIJKLMNÑOPQRSTCVWXYZ";
        private static final String NUMEROS = "0123456789";
        private static final String SIMBOLOS = "!|@#$%&/()=?¡¿*{}[]-_.,";

        private static final int FACIL = 1;
        private static final int MEDIO = 2;
        private static final int DIFICIL = 3;

        private static SecureRandom secureRandom = new SecureRandom();

        private static String generarContrasena(int longitud, int complejidad){
            StringBuilder pass = new StringBuilder();
            String caracteresPermitidos = "";

            switch (complejidad){
                case FACIL:
                    caracteresPermitidos = LETRAS_MINUSCULAS + LETRAS_MAYUSCULAS;
                    break;
                case MEDIO:
                    caracteresPermitidos = LETRAS_MINUSCULAS + LETRAS_MAYUSCULAS + NUMEROS;
                    break;
                case DIFICIL:
                    caracteresPermitidos = LETRAS_MINUSCULAS + LETRAS_MAYUSCULAS + NUMEROS + SIMBOLOS;
                    break;
                default:
                    throw  new IllegalArgumentException("Nivel de complejidad invalido.");
            }
            for (int i = 0; i < longitud; i++) {
                int indiceAleatorio = secureRandom.nextInt(caracteresPermitidos.length());
                char caracteresAleatorios = caracteresPermitidos.charAt(indiceAleatorio);
                pass.append(caracteresAleatorios);
            }
            return pass.toString();
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingresa la longitud de la contraseña que quieres generar: ");
            int longitud = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingresa un numero entero indicando la complejidad de la contraseña que quieres generar: \n" +
                    "FACIL = 1 \nMEDIO = 2 \nDIFICIL = 3");
            int complejidad = sc.nextInt();
            sc.nextLine();
            String password = generarContrasena(longitud, complejidad);
            System.out.println("password = " + password);
        }
    }
