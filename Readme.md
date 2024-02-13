# Project Nexus - Biblioteca de Utilidades

Esta é uma biblioteca de utilidades desenvolvida como parte do projeto Nexus. O objetivo principal desta biblioteca é fornecer funcionalidades úteis para os meus projetos.

## Como usar

Para usar esta biblioteca, você precisa adicionar as seguintes dependências e repositórios ao seu arquivo `pom.xml`:

### Dependências

Inclua a seguinte dependência dentro da tag `<dependencies>` do seu `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>com.nexus</groupId>
        <artifactId>utils</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
    <!-- outras dependências aqui -->
</dependencies>
```

Inclua a seguinte dependência dentro da tag `<repositories>` do seu `pom.xml`:

```xml
<repositories>
    <repository>
        <id>lib-utils</id>
        <url>https://raw.githubusercontent.com/igorcampos-dev/nexus.java.lib.utils/master/target/</url>
    </repository>
    <!-- outros repositórios aqui -->
</repositories>

```