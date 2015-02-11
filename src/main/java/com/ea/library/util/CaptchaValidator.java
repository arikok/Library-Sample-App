package com.ea.library.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;

public class CaptchaValidator {

	private static String url = "https://www.google.com/recaptcha/api/siteverify?secret=6Lej2_4SAAAAAKpQ3TX0oF4cOKWGX1PoarGpXBMf";

	
	

	private static final Logger logger = Logger
			.getLogger(CaptchaValidator.class);

	public static boolean validateCaptcha(String gCaptchaResponse,String remoteIp) throws Exception {

		url += "&response=" + gCaptchaResponse+"&remoteip="+remoteIp;
		boolean isCaptchaValid = false;
		try {
			logger.info("Captcha URL - "+url);
			URL urlVar = new URL(url);
			HttpURLConnection uc = (HttpURLConnection) urlVar.openConnection();
			uc.setRequestMethod("GET");
			uc.connect();

			
			BufferedReader in = new BufferedReader(new InputStreamReader(
					uc.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			logger.info("Captcha Response " + response.toString());

			JSONObject jsonObject = new JSONObject(response.toString());
			boolean success = (Boolean) jsonObject.get("success");
			if (success) {
				isCaptchaValid = true;
			} else {

				isCaptchaValid = false;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return isCaptchaValid;

	}

}
