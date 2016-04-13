

/*
	  var d = new Date();
	  userObj.search.toDate = (d.getMonth()+1) + '/' + d.getDate() + '/' + d.getFullYear();
	  d.setDate(d.getDate()-30);
	  userObj.search.fromDate = (d.getMonth()+1) + '/' + d.getDate() + '/' + d.getFullYear();
*/

function getDefaultToDate() {
	var d = new Date();
	var dateStr = getFormattedDateStr(d);
	
	return dateStr;
}

function getDefaultFromDate() {
	var d = new Date();
	d.setDate(d.getDate()-30);
	var dateStr = getFormattedDateStr(d);
	
	return dateStr;
}


function getFormattedDateStr(d) {
	var dd = d.getDate();
	if (dd < 10) {
		dd = '0' + dd;
	}
	
	var mm = d.getMonth() + 1;
	if (mm < 10) {
		mm = '0' + mm;
	}
	
	var yyyy = d.getFullYear();
	
	var retDate = mm + '/' + dd + '/' + yyyy;
	
	return retDate;
}

/*
if (data.indexOf("pkmslogin.form") != -1 || data.indexOf("LoginForm") != -1){
	alert("Your Session Has Timed Out. Please log in again.");
	window.location = cmodRenderUrl;
	
	return;
	}			 
*/		

function isSessionExpired(data) {
	var sessionExpiredF = false;
	
	if (data) {
		var dataStr = data.toString();
		if (dataStr.indexOf("pkmslogin.form") != -1 || dataStr.indexOf("LoginForm") != -1){
			sessionExpiredF = true;			
		}
	}
	
	return sessionExpiredF;
}



function isProcessingError(data) {
	var errorF = false;
	
	if (data) {
		var resultStatus = data.resultStatus;
		if (resultStatus == 'error') {
			errorF = true;
		}
	} else {
		errorF = true;
	}
	
	return errorF;
}






