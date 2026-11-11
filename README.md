# SOLID

Atividade de SOLID em Java: sistema de delivery aplicando os cinco princípios.

## Como executar

```bash
mkdir out
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out Main
```

Ou abra a pasta no IntelliJ e rode a classe `Main`.

## Estrutura

| Pacote | Princípio | O que mostra |
|--------|-----------|--------------|
| `srp` | Single Responsibility | `PedidoService` cria, `PedidoRepository` salva, `PedidoView` exibe, `Pedido` só guarda os dados |
| `ocp` | Open/Closed | `FormaPagamento` com Cartão, PIX e Dinheiro. Novas formas entram sem alterar `ProcessadorPagamento` |
| `lsp` | Liskov Substitution | `Pizza`, `Hamburguer` e `Bebida` substituem `Produto` respeitando o contrato de `calcularPreco()` (nunca negativo, nunca lança exceção) |
| `isp` | Interface Segregation | `GerenciadorPedidos`, `GerenciadorEntregas` e `GeradorRelatorio`: interfaces pequenas, cada classe implementa só o que usa |
| `dip` | Dependency Inversion | `NotificacaoService` depende da interface `Notificador`, e não de `Email`, `Sms` ou `Whats` |

## Como cada princípio é respeitado

- **SRP:** nenhuma classe mistura criar, salvar e exibir pedido.
- **OCP:** para adicionar, por exemplo, boleto, basta criar uma nova implementação de `FormaPagamento` (o `Main` mostra isso com uma lambda). Nenhuma classe existente muda.
- **LSP:** o `Main` percorre uma `List<Produto>` com os três tipos e trata todos igual.
- **ISP:** relatório, entrega e gestão de pedidos são interfaces separadas, sem métodos vazios ou `UnsupportedOperationException`.
- **DIP:** o meio de notificação é injetado pelo construtor; trocar Email por SMS ou WhatsApp não exige mexer no serviço.
