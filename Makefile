up:
	@docker compose -f ./docker/docker-compose.yml up -d

stop:
	@docker compose -f ./docker/docker-compose.yml stop

down:
	@docker compose -f ./docker/docker-compose.yml down

status:
	@docker compose -f ./docker/docker-compose.yml ps

logs:
	@docker compose logs -f