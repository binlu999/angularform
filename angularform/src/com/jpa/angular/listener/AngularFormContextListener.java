package com.jpa.angular.listener;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.google.gson.Gson;
import com.jpa.survey.file.SurveyFormFileImporter;
import com.jpa.survey.vo.SurveyFormVO;
import com.jpa.util.JSPUtil;

public class AngularFormContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext ctx = event.getServletContext();
		String formDefinationFiles = ctx.getInitParameter("SURVEY_FORM_DEFINATION_FILE_NAMES");
		String questionTypeDefinationFile = ctx.getInitParameter("SURVEY_QUESTION_TYPE_DEFINATION_FILE_NAME");
		
		SurveyFormFileImporter importer = new SurveyFormFileImporter();
		
		System.out.println(formDefinationFiles);
		System.out.println(questionTypeDefinationFile);
		List<String> formIds = JSPUtil.getAllFormIDs();
		
		StringTokenizer stk=new StringTokenizer(formDefinationFiles,",");
		while(stk.hasMoreTokens()){
			String defName = stk.nextToken();
			
			
			try {
				SurveyFormVO formVO = importer
						.importFileToObjectByGson("data/"+defName+".json");
				
				String name=formVO.getFormDescription();
				name=name.replaceAll(" ", "_");
				if(!formIds.contains(name)){
					JSPUtil.save(formVO);
				}
				

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
