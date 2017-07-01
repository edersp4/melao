package br.com.melao.corretora.controller.segurado;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.melao.corretora.model.comum.Endereco;
import br.com.melao.corretora.model.segurado.Segurado;
import br.com.melao.corretora.service.segurado.SeguradoService;

@Controller
public class CarregarTabelaSegurado {
	private static String FILE_NAME = "Pasta1.xlsx";

	@Autowired
	private SeguradoService service;

	@RequestMapping(value = "/carregarTabela")
	public void carregarTabelas(String[] args) {

		try {
			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			@SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();

			while (iterator.hasNext()) {
				Row currentRow = iterator.next();

				Iterator<Cell> cellIterator = currentRow.iterator();

				Segurado segurado = new Segurado();

				segurado.setNome(cellIterator.next().getStringCellValue());
				segurado.setCpf(cellIterator.next().getStringCellValue());

				Endereco endereco = new Endereco();

				endereco.setRua(cellIterator.next().getStringCellValue());
				endereco.setNumero(cellIterator.next().getStringCellValue());
				endereco.setComplemento(cellIterator.next().getStringCellValue());
				endereco.setBairro(cellIterator.next().getStringCellValue());
				endereco.setCidade(cellIterator.next().getStringCellValue());
				endereco.setEstado(cellIterator.next().getStringCellValue());
				endereco.setCep(cellIterator.next().getStringCellValue());

				segurado.setCelular(cellIterator.next().getStringCellValue());
				segurado.setTelefone(cellIterator.next().getStringCellValue());
				segurado.setTelefoneTrab(cellIterator.next().getStringCellValue());
				segurado.setEmail(cellIterator.next().getStringCellValue());

				segurado.setEndereco(endereco);

				service.gravarUsuarioOuAtualizar(segurado);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
