package mc437.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import mc437.bean.Teste;
import mc437.bean.XMLFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TesteDAO {

	@Autowired
	DataSource datasource;

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
						xml.setId(rs.getInt("id"));
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
	
	
	
}
