package com.albertsalud.garage.utils.ftp;

import java.io.IOException;
import java.io.InputStream;

public interface FTPServices {
	
	public void disconnect() throws IOException;
	
	public boolean uploadFile(String destinationDir, String destionationFileName, InputStream is);
	
	public boolean deleteFile(String containingFolder, String fileName);

}
