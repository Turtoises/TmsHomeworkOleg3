package by.tms.tmsmyproject.controllers.upload;

import by.tms.tmsmyproject.entities.dto.upload.UploadResult;
import by.tms.tmsmyproject.services.impl.FileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Tag(name = "Files", description = "Work with files")
@RequestMapping("/rest/files")
@AllArgsConstructor
public class FilesRestController {

    private final FileService fileService;

    @PostMapping("/upload")
    @Operation(summary = "Uploading")
    public UploadResult upload(@RequestParam("file") MultipartFile file) {
        return fileService.upload(file);
    }
}
