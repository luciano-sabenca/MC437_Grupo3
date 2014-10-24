Narrative: 
	Quando no banco de dados ha um arquivo com nome muito grande,
	e esse arquivo e exibido na lista de arquivos, entao o sistema exibe seu
	nome truncado para nao comprometer a exibicao dos dados da proxima coluna.

Given um arquivo no banco de nome <nome_xml>.
When a pagina e carregada.
Then a tabela de listagem de arquivo exibe o nome <nome_xml> truncado para o tamanho maximo da coluna.

Examples:
|nome_xml|
|cara_esse_nome_e_bem_grande_mesmo_viu_nem_cabe_na_tabela_meu_deus_paralelepipedo.xml|