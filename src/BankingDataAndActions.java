import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class BankingDataAndActions {
    public static void main(String[] args) {
        /* IMPLEMENTAÇÃO DOS DADOS INICIAIS DO CLIENTE */
        String clientName = "WELLINGTON BONJARDIM";
        String accountType = "CORRENTE";
        double initialBalance = 10000;
        NumberFormat currencyMoney = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String formattedInitialBalance = currencyMoney.format(initialBalance);

        System.out.println("\n");
        System.out.println("****************************************");
        System.out.println("Dados iniciais do cliente:\n");
        System.out.printf("Nome:          %s\n", clientName);
        System.out.printf("Tipo conta:    %s\n", accountType);
        System.out.printf("Saldo inicial: %s\n", formattedInitialBalance);
        System.out.println("****************************************");
        System.out.println("\n");

        /* IMPLEMENTAÇÃO DO MENU DE OPERAÇÕES */
        String menu = """
                OPERAÇÕES:\n
                1- Consultar saldo
                2- Receber valor
                3- Transferir valor
                4- Sair
                \nDigite a opção desejada:
                """;
        System.out.println(menu);

        /* IMPLEMENTAÇÃO DAS REGRAS DE NEGÓCIO */
        Scanner scanner = new Scanner(System.in);
        int selectedOption = 0;
        double setAmount = 0;
        String message = """
                        \nDeseja realizar mais alguma operação?
                        Se sim, indique o número da operação de acordo com o menu exibido acima.
                        Se não, tecle 4 para finalizar.
                        """;

        while(selectedOption != 4) {
            selectedOption = scanner.nextInt();

            if(selectedOption < 1 || selectedOption > 4) {
                System.out.println("\nOPERAÇÃO INVÁLIDA!\n");
                System.out.println(menu);
                continue;
            }

            switch(selectedOption) {
                case 1:
                    System.out.printf("\n-> Saldo inicial: %s\n", formattedInitialBalance);
                    break;
                case 2:
                    System.out.println("\nInforme o valor a ser recebido:");
                    setAmount = scanner.nextDouble();
                    initialBalance += setAmount;
                    break;
                case 3:
                    System.out.println("\nInforme o valor que deseja transferir:");
                    setAmount = scanner.nextDouble();
                    if(setAmount >= 0 && setAmount <= initialBalance) {
                        initialBalance -= setAmount;
                    } else {
                        if(setAmount > initialBalance) {
                            System.out.println("\nSaldo insuficiente para realizar a transferência.");
                        }

                        if(setAmount < 0) {
                            System.out.println("\nValor inválido. Por favor, informe um valor válido.\n");
                        }
                    }
                    break;
                case 4:
                    System.out.println("\nOperação finalizada.\nVolte sempre!");
                    break;
            }

            if(selectedOption != 4) {
                if(setAmount > 0) {
                    System.out.printf("\n-> Saldo final atualizado para %s\n", currencyMoney.format(initialBalance));
                }
                System.out.println(message);
            }
        }

    }
}