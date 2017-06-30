package br.com.melao.corretora.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.melao.corretora.model.comum.Endereco;
import br.com.melao.corretora.model.segurado.Segurado;

public class CarregarTabelaSegurado {
	private static String FILE_NAME = "Pasta1.xlsx";
	
	

	public static void main(String[] args) {

		try {
			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			
			while(iterator.hasNext()) {
				Row currentRow = iterator.next();
				
				Iterator<Cell> cellIterator = currentRow.iterator();
				
					
					
					Segurado segurado = new Segurado();
					
					
					segurado.setNome(cellIterator.next().getStringCellValue());
					segurado.setCpf(cellIterator.next().getStringCellValue());
					
					
					Endereco endereco = new Endereco();
					
					
					endereco.setRua(cellIterator.next().getStringCellValue());
					endereco.setNumero(cellIterator.next().getStringCellValue());
					
					
					
					
					
					
					
				
				}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
}
