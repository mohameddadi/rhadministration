package com.administrationrh.restweb;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.administrationrh.domain.Enseignent;
import com.administrationrh.domain.Fonctionnaire;
import com.administrationrh.domain.Rapport;
import com.administrationrh.service.EnseignentService;
import com.administrationrh.service.RapportService;
import com.administrationrh.service.StorageService;

@RestController
public class EnseignentRestController {
	
	@Autowired
	private EnseignentService enseignentService;
	
	@Autowired
	private RapportService rapportService;
	
	@Autowired
	StorageService storageService;

	@RequestMapping(value = "/enseignents/", method = RequestMethod.GET)
	@ResponseBody public List<Enseignent> getAllEnseignents(){
		return enseignentService.getAllEnseignent();
	}
	
	@RequestMapping(value="/enseignent/", method=RequestMethod.PUT)
	public ResponseEntity<?> addEnseignent(@RequestBody Enseignent enseignent){
		enseignentService.addEnseignent(enseignent);
        return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/enseignentsByEcole/{ecoleId}", method = RequestMethod.GET)
	@ResponseBody public List<Enseignent> findEnseignentsByEcole(@PathVariable("ecoleId") Long ecoleId){
		return enseignentService.findEnseignentsByEcole(ecoleId);
	}
	
	@RequestMapping(value = "/enseignent/{id}", method = RequestMethod.GET)
	@ResponseBody public Enseignent findEnseignentById(@PathVariable("id") Long id){
		return enseignentService.findEnseignentsById(id);
	}
	
	@RequestMapping(value = "/enseignents/uploadFile", method = RequestMethod.POST)
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			@RequestParam("reportOwner") Long reportOwner) {
		try {
			
			storageService.store(file);
			Rapport rapport = new Rapport();
			rapport.setDateCreation(new Date());
			rapport.setPath("file:///C:/Users/Dadi/Documents/workspace-sts-3.8.3.RELEASE/administrationrh/upload-dir/"+file.getOriginalFilename());
			rapport.setName(file.getOriginalFilename());
			Fonctionnaire owner = enseignentService.findEnseignentsById(reportOwner);
			rapport.setOwner(owner);
			rapportService.addRapport(rapport);
			System.out.println("saving rapport ");
			
		} catch (Exception e) {
			e.getMessage();
		}
		return "uploadForm";
	}
	
	@RequestMapping(value = "/enseignents/files/{filename:.+}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = storageService.loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
 
}
