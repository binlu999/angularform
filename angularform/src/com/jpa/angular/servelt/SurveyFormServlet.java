package com.jpa.angular.servelt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
import com.google.gson.GsonBuilder;
import com.jpa.survey.file.SurveyFormFileImporter;
import com.jpa.survey.file.SurveyQuestionTypeFileImporter;
import com.jpa.survey.vo.SurveyFormVO;
import com.jpa.survey.vo.SurveyQuestionTypeVO;
import com.jpa.util.EmailSender;
import com.jpa.util.JSPUtil;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Text;

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
		String requesttype = req.getParameter("requesttype");
		if ("forform".equals(requesttype)) {
			getFormJSON(req,res);
		} else if ("saveform".equals(requesttype)) {
			saveSurveyResponse(req, res);
		}else if ("forquestiontype".equals(requesttype)) {
			getQuestionTypesJSON(res);
		}

	}

	private void getQuestionTypesJSON(ServletResponse res) {
		SurveyQuestionTypeFileImporter importer = new SurveyQuestionTypeFileImporter();
		SurveyQuestionTypeVO vo;
		try {
			vo = importer.importQuestionTypeByGSON("data/Survey_Question_Types.json");
			Gson gson = new Gson();
			String json = gson.toJson(vo);
			res.getWriter().println(json);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void saveSurveyResponse(ServletRequest req, ServletResponse res)
			throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				req.getInputStream()));
		StringBuilder json = new StringBuilder();

		if (br != null) {
			try {
				String line = null;
				while ((line = br.readLine()) != null) {
					json.append(line);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				br.close();
			}
		}
		
		EmailSender.send(json.toString());
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		SurveyFormVO surveyFormVO=gson.fromJson(json.toString(), SurveyFormVO.class);
		JSPUtil.save(surveyFormVO);
		log.info(json.toString());
	}

	private void getFormJSON(ServletRequest req, ServletResponse res) {
		
		String key=req.getParameter("formkey");
		SurveyFormVO formVO;
		if(key.length()>20){
			try {
				String json=JSPUtil.getByKey(key);
				res.getWriter().println(json);
				return;
			} catch (EntityNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		SurveyFormFileImporter importer = new SurveyFormFileImporter();
		
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
