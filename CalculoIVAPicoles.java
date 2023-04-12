import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class CalculoIVAPicoles {

    public static String convertParaNumeroDecimalBrasil(double valor) {
        String padrao = "###,###.##";
        DecimalFormat df = new DecimalFormat(padrao);
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("pt", "Brazil"));
        dfs.setDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        df = new DecimalFormat(padrao);

        return df.format(BigDecimal.valueOf(valor));
    }

    public static void calculoComIVA() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade do produto a ser calculado: ");
        double quantidadeProduto = scanner.nextDouble();

        System.out.print("Digite o valor unitário do produto a ser calculado: ");
        double valorUnitarioNota = scanner.nextDouble();
        System.out.println("---------------------------------------------------");

        /**
         * Indice de Valor Agregado IVA 70% => (Conversão para cálculo: 70 / 100 = 0.7 + 1)
         * Obs: Acrescenta 1 pois é um índice de agregação.
         */
        double indiceValorAgregadoConvertido = 1.7;
        double resultado = (quantidadeProduto * valorUnitarioNota * indiceValorAgregadoConvertido);
        System.out.println("");
        System.out.println("Base de cálculo ICMS S.T. é: " + convertParaNumeroDecimalBrasil(resultado));

        /**
         * Percentual ICMS S.T. => 7.55% (Conversão para cálculo: 7.55 / 100 = 0.0755)
         */
        double percentual_ICMS_ST_Convertido = 0.0755;

        double valorICMS_SUBST = (quantidadeProduto * valorUnitarioNota * indiceValorAgregadoConvertido
                * percentual_ICMS_ST_Convertido);

        //System.out.println("");
        System.out.println("Valor do ICMS SUBST. é: " + convertParaNumeroDecimalBrasil(valorICMS_SUBST));
        // System.out.println("Valor do ICMS SUBST. é: " +valorICMS_SUBST);

        scanner.close();
    }

    public static void calculoSemIVA() {

    }

    public static void main(String[] args) {

        calculoComIVA();

    }

}


