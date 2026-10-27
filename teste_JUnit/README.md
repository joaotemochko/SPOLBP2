# SPOLBP2 – Testes com JUnit 5 e Mockito

Projeto Spring Boot 3.5 + Maven (Java 17+) com todos os testes mostrados na aula.

## Rodar

    mvn test                      # roda todos os testes
    mvn test -Dtest=CalculadoraTest   # roda uma classe
    mvn spring-boot:run           # sobe a aplicação (GET /usuarios/{id})

Relatórios: `target/surefire-reports/` e, após `mvn test`, cobertura JaCoCo em `target/site/jacoco/index.html`.

## Testes

| Classe | Conteúdo |
|---|---|
| `CalculadoraTest` | AAA, `@BeforeEach`, `@DisplayName`, `assertThrows`, `@CsvSource` |
| `ValidadorTest` | `@ValueSource`, casos de borda, exceção |
| `UsuarioTest` | `assertAll` |
| `UsuarioServiceTest` | Mockito: `@Mock`, `@InjectMocks`, `when`, `verify` |
| `UsuarioControllerTest` | `@WebMvcTest`, `MockMvc`, `@MockitoBean` |
| `UsuarioRepositoryTest` | `@DataJpaTest` (H2 em memória) |
| `ProjetoApplicationTests` | `@SpringBootTest` |

Nota: no Spring Boot 4, `@WebMvcTest` e `@DataJpaTest` mudam de pacote e exigem os starters
`spring-boot-starter-webmvc-test` / `spring-boot-starter-data-jpa-test`.
