package br.com.zupedu.casadocodigo.validacao;

import br.com.zupedu.casadocodigo.dto.CategoriaRequest;
import br.com.zupedu.casadocodigo.dto.NovoAutorRequest;
import br.com.zupedu.casadocodigo.modelo.Autor;
import br.com.zupedu.casadocodigo.modelo.Categoria;
import br.com.zupedu.casadocodigo.repositories.AutorRepository;
import br.com.zupedu.casadocodigo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ValidarCategoriaValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {

        return CategoriaRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        CategoriaRequest request = (CategoriaRequest) target;

        Optional<Categoria> possivelAutor = categoriaRepository.findByNome(request.getNome());

        if (possivelAutor.isPresent()) {
            errors.rejectValue("nome", null,
                    "Já existe uma categoria com o mesmo nome "
                            + request.getNome());
        }
    }

}
