Narrative:	Upload de arquivo

Scenario:  Insercao de um arquivo XML com conexao ao banco de dados valida
Given Um arquivo
And Eh um arquivo XML
And A conexao com o banco eh valida	
When Clicar no botao Upload
Then O arquivo eh parseado
And O arquivo eh inserido no banco de dados
And Eh exibida uma mensagem ao usuario

Scenario:  Insercao de um arquivo XML sem conexao ao banco de dados
Given Um arquivo
And Eh um arquivo XML
And A conexao com o banco NAO eh valida	
When Clicar no botao Upload
Then O arquivo NAO eh parseado
And O arquivo NAO eh inserido no banco
And Eh exibida uma mensagem ao usuario

Scenario: Insercao de um arquivo XML_invalido  
Given Um arquivo
And Eh um arquivo XML invalido
When Clicar no botao Upload
Then O arquivo eh descartado
And Eh exibida uma mensagem ao usuario

Scenario: Insercao de um arquivo XML_Vazio 
Given Um arquivo
And Eh um arquivo XML vazio
When Clicar no botao Upload
Then O arquivo eh descartado
And Eh exibida uma mensagem ao usuario