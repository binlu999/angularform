package com.jpa.survey.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa.survey.dao.SurveyFormDao;
import com.jpa.survey.entity.SurveyForm;
import com.jpa.survey.vo.SurveyFormVO;

public class SurveyFormFileExporter {
	private SurveyFormDao surveyFormDao = new SurveyFormDao();
	ObjectMapper mapper = new ObjectMapper();

	public void export(String destDir) throws JsonGenerationException, JsonMappingException, IOException {
		List<SurveyForm> forms = surveyFormDao.findAll();
		for (SurveyForm form : forms) {
			SurveyFormVO formVO = new SurveyFormVO(form);
			String fileName = destDir
					+ File.separator
					+ StringUtils
							.replace(formVO.getFormDescription(), " ", "_")+"_"+formVO.getSurveyFormId()+".json";
			export(formVO,fileName);
		}
	}

	public void export(SurveyFormVO formVO, String fileName)
			throws JsonGenerationException, JsonMappingException, IOException {
		/*
		File output=new File(fileName);
		FileOutputStream os=new FileOutputStream(output);
		mapper.writeValue(os, formVO);
		os.close();*/
	}
}
