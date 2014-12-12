package mc437.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import mc437.bean.Teste;
import mc437.bean.ITestResultBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class TesteDAO {

	@Autowired
	DataSource datasource;

	public List<ITestResultBean> getFiles() {
		JdbcTemplate template = new JdbcTemplate(datasource);
		return template.query("SELECT * FROM I_Test_Result",
				new RowMapper<ITestResultBean>() {

					@Override
					public ITestResultBean mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						ITestResultBean xml = new ITestResultBean(rs
								.getString("file_name"), rs
								.getLong("file_size"), new Date(rs
								.getTimestamp("date").getTime()));
						xml.setId(rs.getInt("id"));
						return xml;
					}

				});
	}

	public int saveFile(final ITestResultBean file) {
		KeyHolder holder = new GeneratedKeyHolder();
		JdbcTemplate template = new JdbcTemplate(datasource);
		template.update(
				new PreparedStatementCreator() {

					@Override
					public PreparedStatement createPreparedStatement(
							Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(
								"INSERT INTO I_Test_Result(date,file_size,file_name) VALUES (?, ?, ?)",
								Statement.RETURN_GENERATED_KEYS);

						ps.setTimestamp(1, new Timestamp(file.getDataEnvio().getTime()));
						ps.setLong(2, file.getTamanho());
						ps.setString(3, file.getNome());

						return ps;
					}
				}, holder);

				return holder.getKey().intValue();
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
