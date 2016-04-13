package com.test.jpa.entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa.survey.dao.SurveyQuestionTypeDao;
import com.jpa.survey.entity.SurveyQuestionType;
import com.jpa.survey.file.SurveyQuestionTypeFileImporter;
import com.jpa.survey.vo.SurveyQuestionTypeVO;

public class SurveyQuestionTypeTest extends
		GenericTest<SurveyQuestionTypeDao, SurveyQuestionType> {

	protected SurveyQuestionTypeTest() throws InstantiationException,
			IllegalAccessException {
		super(SurveyQuestionTypeDao.class);
	}

	@Override
	public SurveyQuestionType creatOne() {
		return null;
	}
	
	public void testExport() throws JsonProcessingException{
		SurveyQuestionTypeVO vo=new SurveyQuestionTypeVO();
		HashMap<String, String> maping= new HashMap<String, String>();
		maping.put("SS", "Single Selection");
		maping.put("MS", "Multiple Selection");
		maping.put("TV", "free Text Value");
		maping.put("DD", "Drop Down list");
		maping.put("DT", "Date Time");
		maping.put("TA", "Text Area");
		
		List<SurveyQuestionType> types= new ArrayList<SurveyQuestionType>();
		for(String key:maping.keySet()){
			SurveyQuestionType type=new SurveyQuestionType();
			type.setCode(key);
			type.setDescription(maping.get(key));
			types.add(type);
		}
		
		vo.setSurveyQuestionTypes(types);
		
		ObjectMapper mapper = new ObjectMapper();
		String v=mapper.writeValueAsString(vo);
		
		System.out.println(v);
		
	}
	
	public void testImport(){
		SurveyQuestionTypeFileImporter importer=new SurveyQuestionTypeFileImporter();
		try {
			importer.importQuestionType("data/Survey_Question_Types.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		try {
			SurveyQuestionTypeTest test=new SurveyQuestionTypeTest();
			test.testExport();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
