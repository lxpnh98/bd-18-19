//POPULACAO DE BD

//TABELAS NAO RELACIONAIS
LOAD CSV WITH HEADERS FROM "file:///utilizador.csv" AS utilizadores
CREATE (u:Utilizador)
SET u = utilizadores,
	u.Id = toInteger(utilizadores.Id);

LOAD CSV WITH HEADERS FROM "file:///requisicaodelivro.csv" as reqLivro
CREATE (rl:RequisicaoDeLivro)
SET rl = reqLivro,
	rl.Id = toInteger(reqLivro.Id),
    rl.DataRequisicao = date(reqLivro.DataRequisicao),
    rl.DataEntrega = date(reqLivro.DataEntrega),
    rl.Prazo = toInteger(reqLivro.Prazo),
    rl.Taxa = toFloat(reqLivro.Taxa),
    rl.IdFuncionario = toInteger(reqLivro.IdFuncionario),
    rl.IdUtilizador = toInteger(reqLivro.IdUtilizador);

LOAD CSV WITH HEADERS FROM "file:///funcionario.csv" as funcionarios
CREATE (f:Funcionario)
set f = funcionarios,
	f.Id = toInteger(funcionarios.Id);

LOAD CSV WITH HEADERS FROM "file:///livro.csv" AS livros

CREATE (c:Copia)
SET c.Id = toInteger(livros.Id),
	c.Edicao = toInteger(livros.Edicao),
    c.Estado = toInteger(livros.Estado),
    c.Requisitado = case livros.Requisitado when "1" then true else false end,
    c.Titulo = livros.Titulo,
    c.Resumo = livros.Resumo


WITH COLLECT(livros)[0] AS hardLivro, livros.Titulo AS lTitulo, livros.Resumo AS lResumo
CREATE (l:Livro)
SET l.Id = toInteger(hardLivro.Id),
	l.Titulo = hardLivro.Titulo,
    l.Resumo = hardLivro.Resumo,
    l.DataPublicacao = date(hardLivro.DataPublicacao),
	l.IdGenero = toInteger(hardLivro.IdGenero);

LOAD CSV WITH HEADERS FROM "file:///autor.csv" AS autores
CREATE (a:Autor)
SET a = autores,
	a.Id = toInteger(autores.Id),
	a.DataNascimento = date(autores.DataNascimento);

LOAD CSV WITH HEADERS FROM "file:///genero.csv" AS generos
CREATE (g:Genero)
SET g = generos,
	g.Id = toInteger(generos.Id);

LOAD CSV WITH HEADERS FROM "file:///sala.csv" AS salas
CREATE (s:Sala)
SET s.Numero = toInteger(salas.Numero),
	s.Capacidade = toInteger(salas.Capacidade);

LOAD CSV WITH HEADERS FROM "file:///requisicaodesala.csv" AS reqsSala
CREATE (rs:RequisicaoDeSala)
SET rs.Id = toInteger(reqsSala.Id),
	rs.DataRequisicao = datetime(replace(reqsSala.DataRequisicao," ", "T")),
    rs.DataLimite = datetime(replace(reqsSala.DataLimite," ", "T")),
    rs.NumeroSala = toInteger(reqsSala.NumeroSala),
    rs.IdUtilizador = toInteger(reqsSala.IdUtilizador);

//INDEXAR PARA MELHOR PERFORMANCA
CREATE INDEX ON : Utilizador(Id);
CREATE INDEX ON : RequisicaoDeLivro(Id);
CREATE INDEX ON : Funcionario(Id);
CREATE INDEX ON : Livro(Id);
CREATE INDEX ON : Copia(Id);
CREATE INDEX ON : Autor(Id);
CREATE INDEX ON : Genero(Id);
CREATE INDEX ON : Sala(Id);
CREATE INDEX ON : RequisicaoDeSala(Id);

//TABELAS RELACIONAIS, CRIAR RELACAOES
LOAD CSV WITH HEADERS FROM "file:///autorlivro.csv" AS autorLivros
MATCH (a:Autor), (l:Livro)
WHERE a.Id = toInteger(autorLivros.IdAutor) AND l.Id = toInteger(autorLivros.IdLivro)
CREATE (a)-[:ESCREVEU]->(l);

LOAD CSV WITH HEADERS FROM "file:///generolivro.csv" AS generolivros
MATCH (g:Genero), (l:Livro)
WHERE g.Id = toInteger(generolivros.IdGenero) AND l.Id = toInteger(generolivros.IdLivro)
CREATE (l)-[:TEM_GENERO_SECUNDARIO]->(g);

LOAD CSV WITH HEADERS FROM "file:///requisicaodelivrolivro.csv" AS reqDeLivroLivros
MATCH (rl:RequisicaoDeLivro), (c:Copia)
WHERE rl.Id = toInteger(reqDeLivroLivros.IdRequisicaoDeLivro) AND c.Id = toInteger(reqDeLivroLivros.IdLivro)
CREATE (rl)-[:INCLUI]->(c);

//LIGAR CHAVES ESTRANGEIRAS E APAGA-LAS, POIS AGORA TEMOS A RELACAO
MATCH (rl:RequisicaoDeLivro),(f:Funcionario) WHERE rl.IdFuncionario = f.Id CREATE (f)-[:RESPONSAVEL_POR]->(rl) REMOVE rl.IdFuncionario;

MATCH (rl:RequisicaoDeLivro),(u:Utilizador) WHERE rl.IdUtilizador = u.Id CREATE (u)-[:REQUISITOU]->(rl) REMOVE rl.IdUtilizador;

MATCH (l:Livro),(g:Genero) WHERE l.IdGenero = g.Id CREATE (l)-[:GENERO_PRIMARIO]->(g) REMOVE l.IdGenero;

Match (c:Copia),(l:Livro) where c.Resumo = l.Resumo and c.Titulo = l.Resumo create (c)-[:COPIA]->(l) remove c.Titulo, c.Resumo;

//LIGAR UTILIZADOR E SALA REQUISITADA DIRETAMENTE ATRAVES DE UMA RELACAO COM AS PROPRIADADES DA, AGORA APAGADA, TABALE RequisicaoDeSala
MATCH (u:Utilizador),(rs:RequisicaoDeSala),(s:Sala)
WHERE u.Id = rs.IdUtilizador AND rs.NumeroSala = s.Numero
CREATE (u)-[r:REQUISITOU]->(s)
SET r.Id = rs.Id,
	r.DataRequisicao = rs.DataRequisicao,
    r.DataLimite = rs.DataLimite
DETACH DELETE rs;
