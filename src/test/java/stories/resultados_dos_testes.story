Narrative:
In order to ver os dados de um conjunto de casos de teste
As a um analista de testes
I want to obter os dados
					 
Scenario:  Test Result eh valido
Given um test result valido 1
When eu acesso a pagina que exibe informacoes do test result
Then desejo obter os dados do result 1
And desejo obter o score 0.75
And desejo obter a quantidade de mutantes mortos 6
					 

Scenario:  Test Result eh invalido
Given um test result nao existente
When desejo obter informacoes sobre esse test result
Then uma pagina de erro eh renderizada

Examples:
|id|score|mutantesMortos|
|1|0.75|6|