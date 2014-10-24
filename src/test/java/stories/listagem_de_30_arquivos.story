Narrative: 
	Quando o banco de dados está vazio, e fazemos o upload de 30 arquivos repetidos,
	teremos a listagem desses arquivos.

Given o caminho de um arquivo xml <caminho_xml>, de <tamnho_xml> enviado em <data_xml>, enviado 30 vezes.
When os uploads sao finalizados.
Then o arquivo de nome <caminho_xml>, tamanho <tamanho_xml>, e data <data_xml> e exibido 30 vezes na listagem de arquivos.

Examples:
|caminho_xml|tamanho_xml|data_xml|
|exmp_xml_valido.xml|120kb|24/10/2014|