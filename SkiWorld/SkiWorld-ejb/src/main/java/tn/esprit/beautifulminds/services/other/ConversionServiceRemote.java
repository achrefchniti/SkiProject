package tn.esprit.beautifulminds.services.other;

import javax.ejb.Remote;

@Remote
public interface ConversionServiceRemote {

	public byte[] convertPDFToByteArray(String path);

	public String byteToText(byte[] array);
}
