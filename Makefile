drun:
	@echo "	>>> Running docker-compose"
	@docker compose  -p sboot-pm-java --verbose up -d --build --force-recreate --remove-orphans
	@echo "	>>> Done"