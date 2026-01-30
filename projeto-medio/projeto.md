## 🎯 **Objetivo do Projeto**
Criar um sistema distribuído que simule o fluxo de **solicitação e processamento de crédito pessoal**.  
O Kafka será o *backbone* da comunicação entre microsserviços.  
O MongoDB e o Postgres serão usados para persistência de dados diferentes (transacionais e analíticos).

---

## 🧩 **Arquitetura Geral**

### **Microsserviços principais**
1. **credit-request-service**  
   - Responsável por receber solicitações de crédito dos clientes.  
   - Persiste dados básicos no **PostgreSQL**.  
   - Envia um evento para o tópico Kafka `credit.requested`.

2. **credit-analysis-service**  
   - Consome eventos `credit.requested`.  
   - Realiza análise de crédito (simulada com regras simples).  
   - Persiste resultado da análise no **MongoDB** (documentos de histórico).  
   - Publica um evento `credit.analyzed`.

3. **credit-approval-service**  
   - Consome o evento `credit.analyzed`.  
   - Decide aprovação ou recusa, envia notificação (simulada, via log).  
   - Atualiza o status da solicitação no Postgres.

4. **credit-dashboard-service (opcional)**  
   - Interface (REST ou Web) para visualizar o pipeline e status das solicitações.  
   - Pode ler dados tanto do Postgres quanto do MongoDB.

---

## ⚙️ **Tecnologias e Ferramentas**

| Componente | Tecnologia | Função |
|-------------|-------------|--------|
| Linguagem backend | **Java 17+** | Desenvolvimento principal |
| Framework | **Spring Boot 3+** | Base dos microsserviços |
| Mensageria | **Apache Kafka** | Comunicação assíncrona |
| Banco relacional | **PostgreSQL** | Dados de solicitação e status |
| Banco NoSQL | **MongoDB** | Histórico e auditoria |
| Infra | **Docker / Docker Compose** | Ambiente local |
| Orquestração (opcional) | **Kubernetes / Minikube** | Deploy distribuído |
| Documentação | **Swagger / OpenAPI** | Endpoints REST |
| Monitoramento | **Spring Actuator + Prometheus/Grafana** | Métricas |

---

## 🔄 **Fluxo de Dados**

```
Cliente -> credit-request-service -> Kafka(topic: credit.requested)
        -> credit-analysis-service -> MongoDB(report)
        -> Kafka(topic: credit.analyzed)
        -> credit-approval-service -> PostgreSQL(status atualizado)
        -> credit-dashboard-service -> exibe dados consolidados
```

---

## 📚 **Etapas de Estudo e Implementação**

### **Fase 1 — Fundamentos**
- Revisar conceitos de Kafka (producer, consumer, topics, partitions).
- Configurar ambiente local com Docker Compose:
  - Kafka + ZooKeeper
  - PostgreSQL
  - MongoDB
- Criar um projeto Spring Boot básico com conexão a Postgres e Mongo.

### **Fase 2 — Produção e Consumo de Mensagens**
- Criar `credit-request-service` com endpoint REST (`/credits`) que:
  - Recebe dados do cliente;
  - Persiste em Postgres;
  - Envia um evento para Kafka (`credit.requested`).
- Criar `credit-analysis-service` que consome esse tópico:
  - Simula análise (exemplo: score aleatório);
  - Persiste resultado no Mongo;
  - Publica novo evento (`credit.analyzed`).

### **Fase 3 — Encadeamento e Persistência**
- Criar `credit-approval-service` que:
  - Consome o tópico `credit.analyzed`;
  - Define status “Aprovado”/“Negado” baseado em score;
  - Atualiza a solicitação no Postgres.
- Implementar logs e métricas via Actuator.

### **Fase 4 — Consolidação e Visualização**
- Criar pequeno dashboard (REST ou Web com Thymeleaf ou React).
- Expor endpoints `/status` e `/history` que leem do Postgres e Mongo.
- Adicionar documentação com **Swagger**.

### **Fase 5 — Aprimoramentos**
- Garantir idempotência e uso de **Kafka consumer groups**.
- Introduzir uso de **avro** ou **JSON Schema Registry** para eventos.
- Simular cenários de falha (reprocessamento, compensação).
- Testes de carga e observabilidade.

---

## 🧠 **Conceitos-Chave para Explorar**
- Event-driven architectures
- Garantias de entrega (at-least-once, exactly-once)
- Outbox pattern para bancos relacionais
- Compatibilidade de schema no Kafka
- Spring Kafka (Listener Containers, Error Handling)
- Diferença entre persistência transacional (PostgreSQL) e documental (MongoDB)

---

## 📈 **Resultados Esperados**
Ao final, você deverá:
✅ Entender como conectar microsserviços via Kafka  
✅ Saber integrar Spring Boot com MongoDB e Postgres  
✅ Ter uma visão clara da arquitetura orientada a eventos  
✅ Ter um protótipo funcional simulando fluxo bancário de crédito  

---

Se quiser, posso detalhar os **passos de configuração do ambiente Docker Compose** e o **setup inicial dos tópicos Kafka e conexões Spring Boot**, para você começar a codar imediatamente. Deseja que eu monte esse guia técnico detalhado da configuração inicial?
