package tn.esprit.beautifulminds.services.other;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class ConversionService
 */
@Stateless

public class ConversionService implements ConversionServiceLocal, ConversionServiceRemote {

	/**
	 * Default constructor.
	 */
	public ConversionService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public byte[] fileToByte(String path) throws IOException {
		// TODO Auto-generated method stub
		File file = new File(path);
		InputStream input = new FileInputStream(file);
		byte[] bytesArray = new byte[(int) file.length()];
		input.read(bytesArray); // read file into bytes[]
		input.close();
		return bytesArray;
	}

	public static byte[] readFully(InputStream stream) throws IOException {
		byte[] buffer = new byte[8192];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		int bytesRead;
		while ((bytesRead = stream.read(buffer)) != -1) {
			baos.write(buffer, 0, bytesRead);
		}
		return baos.toByteArray();
	}

	public static byte[] loadFile(String sourcePath) throws IOException {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(sourcePath);
			return readFully(inputStream);
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

	@Override
	public String byteToText(byte[] array) {
		// TODO Auto-generated method stub
		String s = new String(array);
		return s;
	}

	public byte[] convertPDFToByteArray(String path) {

		InputStream inputStream = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {

			inputStream = new FileInputStream(path);

			byte[] buffer = new byte[1024];
			baos = new ByteArrayOutputStream();

			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		byte[] finalbytes = Base64.getEncoder().encode(baos.toByteArray());
		return finalbytes;
	}

	public static void convertByteArrayToDoc(byte[] b) {

		OutputStream out;
		try {
			out = new FileOutputStream("C:\\Users\\USER\\Desktop\\CVs\\test.pdf");
			out.write(b);
			out.close();
			System.out.println("write success");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
