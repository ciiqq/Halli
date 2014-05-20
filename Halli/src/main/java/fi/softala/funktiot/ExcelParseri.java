package fi.softala.funktiot;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import fi.softala.bean.Kouluttaja;

public abstract class ExcelParseri {
	
	
	public static List<Kouluttaja> parseta(MultipartFile file){
		List<Kouluttaja> lista = new LinkedList<Kouluttaja>();
		
		
		try {
			InputStream input = new BufferedInputStream(new FileInputStream(multipartToFile(file)));
			
			if (file.getOriginalFilename().substring(file.getOriginalFilename().length()-1).equals("s")){
				HSSFWorkbook wb = new HSSFWorkbook(input);
				HSSFSheet sheet = wb.getSheetAt(0);
				Iterator rows = sheet.rowIterator();
				
				while(rows.hasNext()){
					HSSFRow row = (HSSFRow) rows.next();
					Iterator cells = row.cellIterator();
					Kouluttaja kouluttaja = new Kouluttaja();
					
					for(int i = 0; i < 2; i++){
						HSSFCell cell = (HSSFCell) cells.next();
						
						if(i == 0){
							kouluttaja.setOpiskelijanro(cell.getStringCellValue());
						
						}else{
							String kokonimi = cell.getStringCellValue();
							System.out.println(kokonimi);
							String[] nimi = kokonimi.split(" ");
							String sukunimi = "";
							for (int ii = 0; ii < nimi.length-1; ii++){
								if (ii != 0)
									sukunimi += " ";
								sukunimi += nimi[ii];
							}
							kouluttaja.setSukunimi(sukunimi);
							kouluttaja.setEtunimi(nimi[nimi.length - 1]);
						}
					
					
				}
				lista.add(kouluttaja);
				
			}
			}else{
				XSSFWorkbook wb = new XSSFWorkbook(input);
				XSSFSheet sheet = wb.getSheetAt(0);
				Iterator rows = sheet.rowIterator();
				
				while(rows.hasNext()){
					XSSFRow row = (XSSFRow) rows.next();
					Iterator cells = row.cellIterator();
					Kouluttaja kouluttaja = new Kouluttaja();
					
					for(int i = 0; i < 2; i++){
						XSSFCell cell = (XSSFCell) cells.next();
						
						if(i == 0){
							kouluttaja.setOpiskelijanro(cell.getStringCellValue());
						
						}else{
							String kokonimi = cell.getStringCellValue();
							System.out.println(kokonimi);
							String[] nimi = kokonimi.split(" ");
							String sukunimi = "";
							for (int ii = 0; ii < nimi.length-1; ii++){
								if (ii != 0)
									sukunimi += " ";
								sukunimi += nimi[ii];
							}
							kouluttaja.setSukunimi(sukunimi);
							kouluttaja.setEtunimi(nimi[nimi.length - 1]);
						}
					
					
				}
				lista.add(kouluttaja);
			}
			
			
			
			}
			}catch(IOException e){
			e.printStackTrace();
		}
		
		for(int i = 0; i < lista.size(); i++)
			System.out.println(lista.get(i));
		
		return lista;
	}
	
	private static File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException{
       File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + 
                               multipart.getOriginalFilename());
       multipart.transferTo(tmpFile);
       
       return tmpFile;
	}
}
