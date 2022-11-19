package by.tms.tmsmyproject.services;

import by.tms.tmsmyproject.entities.Author;
import by.tms.tmsmyproject.entities.ResponseMessage;
import by.tms.tmsmyproject.repositories.AuthorRepository;
import by.tms.tmsmyproject.utils.AuthorMapperUtil;
import by.tms.tmsmyproject.utils.ConstantsRegex;
import by.tms.tmsmyproject.utils.FindNullAndEmptyUtil;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class AuthorServiceImpl extends AbstractAuthorService {

    AuthorRepository authorRepository;

    @Override
    public ResponseMessage deleteById(Long id) {
        return null;
    }

    @Override
    public ResponseMessage delete(Author entity) {
        return null;
    }

    @Override
    public ResponseMessage getById(Long id) {
        return null;
    }

    @Override
    public ResponseMessage create(Author author) {
        try {
            List<String> listErrorInUserData = getListErrorInAuthorDataCreate(author);
            if (!listErrorInUserData.isEmpty()) {
                return new ResponseMessage(false, listErrorInUserData);
            }
            authorRepository.create(author);
        } catch (SQLException e) {
            return new ResponseMessage(false, "SQL Exception");
        }
        return new ResponseMessage(true, AuthorMapperUtil.getAuthorCreateDto(author));
    }

    @Override
    public ResponseMessage update(Author entity) {
        return null;
    }

    @Override
    public List<Author> getAll() {
        return null;
    }

    private List<String> getListErrorInAuthorDataCreate(Author author) throws SQLException {
        List<String> error = new ArrayList<>();

        if (FindNullAndEmptyUtil.isAnyNullOrEmpty(author.getArrayFields())) {
            String message = "There are unfilled fields";
            error.add(message);
            return error;
        }

        String name = author.getName();
        String surname = author.getSurname();

        if (!name.matches(ConstantsRegex.NAME_AUTHOR)) {
            error.add("name incorrect");
        }
        if (!surname.matches(ConstantsRegex.NAME_AUTHOR)) {
            error.add("surname incorrect");
        }

        if (!error.isEmpty()) {
            return error;
        }
        if (authorRepository.isAuthor(author)) {
            error.add("This author already exists");
        }

        return error;
    }
}
