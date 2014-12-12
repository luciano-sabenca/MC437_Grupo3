package mc437.service.Interface;

import java.util.List;

import org.w3c.dom.Document;

import mc437.bean.IMutants;
import mc437.bean.ITestResultBean;

public interface IMutantsInterface {

	public List<IMutants> parserXml(Document doc);
	
	public void save(ITestResultBean iTestResultBean);
}
