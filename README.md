# Instrução de instalação do sistema BRKSISTEMAS

## Integrantes: <br/>
>Brenicio Guilherme <br/>
>Hiago Koziel Rahmig <br/>

1) O projeto está versionado em um repositório do GitHub, no seguinte link:  [ [Link Github Hiago](https://github.com/koziel101/TrabalhoFinalPoo) ] ou [[Link Github Brenicio](https://github.com/brenicio/TrabalhoFinalPoo.git)]. É possivel obter uma cópia do sistema baixando um arquivo .zip ou clonando-o.

![](https://github.com/brenicio/TrabalhoFinalPoo/blob/master/Images/brkimage1.jpg)

2) O Sistema utiiza a IDE NetBeans. Abra o projeto pelo Netbeans.

3) Baixe o BD Postgre 10 pelo link: [[Clique aqui para baixar](https://www.postgresql.org/download/)]

4) Após a instalação, armazena a senha definida para o banco de dados na instalação do mesmo.

5) Altere o arquivo [[conexao.java](/BD_Backup/conexao.java)] para inserir a senha do postgre na variavel password.

![](/images/brkimage2.jpg)

6)Abra o banco de dados (Caminho: C:\Program Files\PostgreSQL\10\pgAdmin4\bin\pgAdmin4.exe).

![](/images/brkimage3.jpg)

7) Crie um novo DataBase com nome de db_paulo e restaure o Banco de dados [[db_paulo.backup](/Bd_Backup/db_paulo.backup)] localizado em (Bd_Backup/db_paulo.backup) no repositorio.

![](/images/brkimage4.jpg)

8) Em seguida, execute o projeto pelo netbeans. <br/>
Use os seguintes dados para acessar:

>Login: admin <br/>
>Senha: root
