package com.education.service.address.impl;

import com.education.entity.Author;
import com.education.repository.AuthorRepository;
import com.education.service.address.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Сервис-класс с методами для транзакции с БД
 */

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    /**
     * Сохранение Author
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Author author) {
        authorRepository.saveAndFlush(author);
    }

    /**
     * Удаление Author по id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        authorRepository.deleteById(id);

    }

    /**
     * Поиск Author по id
     */
    @Override
    @Transactional(readOnly = true)
    public Author findById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    /**
     * Поиск Author`s по id`s
     */
    @Override
    @Transactional(readOnly = true)
    public List<Author> findAllById(Iterable<Long> ids) {
        return authorRepository.findAllById(ids);
    }

    /**
     * Список Author`s
     */

    @Override
    @Transactional(readOnly = true)
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
