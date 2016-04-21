package com.jpa.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.KeyRange;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Text;
import com.google.gson.Gson;
import com.jpa.angular.servelt.SurveyFormServlet;
import com.jpa.survey.vo.SurveyFormVO;

public class JSPUtil {

	private static final Logger log = Logger.getLogger(JSPUtil.class.getName());

public static void save(SurveyFormVO surveyFormVO){
		
		String formKey = surveyFormVO.getFormDescription();
		formKey=formKey.replaceAll(" ", "_");
		Gson gson = new Gson();
		String json = gson.toJson(surveyFormVO);
		
		Text text=new Text(json);
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity voentity = new Entity("SurveyFormVO", formKey);
		voentity.setProperty("formData", text);
		datastore.put(voentity);
		log.info("FOrm saved");
	}


	public static List<String> getAllFormIDs() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		List<String> rs=new ArrayList<>();
		Query q = new Query("SurveyFormVO");
		PreparedQuery pq = datastore.prepare(q);
		for (Entity result : pq.asIterable()) {
			Key key = result.getKey();
			String id=key.getName();
			rs.add(id);
		}
		return rs;
	}
	public static String getAllForms() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		StringBuilder sb=new StringBuilder("");
		Query q = new Query("SurveyFormVO");
		PreparedQuery pq = datastore.prepare(q);
		for (Entity result : pq.asIterable()) {
			Key key = result.getKey();
			String keyString = KeyFactory.keyToString(key);
			String name=key.getName();
			sb.append("<A href='/tabs.jsp?key="+keyString+"'>"+name+"</><br>");
			log.info(result.getKey().toString());
		}
		return sb.toString();
	}

	public static String getByKey(String keyString) throws EntityNotFoundException {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		
		Key key = KeyFactory.stringToKey(keyString);
		Entity entity = datastore.get(key);
		Text text=(Text)entity.getProperty("formData");
		String json=text.getValue();
		
		return json;
	}
}
