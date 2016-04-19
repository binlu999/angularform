package com.jpa.util;

import java.util.Iterator;
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
import com.jpa.angular.servelt.SurveyFormServlet;

public class JSPUtil {

	private static final Logger log = Logger.getLogger(JSPUtil.class.getName());

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
