package com.test.jpa.entity;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.jpa.survey.dao.SurveyFormDao;
import com.jpa.survey.entity.SurveyForm;
import com.jpa.survey.file.SurveyFormFileExporter;
import com.jpa.survey.file.SurveyFormFileImporter;

public class SurveyFormTest extends GenericTest<SurveyFormDao, SurveyForm> {

	public SurveyFormTest() throws InstantiationException,
			IllegalAccessException {
		super(SurveyFormDao.class);
	}

	public SurveyForm creatOne() {
		SurveyForm e = new SurveyForm();
		e.setCompanyCode("101");
		e.setMarketArea("MLM");
		e.setProdCode("Life");
		e.setFormDescription("MLM Life  Survey");
		e.setInactiveFlag(false);
		e.setLastUPDTId("SYSTEM ADMIN");
		e.setLastUPDTDate(new Date());
		assert (e.getSurveyFormId() == 0);
		return e;
	}

	public void testFindAll(){
		List<SurveyForm> forms = this.dao.findAll();
	}
	

	public void testExport(){
		SurveyFormFileExporter exporter=new SurveyFormFileExporter();
		try {
			exporter.export("c:\\tmp\\survey");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void testImport(){
		SurveyFormFileImporter importer=new SurveyFormFileImporter();
		try {
			importer.importFile("data/MLM_Life_Survey.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void testDeleteAll(){
		this.dao.deletAll();
	}
	
}
