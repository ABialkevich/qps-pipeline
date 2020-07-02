package com.qaprosoft.jenkins.pipeline.tools.maven.sonar

import com.qaprosoft.jenkins.pipeline.integration.HttpClient

class SonarClient extends HttpClient {

	private String serviceUrl

	SonarClient(context) {
		super(context)
		serviceUrl = Configuration.get("SONAR_URL")
	}

	protected def getServerStatus() {
		def parameters = [	contentType			: 'APPLICATION_JSON',
							httpMode			: 'GET',
							validResponseCodes  : '200',
							url 				: serviceUrl + '/api/system/status' ]
		return sendRequestFormatted(parameters).find() {it.status}
	}

	protected boolean isAvailable() {
		return getServerStatus().equals('UP') ? true : false
	}
}