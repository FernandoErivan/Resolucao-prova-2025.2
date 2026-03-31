import java.util.Random;

public class prova {
    public static final int Tam = 10;
    public static final int Min = 1;
    public static final int Max = 10;
    public static Random random = new Random();

    public static void main(String[] args) {
        int[] numeros = new int[Tam];
        preencheraleatorio(numeros);
        System.out.print("Vetor: ");
        imprimir(numeros);
        ordenar(numeros, numeros.length);
        System.out.print("\n\nVetor insertion sort: ");
        imprimir(numeros);
    }

    public static void preencheraleatorio(int[] v) {
        for (int i = 0; i < v.length; i++) {
            v[i] = random.nextInt(Max - Min + 1) + Min;
        }
    }

    public static void imprimir(int[] v) {
        System.out.print("{");
        if (v.length >= 1) {
            System.out.print(" " + v[0]);
            for (int i = 0; i < v.length; i++) {
                System.out.print(", " + v[i]);
            }
        }
        System.out.print(" }");
    }

    public static int uniao(int[] a, int tamA, int[] b, int tamB, int[] u) {
        int tamU = 0;

        for (int i = 0; i < tamA; i++) {
            u[tamU] = a[i];
            tamU++;
        }

        for (int i = 0; i < tamB; i++) {
            boolean existe = false;

            for (int j = 0; j < tamU; j++) {
                if (b[i] == u[j]) {
                    existe = true;
                    break;
                }
            }

            if (existe == false) {
                u[tamU] = b[i];
                tamU++;
            }
        }

        return tamU;
    }

    public static void ordenar(int[] v, int n) {
        for (int i = 1; i <= n - 1; i++) {
            int chave = v[i];
            int j = i - 1;

            while (j >= 0 && v[j] > chave) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = chave;
        }
    }

    public static int gerarVetorSemRepeticao(int[] v, int tamV, int[] vsr) {
        int tamVSR = 0;

        for (int i = 0; i < tamV; i++) {
            int elemento = v[i];
            boolean repetido = false;

            // Verifica se o elemento já existe em vsr
            for (int j = 0; j < tamVSR; j++) {
                if (vsr[j] == elemento) {
                    repetido = true;
                    break;
                }
            }

            // Se não for repetido, adiciona ao vetor vsr
            if (!repetido) {
                vsr[tamVSR] = elemento;
                tamVSR++;
            }
        }
        return tamVSR;
    }

    public static void rotacionar(int[] v, int tam, int k) {
        if (tam == 0) return;
        
        k = k % tam;
        if (k < 0) k += tam; 
        
        inverter(v, 0, k - 1);     
        inverter(v, k, tam - 1);    
        inverter(v, 0, tam - 1);     
    }

    private static void inverter(int[] v, int inicio, int fim) {
        while (inicio < fim) {
            int temp = v[inicio];
            v[inicio] = v[fim];
            v[fim] = temp;
            inicio++;
            fim--;
        }
    }
}