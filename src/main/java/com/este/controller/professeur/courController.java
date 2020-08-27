package com.este.controller.professeur;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.ServletContext;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.este.models.Cour;
import com.este.services.CourService;
 
@Controller
@RequestMapping(value="prof")
public class courController {
    @Autowired
    ServletContext context;
    
    @Autowired
    CourService courService;
    
    @RequestMapping(value="/cours" , method= RequestMethod.GET)
    public String index(ModelMap modelMap) {
    	List<Cour> cours = courService.selectAll();
    	modelMap.put("cour", cours);
    	return "professeur/cours";
    }
//    
//    @RequestMapping(value = "add/{id}",method = RequestMethod.GET)
//	public String add(@PathVariable("id") int id , ModelMap modelMap) {
//		Product product = productService.find(id);
//		Photo photo = new Photo();
//		photo.setStatus(true);
//		photo.setProduct(product);
//		modelMap.put("photo", photo); 
//		modelMap.put("product", product);
//		return "admin.photo.add";
//	}
//    
// // add photo to product 
// 		@RequestMapping(value = "add", method = RequestMethod.POST)
// 		public String add(@ModelAttribute("photo") Photo photo,
// 				@RequestParam(value="file") MultipartFile file){
// 			photo.setName(uploadFile(file));
// 			
// 			// update main of products
// 						if(photo.isMain()) {
// 							Product product = productService.find(photo.getProduct().getId());
// 							if(product.getPhotos() != null && !product.getPhotos().isEmpty()) {
// 								for(Photo p : product.getPhotos()) { 
// 									p.setMain(false);
// 									photoService.save(p);
// 								}
// 							}
// 							photo.setMain(true);
// 						}
// 				
// 			photoService.save(photo);
// 			return "redirect:/admin/photo/product/" + photo.getProduct().getId();
// 		}
// 		
// 		private String uploadFile(MultipartFile multipartFile) {
//			try {
//				byte[] bytes = multipartFile.getBytes();
//				Path path = Paths.get(servletContext.getRealPath("/uploads/images/" + multipartFile.getOriginalFilename()));
//				Files.write(path, bytes);
//				return multipartFile.getOriginalFilename();
//			} catch (Exception e) {
//				return "no-image.png";
//			}
//		}
//
//		
//		@Override
//		public void setServletContext(ServletContext servletContext) {
//			this.servletContext = servletContext ;
//			
//		}
//		
 
}