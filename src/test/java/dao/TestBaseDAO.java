package dao;

import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class TestBaseDAO {
	public SingleConnectionDataSource getConnectionDataSource(){
		SingleConnectionDataSource ds = new SingleConnectionDataSource();
	    ds.setDriverClassName("com.mysql.jdbc.Driver");
	    ds.setUrl("jdbc:mysql://sql2.lab.ic.unicamp.br:3306/dbmc437grp3");
	    ds.setUsername("umc437grp3");
	    ds.setPassword("wikophoo");
	    
	    return ds;
	}
}
