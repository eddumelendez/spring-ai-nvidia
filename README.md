# Spring AI NVIDIA

Spring AI example tested against NVIDIA NIM container provided by Testcontainers.

1. Create an NVIDIA account and generate `NGC_API_KEY`. Follow the following steps https://docs.nvidia.com/nim/large-language-models/latest/getting-started.html#option-2-from-ngc
2. Run the application

```bash
./mvnw spring-boot:test-run
```

3. Watch NVIDIA container logs

```bash
docker logs -f $(docker ps --format "{{.ID}}" --filter ancestor="nvcr.io/nim/meta/llama3-8b-instruct:1.0.0")
```

4. Perform a request against the Spring app

```bash
http :8080/chat
```