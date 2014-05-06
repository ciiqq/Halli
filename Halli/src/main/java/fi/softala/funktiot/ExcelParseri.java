package fi.softala.funktiot;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.web.multipart.MultipartFile;

import fi.softala.bean.Kouluttaja;

public abstract class ExcelParseri {
	
	
	public static List<Kouluttaja> parseta(MultipartFile file){
		ArrayList<Kouluttaja> lista = new ArrayList<Kouluttaja>();
		
		
		try {
			InputStream input = new BufferedInputStream(new FileInputStream(multipartToFile(file)));
			POIFSFileSystem fs = new POIFSFileSystem(input);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			Iterator rows = sheet.rowIterator();
			
			while(rows.hasNext()){
				HSSFRow row = (HSSFRow) rows.next();
				Iterator cells = row.cellIterator();
				Kouluttaja kouluttaja = new Kouluttaja();
				
				for(int i = 0; i < 2; i++){
					HSSFCell cell = (HSSFCell) cells.next();
					
					if(HSSFCell.CELL_TYPE_NUMERIC==cell.getCellType())
						kouluttaja.setOpiskelijanro(String.valueOf((int)cell.getNumericCellValue()));
					
					else if(HSSFCell.CELL_TYPE_STRING==cell.getCellType()){
						String kokonimi = cell.getStringCellValue();
						String[] nimi = kokonimi.split(" ");
						kouluttaja.setEtunimi(nimi[0]);
						kouluttaja.setSukunimi(nimi[nimi.length - 1]);
					}
					else if(HSSFCell.CELL_TYPE_BOOLEAN==cell.getCellType())
						System.out.print(cell.getBooleanCellValue()+" ");
					
					else if(HSSFCell.CELL_TYPE_BLANK==cell.getCellType())
						System.out.print("BLANK ");
					
					else
						System.out.print("Unknown cell type");
					
				}
				lista.add(kouluttaja);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return lista;
	}
	
	private static File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException{
       File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + 
                               multipart.getOriginalFilename());
       multipart.transferTo(tmpFile);
       
       return tmpFile;
	}
}
