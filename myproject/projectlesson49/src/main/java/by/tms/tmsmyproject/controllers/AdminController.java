package by.tms.tmsmyproject.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    @GetMapping()
    public String getAdminPage() {
        return "/admin/admin-page";
    }
}
