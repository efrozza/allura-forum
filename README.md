**Curso Alura sobre Spring Boot**

**Controller**

@RestController - indica ao SB que é um controler Rest

@RequestMapping("/topicos") - url que esse Controller mapeia (localmente seria - localhost:8080/topicos)

@Autowired - Injeção de dependência

@GetMapping - Mapeia método (usando GET)

-- Tratamento de um método Post
@PostMapping - Mapeia método (usando POST)

@RequestBody - Indica que o valor da requisição vem no corpo

@Valid - Indica ao spring que devem ser feitas as validações anotadas via BeanValidation

TopicoForm - Objeto recebido na requisição

Validações feitas com Bean Validation na classe TopicoForm ------------**

  @NotNull
  
  @NotEmpty
  
  @Length(min = 5, max = 100)
  
  private String titulo;
------------------------------------------------------------------------**

