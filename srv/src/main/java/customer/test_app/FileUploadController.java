package customer.test_app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import com.google.common.net.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FileUploadController {
	
    @RequestMapping(value = "/upload", method = RequestMethod.POST, 
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
 
 public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
    File convertFile = new File("/var/tmp/"+file.getOriginalFilename());
    convertFile.createNewFile();
    FileOutputStream fout = new FileOutputStream(convertFile);
    fout.write(file.getBytes());
    fout.close();
    return "File is upload successfully";
 }
}