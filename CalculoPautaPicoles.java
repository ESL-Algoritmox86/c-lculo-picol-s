import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class CalculoPautaPicoles {

    public static String convertParaNumeroDecimalBrasil(double valor) {
        String padrao = "###,###.##";
        DecimalFormat df = new DecimalFormat(padrao);
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("pt", "Brazil"));
        dfs.setDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        df = new DecimalFormat(padrao);

        return df.format(BigDecimal.valueOf(valor));
    }

    public static void calculoPautaPicoles() {
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

        //double indiceValorAgregadoConvertido = 1.7;
        //double resultado = (quantidadeProduto * valorUnitarioNota * indiceValorAgregadoConvertido);
        //System.out.println("");
        //System.out.println("Base de cálculo ICMS S.T. é: " + convertParaNumeroDecimalBrasil(resultado));

        /**
         * Percentual ICMS S.T. => 7.55% (Conversão para cálculo: 7.55 / 100 = 0.0755)
         */
        double percentual_ICMS_ST_Convertido = 0.0755;

        //double imposto = indiceValorAgregadoConvertido * percentual_ICMS_ST_Convertido;

        double valorICMS_SUBST = (quantidadeProduto * valorUnitarioNota * percentual_ICMS_ST_Convertido); //* indiceValorAgregadoConvertido
        //* percentual_ICMS_ST_Convertido);

        double baseCalculo = quantidadeProduto * valorUnitarioNota;

        System.out.println("");
        System.out.println("Base de cálculo ICMS S.T. é: " + baseCalculo );
        System.out.println("Valor do ICMS SUBST. é: " + convertParaNumeroDecimalBrasil(valorICMS_SUBST));
        //System.out.println("Valor do ICMS SUBST. é: " + valorICMS_SUBST);
        //System.out.println("Imposto: " + convertParaNumeroDecimalBrasil(valorICMS_SUBST));

        scanner.close();
    }

    public static void calculoSemIVA() {

    }

    public static void main(String[] args) {

        calculoPautaPicoles();

    }

}


