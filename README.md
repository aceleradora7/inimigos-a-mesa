# Inimigos à Mesa

## Exectuando o projeto (ambientes *nix e Windows):

## Ambiente *nix:

Por questões de segurança em múltiplos ambientes, estamos usando variáveis de ambiente para credenciais do banco de dados:

`export IAM_DB_URL='jdbc:postgresql://<endereco_servidor_postgres>:5432/<banco_de_dados>'`

`export IAM_DB_USER='<meu_usuario>'`

`export IAM_DB_PASSWORD='<minha_senha>'`

Com as variáveis definidas, na raiz do projeto, execute a task de run do wrapper:

`./gradlew run`

## Ambiente Windows: 

Configurando variáveis de ambiente:

[Método Avançado](https://msdn.microsoft.com/pt-br/library/windows/desktop/ms682653%28v=vs.85%29.aspx)

[Método Simplificado](https://support.microsoft.com/pt-br/kb/310519/pt-br)

Com as variáveis definidas, na raiz do projeto, execute a task de run do wrapper:

`gradlew.bat run`


