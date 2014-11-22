Narrative:
In order to ver a quantidade de mortos e vivos em um grafico de pizza
As a um analista de testes
I want to ver o grafico de pizza
					 
Scenario:  Test Result eh valido
Given um test result valido 1
When eu acesso a pagina que exibe informacoes do test result
Then desejo obter os dados do result 1
And desejo carregar um grafico

Scenario:  Test Result eh invalido
Given um test result nao existente
When desejo obter informacoes sobre esse test result
Then uma pagina de erro eh renderizada