package tn.esprit.beautifulminds.services.other;

import java.io.IOException;

import javax.ejb.Local;

@Local
public interface ConversionServiceLocal {

	public byte[] fileToByte(String path) throws IOException;

	public String byteToText(byte[] array);

	public byte[] convertPDFToByteArray(String path);

}
