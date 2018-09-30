package com.cluster.test.config;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.zip.ZipFile;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Configuration 
{
	@BeforeSuite
	public void preSetUp()
	{
		File fileToDelete = new File("./test-output");
		try
		{
			FileUtils.deleteDirectory(fileToDelete);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@AfterSuite
	public void postExecution()
	{
		Date d = new Date();
		String zipFileName = d.toString().replace(":", "_");
		File fileToCopy = new File("./test-output/");
		File fileToSave = new File("./results-archive/"+ zipFileName +".zip");
		// Update
	}
}
