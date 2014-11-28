package mc437.service;

import mc437.bean.ITestResultBean;
import mc437.dao.TesteDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ITestResultService implements ITestResultInterface{
	@Autowired
	TesteDAO testeDAO;
	
	public void save(ITestResultBean xmlFile){
		xmlFile.setId(testeDAO.saveFile(xmlFile));
	}
}
