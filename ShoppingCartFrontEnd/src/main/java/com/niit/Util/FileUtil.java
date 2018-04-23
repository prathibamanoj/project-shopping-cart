/*package com.niit.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

	private static final String imageDirectory = "ShoppingCartImages";
	private static String rootPath = System.getProperty("catalina.home");

	public static boolean fileCopyNIO(MultipartFile file, String fileName) {
		if (file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// creating the directory to store file

				String rootpath = System.getProperty("catalina.home");
				File dir = new File(rootpath + File.separator + fileName);
				if (!dir.exists())
					dir.mkdir();

				// create the file on server

				File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				logger.info("Server File Location=" + serverFile.getAbsolutePath());

				return true;
			} catch (Exception e) {
				return false;

			}
		} else {
			return false;
		}
	}
}


 * File dest = new File(rootPath + File.separator + imageDirectory +
 * File.separator + fileName);
 * 
 * if (!dest.exists()) { dest.mkdir(); }
 * 
 * try { file.transferTo(dest); return true; } catch (Exception e) { // TODO
 * Auto-generated catch block e.printStackTrace(); }
 * 
 * return false; }
 * 
 * }
 





package com.niit.util;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

	private static final String imageDirectory = "ShoppingCartImages";
	//private static String rootPath = System.getProperty("catalina.home");
	private static final String imageDirectory = "resources//images//";
    private static String rootPath = "resources//images//";
	public static boolean fileCopyNIO(MultipartFile file, String fileName) {

		File dest = new File(rootPath + File.separator + imageDirectory + File.separator + fileName);

		if (!dest.exists()) {
			dest.mkdir();
		}

		try {
			file.transferTo(dest);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}*/




package com.niit.util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component // will create singleton instance and the instance name is fileUtil
public class FileUtil {
	
	@Autowired
	private  HttpSession httpSession;
	

	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

	//private static final String imageDirectory = "ShoppingCartImages";
	//private static String rootPath = System.getProperty("catalina.home");
    private static String rootPath = "C:\\Users\\syeds\\eclipse-workspace\\ShoppingCartFrontEnd\\src\\main\\webapp\\resources\\images";
	 /* private static String rootPath = System.getProperty("user.dir");*/
	public static  boolean fileCopyNIO(MultipartFile file,String fileName) {
System.out.println(rootPath);
		File dest = new File(rootPath+File.separator  + fileName);
		System.out.println("where it is uploading ??"+ dest.getAbsolutePath());
		/*if (!dest.exists()) {
			dest.mkdir();
		}*/

		try {
			file.transferTo(dest);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
