# Microservicos
Arquitetura Microserviços com Spring Cloud Netflix

### Docker Mysql e RabbitMQ
- A base de dados está configurada em uma docker no path: _/compose/mysql_
- O RabbitMQ está configurado em uma docker no path: _/compose/rabbitmq_
- Para Subir as dockers basta acessar o diretório específico de cada uma e utilizar o comando `docker-compose up`.Adicionalmente pode-se usar o parametro **-d** para liberar o terminal. (dependendo da instalação pode ser necessário utilizar o _sudo_)

### Configuração do RabbitMQ
* Após a devida implementação nos microserviços deve-se:
1. subir a docker do rabbitmq (/compose/rabbitmq)
2. abrir o rabbitMQ no navegador atraves do endereço e porta configurados [http://localhost:15672](http://localhost:15672)
3. subir os dois microserviços a fim de que sejam criadas as exchanges
4. criar uma fila (queue) na aba **queues** com o nome utilizado no listener do ProdutoReceiveMessage
5. fazer o bind, da fila criada no passo **4**, ao exchange do CRUD, utilizando a routingkey (routingkey)

### Acessar Eureka via browser:
* Para acessar o Eureka via browser basta acessar a url [http://localhost:8761/registry](http://localhost:8761/registry/)


> **Nota** O código usa notações do java 10+ como: `var`

