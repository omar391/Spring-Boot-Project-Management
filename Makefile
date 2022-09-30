docker:
	@echo "	>>> Running docker-compose"
	@-mvn clean package
	@docker compose  -p sboot-pm-java --verbose up -d --build --force-recreate --remove-orphans
	@echo "	>>> Done"