package mc437.dao;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
public class DBConnection {
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"Spring-Module.xml");

	@Bean
	public DataSource getDatasource() {
		// DriverManagerDataSource dataSource = new DriverManagerDataSource(
		// "jdbc:mysql://sql2.lab.ic.unicamp.br:3306/mc536db25",
		// "mc536user25", "uiphohre");
		// dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		// return dataSource;

		return (DataSource) context.getBean("dataSource");
	}
}
