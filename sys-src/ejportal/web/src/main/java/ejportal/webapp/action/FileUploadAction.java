/**************************************************************************
 * ejPortal
 * ==============================================
 * Copyright (C) 2010-2012 by 
 *   - Christoph P. Neumann (http://www.chr15t0ph.de)
 *   - Florian Irmert
 *   - and the SWAT 2010 team
 **************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 **************************************************************************
 * $Id$
 *************************************************************************/
package ejportal.webapp.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;
import org.appfuse.Constants;

import com.opensymphony.xwork2.Action;

/**
 * Sample action that shows how to do file upload with Struts 2.
 */
public class FileUploadAction extends BaseAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9208910183310010569L;

	/** The file. */
	private File file;

	/** The file content type. */
	private String fileContentType;

	/** The file file name. */
	private String fileFileName;

	/** The name. */
	private String name;

	/**
	 * Upload the file.
	 * 
	 * @return String with result (cancel, input or sucess)
	 * @throws Exception
	 *             if something goes wrong
	 */
	public String upload() throws Exception {
		if (this.cancel != null)
			return "cancel";

		// the directory to upload to
		final String uploadDir = ServletActionContext.getServletContext()
				.getRealPath("/resources")
				+ "/"
				+ this.getRequest().getRemoteUser() + "/";

		// write the file to the file specified
		final File dirPath = new File(uploadDir);

		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}

		// retrieve the file data
		final InputStream stream = new FileInputStream(this.file);

		// write the file to the file specified
		final OutputStream bos = new FileOutputStream(uploadDir
				+ this.fileFileName);
		int bytesRead;
		final byte[] buffer = new byte[8192];

		while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
			bos.write(buffer, 0, bytesRead);
		}

		bos.close();
		stream.close();

		// place the data into the request for retrieval on next page
		this.getRequest().setAttribute(
				"location",
				dirPath.getAbsolutePath() + Constants.FILE_SEP
						+ this.fileFileName);

		final String link = this.getRequest().getContextPath() + "/resources"
				+ "/" + this.getRequest().getRemoteUser() + "/";

		this.getRequest().setAttribute("link", link + this.fileFileName);

		return Action.SUCCESS;
	}

	/**
	 * Default method - returns "input".
	 * 
	 * @return "input"
	 */
	@Override
	public String execute() {
		return Action.INPUT;
	}

	/**
	 * Sets the file.
	 * 
	 * @param file
	 *            the new file
	 */
	public void setFile(final File file) {
		this.file = file;
	}

	/**
	 * Sets the file content type.
	 * 
	 * @param fileContentType
	 *            the new file content type
	 */
	public void setFileContentType(final String fileContentType) {
		this.fileContentType = fileContentType;
	}

	/**
	 * Sets the file file name.
	 * 
	 * @param fileFileName
	 *            the new file file name
	 */
	public void setFileFileName(final String fileFileName) {
		this.fileFileName = fileFileName;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the file.
	 * 
	 * @return the file
	 */
	public File getFile() {
		return this.file;
	}

	/**
	 * Gets the file content type.
	 * 
	 * @return the file content type
	 */
	public String getFileContentType() {
		return this.fileContentType;
	}

	/**
	 * Gets the file file name.
	 * 
	 * @return the file file name
	 */
	public String getFileFileName() {
		return this.fileFileName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate() {
		if (this.getRequest().getMethod().equalsIgnoreCase("post")) {
			this.getFieldErrors().clear();
			if ("".equals(this.fileFileName) || (this.file == null)) {
				super.addFieldError("file", this.getText(
						"errors.requiredField",
						new String[] { this.getText("uploadForm.file") }));
			} else if (this.file.length() > 2097152) {
				this.addActionError(this.getText("maxLengthExceeded"));
			}
		}
	}
}
