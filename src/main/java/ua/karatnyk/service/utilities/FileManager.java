package ua.karatnyk.service.utilities;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	
	public static void saveImageInProject(MultipartFile file, String nameFolder) throws IOException {
		
		if(FileManager.pathToImageInProject(file, nameFolder) != null) {
			
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			File destination = new File(FileManager.pathToImageInProject(file, nameFolder));
			ImageIO.write(image, "png", destination);
		}
	}
	
	public static String pathToImageInProject(MultipartFile file, String nameFolder) {
		String rootPath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+File.separator+"webapp"+File.separator+nameFolder;
		File uploadDir = new File(rootPath);
		if(!uploadDir.exists()) uploadDir.mkdirs();
		if(!file.isEmpty() && file != null) {
			String pathFile = uploadDir.getAbsolutePath()+File.separator+file.getOriginalFilename();
			return pathFile;
		}
		return null;
	}
	
	public static String encodedFileToByteFromProject(String pathToFile) {
		try {
			File file = new File(pathToFile);
			byte[] fileToByteArray ;
			fileToByteArray = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
			String encodedByte = new String(fileToByteArray);
			return encodedByte;
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (FileNotFoundException e) {
			return null;
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void deleteFileFromProject(String pathToFile) {
		if(!pathToFile.isEmpty() && pathToFile != null) {
			File file = new File(pathToFile);
			file.delete();
		}
		
	}
	


}
