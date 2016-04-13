
/* JavaScript content from js/appsvc.js in folder common */
/**
 * 
 */

// vtestcheckfile
 
surveySvcMod.factory("appSvc",function() {
		var appObj = {};
		

		appObj.categories = CmodConfig.CATEGORIES;
		
		
	/*
		Checks if the PDF plugin is active
		(Uses ActivexObject for IE and navigator.plugins array for Mozilla based browsers(Firefox, Chrome, Opera, etc))
	*/
	appObj.isPDFPluginActive = function() {

	    //IE browsers
	    if (window.ActiveXObject) {
	        var control = null;
	        try {
	            // AcroPDF.PDF is used by version 7 and later
	            control = new ActiveXObject('AcroPDF.PDF');
	        } catch (e) {
	            // Do nothing
	        }
	        if (!control) {
	            try {
	                // PDF.PdfCtrl is used by version 6 and earlier
	                control = new ActiveXObject('PDF.PdfCtrl');
	            } catch (e) {
	                return false;
	            }
	        }
	        if (control) {

	            return true;
	        }
	    } else {

	        var control = null;
	        try {
	            // AcroPDF.PDF is used by version 7 and later
	            control = new ActiveXObject('AcroPDF.PDF');
	        } catch (e) {
	            // Do nothing
	        }
	        if (!control) {
	            try {
	                // PDF.PdfCtrl is used by version 6 and earlier
	                control = new ActiveXObject('PDF.PdfCtrl');
	            } catch (e) {
	                // Do nothing
	            }
	        }
	        if (control) {

	            return true;
	        }

	        
	    	
	    	// Non IE browsers
	        var plugins = navigator.plugins;

	        for(var i = 0; i < plugins.length; i++){
	            if (plugins[i].name == "Adobe Acrobat" || plugins[i].name == "Chrome PDF Viewer"){
	           		return true;
	            }
	        }
	    }
	    
	    return false;
	}

	
	

	
		
		return appObj;
});
