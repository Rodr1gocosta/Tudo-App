# Tudo-App
Sistema backend feito com java e conexão com banco mysql sem frameworks.

1. Iniciando um projeto

1.1 Definição de um projeto
	- Todo App	
	- Gerenciamento de tarefas
	- Resolver organização

1.2 Requisitos do projeto
	ENTIDADES:
		*Projetos;
			-nome;
			-descrição
			-Data de Criação;
			-Data de Atualização;
		*tarefa;
			-nome;
			-descrição;
			-status
			-observação;
			-prazo;
			-data de criação;
			-data de atualização;
	
	REQUISITOS:
		*Permitir o cadastro de projetos;
		*Permitir o cadostro de tarefas;
		*crud;

1.3 Regras de negócio
	- Não contém login;
	- Toda tarefas deve pertencer a uma projeto;
	- Não podem haver tags repetidas numa mesma tarefa;
	- Deve ser possivel filtrar as tarefas por tag;

1.4 Tecnologias
	-Java 
	-Mysql
