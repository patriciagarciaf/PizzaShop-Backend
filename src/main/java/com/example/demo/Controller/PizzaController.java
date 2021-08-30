package com.example.demo.Controller;

import com.example.demo.Application.CommentApplication.CommentDTO;
import com.example.demo.Application.CommentApplication.CreateDTOComment;
import com.example.demo.Application.ImageApplication.ImageDTO;
import com.example.demo.Application.PizzaApplication.CreateOrUpdatePizzaDTO;
import com.example.demo.Application.PizzaApplication.PizzaApplication;
import com.example.demo.Application.PizzaApplication.PizzaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/v1/pizzas")
public class PizzaController {
    private final PizzaApplication pizzaApplication;

    @Autowired
    public PizzaController(final PizzaApplication pizzaApplication) {
        this.pizzaApplication = pizzaApplication;

    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@Valid @RequestBody final CreateOrUpdatePizzaDTO dto) {
        PizzaDTO pizzaDTO = this.pizzaApplication.add(dto);
        return ResponseEntity.status(201).body(pizzaDTO);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/{id}/comments")
    public ResponseEntity<?> addComment(@PathVariable UUID id, @RequestBody CreateDTOComment createCommentDTO) {
        CommentDTO commentDTO = this.pizzaApplication.addComment(id, createCommentDTO);
        return ResponseEntity.status(201).body(commentDTO);
    }

    // @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    // public ResponseEntity<?> get(@PathVariable UUID id) {
    //     PizzaDTO pizzadto = this.pizzaApplication.get(id);
    //     return ResponseEntity.ok(pizzadto);
    // }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        this.pizzaApplication.delete(id);
        return ResponseEntity.status(204).body("");
    }

    @DeleteMapping(path = "/{id}/ingredients/")
    public ResponseEntity<?> removeIngredient(@PathVariable UUID id, UUID ingredientId) {
        this.pizzaApplication.removeIngredient(id, ingredientId);
        return ResponseEntity.status(204).body("");
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return ResponseEntity.status(200).body(this.pizzaApplication.getAll(name, page, size));
    }

    //@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    //public ResponseEntity<?> getPizzaInfo(
    //        @PathVariable UUID id
    //){
    //    return ResponseEntity.status(200).body(this.pizzaApplication.getPizzaInfo(id));
    //}

    //@PostMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    //public ResponseEntity<?> create(@PathVariable("id") UUID id) throws JsonProcessingException, IOException, InterruptedException {
    //    ImageDTO dto = new ImageDTO(id);
    //    ObjectMapper mapper = new ObjectMapper();
    //    String json = mapper.writeValueAsString(dto);
    //    HttpRequest request = HttpRequest
    //            .newBuilder()
    //            .uri(URI.create("http://localhost:8080/save"))
    //            .header("Content-Type", "application/json")
    //            .POST(HttpRequest.BodyPublishers.ofString(json))
    //            .build();
//
    //    HttpClient httpClient = HttpClient
    //            .newBuilder()
    //            .version(HttpClient.Version.HTTP_1_1)
    //            .build();
//
    //    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    //    return ResponseEntity.status(201).body(response.body());
    }

