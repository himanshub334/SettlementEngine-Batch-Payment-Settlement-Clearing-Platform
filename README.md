# SettlementEngine — Batch Payment Settlement & Clearing Platform

Java 21, Spring Boot, Spring Batch dependencies, PostgreSQL, Flyway, JPA, OpenAPI, JUnit 5, Testcontainers and GitHub Actions portfolio starter.

## Included
- Configurable interchange rates for domestic, cross-border and premium card tiers.
- Settlement run and report REST APIs backed by PostgreSQL.
- Transaction state updates and unique settlement record constraint to reduce duplicate settlement risk.
- Versioned Flyway schema migrations and demo data.
- Docker Compose environment, OpenAPI UI, CI workflow and JaCoCo configuration.

## Run
Requires Docker and Java 21/Maven if running outside Docker.

```bash
docker compose up --build
```

App: http://localhost:8080
Swagger UI: http://localhost:8080/swagger-ui.html
Health: http://localhost:8080/api/health

Try:
```bash
curl -X POST 'http://localhost:8080/api/settlements/run?date=2025-01-01'
curl 'http://localhost:8080/api/settlements/report?date=2025-01-01'
```
Use yesterday's date for the seeded demo transactions.

## Endpoints
- `POST /api/settlements/run?date=YYYY-MM-DD`
- `POST /api/batch/trigger?date=YYYY-MM-DD`
- `GET /api/batch/status`
- `GET /api/settlements/status`
- `GET /api/settlements/report?date=YYYY-MM-DD`
- `GET /api/transactions`
- `GET /api/exceptions`
- `GET /api/health`

## Honest implementation scope
This is a starter project, not a certified payment processor and not affiliated with Mastercard. Although Spring Batch is included as a dependency, the current settlement operation is implemented as a transactional service invoked by REST, not a full chunk-oriented `ItemReader`/`ItemProcessor`/`ItemWriter` job. Audit and exception tables are schema foundations and are not fully wired into the service yet. Cucumber/Testcontainers dependencies are included but no executable BDD or PostgreSQL container suite is wired. Do not claim 88% coverage, zero SonarQube issues, or performance benchmarks until measured locally.

## Tests
```bash
mvn test
mvn verify
```
Review build/test results before publishing or listing measured claims on a resume.
