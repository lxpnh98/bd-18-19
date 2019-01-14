USE Biblioteca;

SHOW VARIABLES LIKE 'secure_file_priv';

SELECT 'Id', 'Nome', 'Naturalidade', 'DataNascimento', 'Sexo'
UNION ALL
SELECT Id, Nome, Naturalidade, DataNascimento, Sexo
    FROM Autor
    INTO OUTFILE '/var/lib/mysql-files/autor.csv'
    FIELDS TERMINATED BY ',' 
    OPTIONALLY ENCLOSED BY '"'
	LINES TERMINATED BY '\r\n';

SELECT 'IdAutor', 'IdLivro'
UNION ALL
SELECT IdAutor, IdLivro
	FROM AutorLivro
	INTO OUTFILE '/var/lib/mysql-files/autorlivro.csv'
	FIELDS TERMINATED BY ',' 
	OPTIONALLY ENCLOSED BY '"'
	LINES TERMINATED BY '\r\n';

SELECT 'Id', 'Nome'
UNION ALL
SELECT Id, Nome
	FROM  Funcionario
	INTO OUTFILE '/var/lib/mysql-files/funcionario.csv'
	FIELDS TERMINATED BY ',' 
	OPTIONALLY ENCLOSED BY '"'
	LINES TERMINATED BY '\r\n';

SELECT 'Id', 'Designacao', 'Descricao'
UNION ALL
SELECT Id, Designacao, Descricao
	FROM Genero
	INTO OUTFILE '/var/lib/mysql-files/genero.csv'
	FIELDS TERMINATED BY ',' 
	OPTIONALLY ENCLOSED BY '"'
	LINES TERMINATED BY '\r\n';

SELECT 'IdGenero', 'IdLivro'
UNION ALL
SELECT IdGenero, IdLivro
	FROM GeneroLivro
	INTO OUTFILE '/var/lib/mysql-files/generolivro.csv'
	FIELDS TERMINATED BY ',' 
	OPTIONALLY ENCLOSED BY '"'
	LINES TERMINATED BY '\r\n';

SELECT 'Id', 'Titulo', 'Resumo', 'DataPublicacao', 'Edicao', 'Estado', 'Requisitado', 'IdGenero'
UNION ALL
SELECT Id, Titulo, Resumo, DataPublicacao, Edicao, Estado, Requisitado, IdGenero
	FROM Livro
	INTO OUTFILE '/var/lib/mysql-files/livro.csv'
	FIELDS TERMINATED BY ',' 
	OPTIONALLY ENCLOSED BY '"'
	LINES TERMINATED BY '\r\n';

SELECT 'Id', 'DataRequisicao', 'DataEntrega', 'Prazo', 'Taxa', 'IdFuncionario', 'IdUtilizador'
UNION ALL
SELECT Id, DataRequisicao, DataEntrega, Prazo, Taxa, IdFuncionario, IdUtilizador
	FROM RequisicaoDeLivro
	INTO OUTFILE '/var/lib/mysql-files/requisicaodelivro.csv'
	FIELDS TERMINATED BY ',' 
	OPTIONALLY ENCLOSED BY '"'
	LINES TERMINATED BY '\r\n';

SELECT 'IdRequisicaoDeLivro', 'IdLivro'
UNION ALL
SELECT IdRequisicaoDeLivro, IdLivro
	FROM RequisicaoDeLivroLivro
	INTO OUTFILE '/var/lib/mysql-files/requisicaodelivrolivro.csv'
	FIELDS TERMINATED BY ',' 
	OPTIONALLY ENCLOSED BY '"'
	LINES TERMINATED BY '\r\n';

SELECT 'Id', 'DataRequisicao', 'DataLimite', 'NumeroSala', 'IdUtilizador'
UNION ALL
SELECT Id, DataRequisicao, DataLimite, NumeroSala, IdUtilizador
	FROM RequisicaoDeSala
	INTO OUTFILE '/var/lib/mysql-files/requisicaodesala.csv'
	FIELDS TERMINATED BY ',' 
	OPTIONALLY ENCLOSED BY '"'
	LINES TERMINATED BY '\r\n';

SELECT 'Numero', 'Capacidade'
UNION ALL
SELECT Numero, Capacidade
	FROM Sala
	INTO OUTFILE '/var/lib/mysql-files/sala.csv'
	FIELDS TERMINATED BY ',' 
	OPTIONALLY ENCLOSED BY '"'
	LINES TERMINATED BY '\r\n';

SELECT 'Id', 'Nome', 'Email', 'Contacto'
UNION ALL
SELECT Id, Nome, Email, Contacto
	FROM  Utilizador
	INTO OUTFILE '/var/lib/mysql-files/utilizador.csv'
	FIELDS TERMINATED BY ',' 
	OPTIONALLY ENCLOSED BY '"'
	LINES TERMINATED BY '\n';