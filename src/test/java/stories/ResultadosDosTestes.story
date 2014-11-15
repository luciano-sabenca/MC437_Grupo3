Narrative:
In order to ver os dados de um conjunto de casos de teste
As a um analista de testes
I want to obter os dados
					 
Scenario:  Test Result eh valido
Given um test result valido
When eu acesso a pagina que exibe informacoes do test result
Then desejo obter os dados do result
And obter o score
And obter a quantidade de mutantes mortos
					 
Scenario:  Test Result eh invalido
Given um test result nao existente
When desejo obter informacoes sobre esse test result
Then uma pagina de erro eh renderizada
