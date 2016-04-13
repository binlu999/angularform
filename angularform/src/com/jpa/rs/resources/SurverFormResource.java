package com.jpa.rs.resources;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa.survey.dao.SurveyFormDao;
import com.jpa.survey.entity.SurveyForm;
import com.jpa.survey.file.SurveyFormFileImporter;
import com.jpa.survey.vo.SurveyFormVO;

@Path("/surveyform")
public class SurverFormResource {

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getJSON() throws IOException {
		SurveyFormFileImporter importer = new SurveyFormFileImporter();
		ObjectMapper mapper = new ObjectMapper();
		SurveyFormVO formVO = importer
				.importFileToObject("data/MLM_Life_Survey.json");
		String res = "";
		res = mapper.writeValueAsString(formVO);
		return Response.ok(res).build();
	}

}
