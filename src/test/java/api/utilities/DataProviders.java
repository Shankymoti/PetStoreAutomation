package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
		
		@DataProvider(name="data")
		public String[][] getAllData() throws IOException 
		{
			String path = System.getProperty("user.dir")+"//testData//userdata.xlsx";
			
			XLUtility xl = new XLUtility(path);
			
			int rowCount = xl.getRowCount("one");
			int colCount = xl.getColCount("one", 1);
			
			String[][] apidata = new String[rowCount][colCount];
			
			for(int i = 1; i <= rowCount; i++) 
			{
				for(int j = 0; j < colCount; j++) 
				{
					apidata[i-1][j] = xl.getCellData("one", i, j);
				}
			}
			return apidata;
		}
		
		@DataProvider(name="username")
		public String[] getUsername() throws IOException 
		{
			String path = System.getProperty("user.dir")+"//testData//userdata.xlsx";
			
			XLUtility xl = new XLUtility(path);
			int rowCount = xl.getRowCount("one");
			
			String[] apidata = new String[rowCount];
			
			for(int i = 1; i <= rowCount; i++) 
			{
				apidata[i-1] = xl.getCellData("one", i, 1);
			}
			return apidata;
		}
	}

