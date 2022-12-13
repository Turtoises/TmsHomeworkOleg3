package by.tms.tmsmyproject.controllers.upload;

import by.tms.tmsmyproject.services.impl.FileService;
import by.tms.tmsmyproject.utils.validators.FileValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/files")
@AllArgsConstructor
public class FilesController {

    private final FileService fileService;
    private final FileValidator fileValidator;

    @GetMapping("/upload")
    public String getUploadFilePage() {
        return "files/upload";
    }

    @PostMapping("/upload")
    public String uploadFile(Model model, @RequestParam("image") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        fileService.upload(file);
        model.addAttribute("msg", "Uploaded images: "+fileName);
        return "files/upload";
    }
}
