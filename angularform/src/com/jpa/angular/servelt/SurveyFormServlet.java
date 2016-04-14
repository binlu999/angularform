package com.jpa.angular.servelt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jpa.survey.file.SurveyFormFileImporter;
import com.jpa.survey.vo.SurveyFormVO;

public class SurveyFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(SurveyFormServlet.class
			.getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		log.info("doGet");
		super.doGet(req, resp);
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		log.info("Service");
		getFormJSON(res);

	}

	private void getFormJSON(ServletResponse res) {
		SurveyFormFileImporter importer = new SurveyFormFileImporter();
		ObjectMapper mapper = new ObjectMapper();
		SurveyFormVO formVO;
		try {
			formVO = importer
					.importFileToObjectByGson("data/MLM_Life_Survey.json");
			Gson gson = new Gson();
			String json = gson.toJson(formVO);
			res.getWriter().println(json);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
