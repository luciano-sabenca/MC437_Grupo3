Narrative: 
	Dado que eu tenho um arquivo 
	Quando eu tento carrega-lo 
	Então quero que o sistema me avise que recebeu o arquivo, coloque o arquivo na lista.

Given o caminho de um arquivo xml <caminho_xml>
When o xml e valido
And o usuario clica no botao de upload
And ha memoria disponivel no banco de dados
Then o arquivo e processado e armazenado no banco de dados
Then aparece a mensagem Upload realizado com sucesso
Then o arquivo passa a ser listado na lista de arquivos

Examples:
|caminho_xml|
|exmp_xml_valido.xml|