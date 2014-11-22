package mc437.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import mc437.bean.Teste;
import mc437.bean.XMLFile;
import mc437.bean.Results;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TesteDAO {

	@Autowired
	DataSource datasource;

	public void bla() {
		if (datasource != null) {
			System.out.println("Blablalba");
			JdbcTemplate template = new JdbcTemplate(datasource);
			System.out
					.println(template
							.queryForInt("SELECT id FROM Teste WHERE texto = 'banana'"));

		}
	}

	public List<XMLFile> getFiles() {
		JdbcTemplate template = new JdbcTemplate(datasource);
		return template.query("SELECT * FROM I_Test_Result",
				new RowMapper<XMLFile>() {

					@Override
					public XMLFile mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						XMLFile xml = new XMLFile(rs.getString("file_name"), rs
								.getLong("file_size"), new Date(rs
								.getTimestamp("date").getTime()));
						return xml;
					}

				});
	}

	public void saveFile(XMLFile file) {
		JdbcTemplate template = new JdbcTemplate(datasource);
		template.update(
				"INSERT INTO I_Test_Result(date,file_size,file_name) VALUES (?, ?, ?)",
				new Object[] { file.getDataEnvio(), file.getTamanho(),
						file.getNome() }, new int[] { Types.DATE,
						Types.INTEGER, Types.VARCHAR });
	}

	public List<Teste> getAllTests() {
		JdbcTemplate template = new JdbcTemplate(datasource);
		return template.query("SELECT * FROM Teste", new RowMapper<Teste>() {

			@Override
			public Teste mapRow(ResultSet rs, int rowNum) throws SQLException {
				Teste teste = new Teste();
				teste.setId(rs.getInt("id"));
				teste.setTexto(rs.getString("texto"));

				return teste;
			}

		});
	}
	
	public List<Results> getResults() {
		JdbcTemplate template = new JdbcTemplate(datasource);
		return template.query("SELECT mutant_key, dead FROM test_case_executing_output_mutantlist ml, "
				+ "I_Test_Result i WHERE ml.id_i_test_results = i.id "
				+ "AND i.file_name = 'funfa.xml'", 
				new RowMapper<Results>() {

					@Override
					public Results mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Results result = new Results(rs.getString("mutant_key"), rs.getString("mutant_key"), rs
								.getInt("dead"));
						return result;
				}
		});
	}
	
}
