package by.tms.tmsmyproject.controllers.upload;

import by.tms.tmsmyproject.services.impl.FileService;
import by.tms.tmsmyproject.utils.validators.FileValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/files")
@AllArgsConstructor
public class FilesController {

    private static final Integer MAX_FILE_SIZE = 500000;

    private final FileService fileService;

    @GetMapping("/upload")
    public String getUploadFilePage() {
        return "files/upload";
    }

    @PostMapping("/upload")
    public String uploadFile(Model model, @RequestParam("image") MultipartFile file) {
        if(validateSizeFileHasError(file,model)){
            return "files/upload";
        }

        String fileName = file.getOriginalFilename();
        fileService.upload(file);
        model.addAttribute("msg", "Uploaded images: " + fileName);
        return "files/upload";
    }

    private static boolean validateSizeFileHasError(MultipartFile file, Model model) {
        if (file.isEmpty()) {
            model.addAttribute("warn", "Select file");
            return true;
        }
        if (file.getSize() > MAX_FILE_SIZE) {
            model.addAttribute("warn", "File size limit exceeded");
            return true;
        }
        return false;
    }

}
