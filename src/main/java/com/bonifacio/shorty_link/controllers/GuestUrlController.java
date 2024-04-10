package com.bonifacio.shorty_link.controllers;

import com.bonifacio.shorty_link.dtos.CustomResponse;
import com.bonifacio.shorty_link.dtos.GuestUrlInDto;
import com.bonifacio.shorty_link.services.GuestUrlService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping(value = {""})
@RestController
@AllArgsConstructor
public class GuestUrlController {
    @Autowired
    private  final GuestUrlService guestUrlService;

    @Transactional
    @RequestMapping(method = RequestMethod.POST,value = {"","/"})
    public ResponseEntity<CustomResponse<?>> createSlug(@Valid @RequestBody GuestUrlInDto guestUrlInDto,
                                                        BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(CustomResponse
                    .builder()
                    .message("Error al crear el slug")
                    .success(false)
                    .status(String.valueOf(HttpStatus.BAD_REQUEST))
                    .data(result.getAllErrors())
                    .build(),HttpStatus.BAD_REQUEST);
        }
        var url = guestUrlService.saveGuestUrl(guestUrlInDto);
        if(url==null){
            return new ResponseEntity<>(CustomResponse
                    .builder()
                    .success(false)
                    .message("error al crear el slug")
                    .status(String.valueOf(HttpStatus.BAD_REQUEST))
                    .data(null)
                    .build(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(CustomResponse
                .builder()
                .data(url)
                .status(String.valueOf(HttpStatus.CREATED))
                .message("Slug Creado Correctamente")
                .success(true)
                .build(),HttpStatus.CREATED);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = {"d/{slug}","d/{slug}/"})
    public ResponseEntity<CustomResponse<?>> getPage(@PathVariable String slug, HttpServletResponse response)
    throws IOException {
        var url = guestUrlService.findBySlug(slug);
        if(url==null){
            return new ResponseEntity<>(CustomResponse.builder()
                    .success(false)
                    .status(String.valueOf(HttpStatus.NOT_FOUND))
                    .message("slug no reconocido")
                    .data(null)
                    .build(),HttpStatus.NOT_FOUND);
        }
        response.sendRedirect(url.getLink());
        return null;
    }
}
