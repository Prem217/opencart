package extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readexcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream file=new FileInputStream("F://Framewrok//extra//excel//ClassDemos//testdata//data.xlsx");
		XSSFWorkbook wb =new XSSFWorkbook(file);
		XSSFSheet sheet=wb.getSheet("sheet1");
		
		int totalrow=sheet.getLastRowNum();
		int totalcell=sheet.getRow(0).getLastCellNum();
		
		for(int i=0;i<=totalrow;i++)
		{
			XSSFRow currentrow=sheet.getRow(i);
			for(int j=0;j<totalcell;j++)
			{
				XSSFCell cell=currentrow.getCell(j);
				System.out.print(cell.toString()+"\t");
			}
			System.out.println();
		}
		
		
		
			
		

	}

}
