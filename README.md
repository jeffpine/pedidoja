# pedidoja
📦 **Sistema de Pedidos com Spring Boot, Kafka e MySQL**
## 📋 Visão Geral
Sistema de processamento de pedidos com:
- API REST em Spring Boot (Java 21)
- Comunicação assíncrona via Apache Kafka
- Armazenamento persistente em MySQL 8
- Containerização com Docker

## 🚀 Funcionalidades Principais
✔️ Criação de pedidos via API REST  
✔️ Validação de dados de entrada  
✔️ Processamento assíncrono com Kafka  
✔️ Persistência em banco de dados relacional  
✔️ Configuração pronta para Docker

## 🛠 Tecnologias Utilizadas
- **Backend**: Spring Boot 3.2 + JDK 21
- **Banco de Dados**: MySQL 8
- **Mensageria**: Apache Kafka
- **Containerização**: Docker + Docker Compose
- **Ferramentas**: Postman (testes), Maven (build)

## ⚙️ Pré-requisitos
- Docker 23.0+
- Docker Compose 2.20+
- JDK 21
- Maven 3.9+

## 🏗️ Como Executar o Projeto
1. Clone o repositório
```
git clone https://github.com/jeffpine/pedidoja
cd pedidoja
```
2. Inicie os containers
```
docker-compose up -d
```
3. Execute a aplicação Spring Boot
```
mvn spring-boot:run
```
4. Acesse a API  
URL Base: <u>http://localhost:8080/api/v1/orders</u>  
Porta do MySQL: 3306  
Porta do Kafka: 9092

## 📡 Endpoints da API  
<u>POST /orders</u>  
Cria um novo pedido

**Request**:
```
{
  "productName": "Notebook Dell",
  "quantity": 1,
  "productCode": "NB-1234"
}
```
**Response (Sucesso - 201 Created)**:
```
{
  "orderId": 1,
  "productName": "Notebook Dell",
  "quantity": 1,
  "status": "PROCESSING",
  "createdAt": "2025-04-20T10:15:30"
}
```
## 🧪 Testando o Sistema
**Via Postman**  
1.Importe a coleção do Postman (disponível em docs/postman_collection.json)  
2.Execute o request <u>Create Order</u>

**Via cURL**
```
curl -X POST http://localhost:8080/api/v1/orders \
  -H "Content-Type: application/json" \
  -d '{"productName":"Teclado Mecânico","quantity":2,"productCode":"KB-5678"}'
```
##🐛 Solução de Problemas
**Erro de conexão com MySQL**
```
docker-compose down -v
docker-compose up -d
```
**Verificar logs do Kafka**
```
docker-compose logs -f kafka
```
**Acessar banco de dados**
```
docker exec -it sistema-pedidos-mysql-1 mysql -u user -p order_db
```
## 📈 Próximas Melhorias

- Implementar autenticação JWT
- Adicionar documentação Swagger
- Criar dashboard de monitoramento
- Implementar fila de dead-letter no Kafka

## 📝 Licença
Este projeto está licenciado sob a MIT License - veja o arquivo [LICENSE](https://github.com/jeffpine/pedidoja/blob/main/LICENSE) para detalhes.

Desenvolvido por Jeferson Pinheiro
📧 [Email](iservice.pinheiro@gmail.com)
🔗 [LinkedIn](https://www.linkedin.com/in/eijeffpinheiro/)
💻 [GitHub](https://github.com/jeffpine)
