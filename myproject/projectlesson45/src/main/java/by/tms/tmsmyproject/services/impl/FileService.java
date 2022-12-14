package by.tms.tmsmyproject.services.impl;

import by.tms.tmsmyproject.entities.dto.upload.UploadResult;
import by.tms.tmsmyproject.exception.FilesUploadException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {

    public UploadResult upload(MultipartFile file) {
        if (file.isEmpty()) {
            throw new FilesUploadException("File's empty");
        }
        Path destFile = Path.of(".").resolve(Paths.get(file.getOriginalFilename()))
                .normalize().toAbsolutePath();
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, destFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new FilesUploadException(String.format("Can't upload file: %s", e.getMessage()));
        }
        return UploadResult.builder().message("Successful").build();
    }
}
