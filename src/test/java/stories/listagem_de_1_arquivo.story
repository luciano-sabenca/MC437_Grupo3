Narrative: 
	Quando o banco de dados está vazio, e fazemos o upload de 1 arquivo,
	teremos a listagem desse um arquivo.

Given o caminho de um arquivo xml <caminho_xml>, de <tamnho_xml> enviado em <data_xml>.
When o upload e finalizado.
Then o arquivo de nome <caminho_xml>, tamanho <tamanho_xml>, e data <data_xml> e exibido na listagem de arquivos.

Examples:
|caminho_xml|tamanho_xml|data_xml|
|exmp_xml_valido.xml|120kb|24/10/2014|