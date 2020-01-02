package com.administrationrh.restweb;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.administrationrh.domain.Enseignent;
import com.administrationrh.domain.Fonctionnaire;
import com.administrationrh.domain.Rapport;
import com.administrationrh.service.EnseignentService;
import com.administrationrh.service.RapportService;
import com.administrationrh.service.StorageService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;

@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class EnseignentRestController {
	
	@Autowired
	private EnseignentService enseignentService;
	
	@Autowired
	private RapportService rapportService;
	
	@Autowired
	StorageService storageService;
	
	@Autowired
	ApplicationContext applicationContext ;


	/**
	 * getAllEnseignents
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/enseignents/", method = RequestMethod.GET)
	@ResponseBody public List<Enseignent> getAllEnseignents(){
		return enseignentService.getAllEnseignent();
	}
	
	/**
	 * addEnseignent
	 * @param enseignent
	 * @return
	 */
	@RequestMapping(value="/enseignent/", method=RequestMethod.PUT)
	public ResponseEntity<?> addEnseignent(@RequestBody Enseignent enseignent){
		enseignentService.addEnseignent(enseignent);
        return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	/**
	 * findEnseignentsByEcole
	 * @param ecoleId
	 * @return
	 */
	@RequestMapping(value = "/enseignentsByEcole/{ecoleId}", method = RequestMethod.GET)
	@ResponseBody public List<Enseignent> findEnseignentsByEcole(@PathVariable("ecoleId") Long ecoleId){
		return enseignentService.findEnseignentsByEcole(ecoleId);
	}
	
	/**
	 * findEnseignentById
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/enseignent/{id}", method = RequestMethod.GET)
	@ResponseBody public Enseignent findEnseignentById(@PathVariable("id") Long id){
		return enseignentService.findEnseignentsById(id);
	}
	
	/**
	 *  upload file
	 * @param file
	 * @param reportOwner
	 * @return
	 */
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
			System.out.println("saving rapport");
			
		} catch (Exception e) {
			e.getMessage();
		}
		return "uploadForm";
	}
	
	/**
	 * get file by name
	 * @param filename
	 * @return
	 */
	@RequestMapping(value = "/enseignents/files/{filename:.+}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = storageService.loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
	
	
	/**
	 * get reports 
	 * @param enseignentId
	 * @return
	 */
	@RequestMapping(value = "/enseignent/reports/{enseignentId}", method = RequestMethod.GET)
	@ResponseBody public List<Rapport> getEnseignentReports(@PathVariable Long enseignentId){
		return enseignentService.getEnseignentReports(enseignentId);
	}
	
	/**
	 * generate pfd report
	 * @return
	 * @throws JRException
	 */
	@RequestMapping(value="/enseignent/pdfReport", method=RequestMethod.GET)
	public ModelAndView getPdf() throws JRException {
		
	    JasperReportsPdfView view = new JasperReportsPdfView();
	    
	    List< Map<String, Object>> datasource = new ArrayList<Map<String, Object>>();
	    Map<String, Object> p = new HashMap();
	    p.put("firstname","Dadi med");
	    
	    datasource.add(p);
	    
	    view.setUrl("classpath:/reports/report.jrxml");
	    Map<String, Object> params = new HashMap<>();
	    params.put("firstname", "Dadi ");
	    params.put("lastname", "Mohamed ");
	    params.put("datasource", datasource);
	    view.setApplicationContext(applicationContext);
	    return new ModelAndView(view, params);   
	    
	}
	
 
}
