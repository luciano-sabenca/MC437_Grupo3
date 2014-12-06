Narrative: 
	Quando o usuário selecionar um arquivo na lista de arquivos enviados o sistema deve exibir uma tela de resultados exibindo os resultados desse arquivo

Scenario:  Test Result eh valido
Given um testResult cadastrado valido <id>
When eu entro na pagina que exibe informacoes do testResult    
Then quero visualizar os dados acessados do result <id>
And quero visualizar o conjunto de testes <conjunto>
And quero visualizar o caso de testes <caso>
And quero visualizar o operador de mutação <operador>
And quero visualizar o mutante <mutante>
And quero visualizar Vivo? <vivo>

Examples:
|id|conjunto|caso|operador|mutante|vivo|
|1|D:/tmp/MGEO/TESTE_00/Teste/TS_01|D:/tmp/MGEO/TESTE_00/Teste/TS_01|TraArcDel|TraArcDel0.mmap|Sim|