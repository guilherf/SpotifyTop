# Spotify Top: suas faixas mais ouvidas

Programa de console em **Java** que consulta a **API Web do Spotify** e lista as **faixas que você mais escuta**.

## Para que serve

É um estudo de integração com a API do Spotify. O objetivo prático é ver, direto no terminal, quais são as suas músicas mais tocadas, com o nome da faixa e do artista.

## Como funciona

1. O programa pede o **token de acesso** (OAuth) do Spotify.
2. Chama o recurso "top tracks" do usuário.
3. Imprime a lista no formato `Nome da música - Artista`.
4. Mostra também o **total** de itens retornado pela API.

Exemplo de saída:

```
=======================TOP MUSICAS OUVIDAS====================
Nome da música - Artista
...
========================================
Total:<quantidade informada pela API>
```

### O que você precisa ter

- Um **access token** válido, gerado com a permissão (*scope*) `user-top-read`. Veja [como obter](https://developer.spotify.com/documentation/web-api/concepts/access-token).

> O token expira depois de cerca de uma hora. Nunca coloque seu token no código nem o publique no GitHub: o programa o recebe pelo teclado justamente por isso.

## Tecnologias

- Java 21 e Maven
- [spotify-web-api-java](https://github.com/spotify-web-api-java/spotify-web-api-java) 9.4.0
- slf4j-simple (logs)

## Estrutura

```
src/main/java/net/bifewagyu/
├── Main.java                  # ponto de entrada
└── tops/GetTopTracks.java     # recebe o token, chama a API e imprime o ranking
```

## Como executar

Pré-requisitos: **JDK 21** e **Maven**.

```bash
git clone https://github.com/guilherf/SpotifyTop.git
cd SpotifyTop
mvn compile exec:java -Dexec.mainClass=net.bifewagyu.Main
```

## Autor

Guilherme Ferreira — [@guilherf](https://github.com/guilherf)
