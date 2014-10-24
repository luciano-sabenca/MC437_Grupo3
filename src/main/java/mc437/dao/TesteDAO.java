package mc437.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import mc437.bean.Teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import entities.XMLFile;

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
	
	public List<XMLFile> getFiles(){
		JdbcTemplate template = new JdbcTemplate(datasource);
		return template.query("SELECT * FROM I_Test_Result", new RowMapper<XMLFile>() {

			@Override
			public XMLFile mapRow(ResultSet rs, int rowNum) throws SQLException {
				XMLFile xml = new XMLFile(rs.getString("file_name"), rs.getInt("file_size"), rs.getDate("date"));
				return xml;
			}

		});
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
