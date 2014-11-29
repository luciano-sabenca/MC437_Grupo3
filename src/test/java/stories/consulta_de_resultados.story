Narrative: 
	Quando o usuário selecionar um arquivo na lista de arquivos enviados o sistema deve exibir uma tela de resultados exibindo os resultados desse arquivo

Given um testresult valido 1
When eu acesso a pagina que exibe informacoes do testresult
Then desejo visualizar os dados acessados do result 1
And desejo visualizar o conjunto de testes D:/tmp/MGEO/TESTE_00/Teste/TS_01
And desejo visualizar o caso de testes D:/tmp/MGEO/TESTE_00/Teste/TS_01
And desejo visualizar o operador de mutação TraArcDel
And desejo visualizar o mutante TraArcDel0.mmap
And desejo visualizar Vivo? Sim

Examples:
|id|conjunto|caso|operador|mutante|vivo|
|1|D:/tmp/MGEO/TESTE_00/Teste/TS_01|D:/tmp/MGEO/TESTE_00/Teste/TS_01|TraArcDel|TraArcDel0.mmap|Sim|