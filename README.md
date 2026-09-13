# TDE1 - Estrutura de Dados: Flood Fill

## 📋 Sobre o projeto

A proposta desta atividade é a implementação do algoritmo **Flood Fill** de forma simplificada, utilizando **Pilha** e **Fila** para armazenamento dos pixels.

---

## 🔄 Fluxo de trabalho

### Etapa 1 — Base compartilhada
A Isabelle cria a classe `Pixel` (atributos `linha` e `coluna`, construtor e getters) direto na `master` e envia (push) assim que terminar. É uma classe pequena e todas as outras partes dependem dela, por isso não passa por branch separada.

### Etapa 2 — Atualização geral
Antes de começar suas partes, todos os integrantes puxam (`pull`) a `master` atualizada, para já ter a classe `Pixel` disponível localmente.

### Etapa 3 — Desenvolvimento em paralelo
Cada integrante cria sua própria branch a partir da `master` e desenvolve sua parte de forma independente:

| Branch | Responsável | Conteúdo |
|---|---|---|
| `feature/pixel-e-pilha` | Isabelle | Classe `PilhaPropria` (empilhar/desempilhar) |
| `feature/fila` | Pessoa 2 | Classe `FilaPropria` (enfileirar/desenfileirar) |
| `feature/leitura-imagem` | Pessoa 3 | Leitura/escrita de imagem com `File` e `BufferedImage`, incluindo salvamento das imagens intermediárias para a animação |
| `feature/algoritmo-floodfill` | Pessoa 4 | Núcleo do algoritmo Flood Fill (verificação de limites, cor de fundo, pintura e empilhamento/enfileiramento dos vizinhos) |

### Etapa 4 — Revisão e integração
Conforme cada parte fica pronta e testada, o responsável abre um **Pull Request** da sua branch para a `master`. Os demais revisam antes do merge, para pegar erros e garantir que todo mundo entenda o que foi feito (importante para a arguição).

### Etapa 5 — Integração final
Depois que todas as branches estiverem na `master`, a classe `Main` é criada em conjunto (ou pela última pessoa a terminar), juntando tudo: leitura da imagem, execução do Flood Fill com Pilha e com Fila, e geração dos resultados/animação.

> ⚠️ **Regra geral:** sempre dar `pull` na `master` antes de começar a trabalhar em qualquer branch, para evitar conflitos.

---

## ✅ Status atual

Todas as partes do projeto já foram implementadas e mescladas na `master`:

- [x] Classe `Pixel`
- [x] `PilhaPropria` (LIFO)
- [x] `FilaPropria` (FIFO)
- [x] Interface `EstruturaDeDados` (implementada por `PilhaPropria` e `FilaPropria`)
- [x] `GerenciadorImagem` (leitura, escrita e manipulação de pixels)
- [x] `FloodFill` (núcleo do algoritmo, com versão simples e com animação)
- [x] `Main` (integração final: executa o Flood Fill com Pilha e com Fila)

**Próximos passos:** revisão geral do código e preparação individual para a arguição.

---

## 🗂️ Estrutura das classes

| Classe | Responsabilidade |
|---|---|
| `Pixel` | Representa uma posição (linha, coluna) na imagem |
| `PilhaPropria` | Estrutura própria em array, comportamento LIFO |
| `FilaPropria` | Estrutura própria em array, comportamento FIFO |
| `EstruturaDeDados` | Interface comum entre Pilha e Fila (`inserir`, `remover`, `estaVazia`) |
| `GerenciadorImagem` | Abre, lê, pinta e salva imagens PNG (`File`/`BufferedImage`) |
| `FloodFill` | Executa o algoritmo, usando qualquer `EstruturaDeDados` (Pilha ou Fila) |
| `Main` | Integra tudo: roda o Flood Fill com Pilha e com Fila, salva resultados e animação |
