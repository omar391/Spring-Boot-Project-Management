docker:
	@echo "	>>> Running docker-compose"
	@-mvn clean package
	@mkdir -p jar/
	@-cp target/projects-management-spring-boot-api-0.0.1-SNAPSHOT.jar jar
	@docker compose  -p sboot-pm-java --verbose up -d --build --force-recreate --remove-orphans
	@-rm -rf target/
	@java -jar ./jar/projects-management-spring-boot-api-0.0.1-SNAPSHOT.jar
	@echo "	>>> Done"