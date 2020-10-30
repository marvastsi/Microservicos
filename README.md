# Microservicos
Arquitetura Microserviços com Spring Cloud Netflix

### Configuração do RabbitMQ
- Após a devida implementação nos microserviços deve-se:
  1. subir a docker do rabbitmq (/compose/rabbitmq)
  2. abrir o rabbitMQ no navegador atraves do endereço e porta configurados [http://localhost:15672](hppt://localhost:15672)
  3. subir os dois microserviços a fim de que sejam criadas as exchanges
  4. criar uma fila (queue) na aba **queues** com o nome utilizado no listener do ProdutoReceiveMessage
  5. fazer o bind, da fila criada no passo **4**, ao exchange do CRUD, utilizando a routingkey (routingkey)
