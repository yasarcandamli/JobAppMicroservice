# Job App

## Introduction

Welcome to the **Master Spring Boot Microservices with Kubernetes & Docker** course project! This project is designed to help Java developers transition from monolithic applications to microservices architecture using **Spring Boot, Kubernetes, and Docker**. Throughout the course, we build real-world microservices, containerize them, and deploy them on Kubernetes.

## Technologies Used

- **Java**
- **Spring Boot**
- **Spring Cloud Gateway**
- **Spring Cloud Config Server**
- **Spring Boot Actuator**
- **Spring Data JPA**
- **PostgreSQL**
- **Docker & Docker Compose**
- **Kubernetes**
- **RabbitMQ**
- **Eureka Service Registry**
- **OpenFeign**
- **Zipkin & Micrometer**
- **Resilience4J**

## Project Overview

This project involves building a **job listing platform** where users can:

- **Manage job listings** (create, update, delete jobs)
- **Manage companies** (create, update, delete companies)
- **Manage reviews** (add, update, delete reviews for companies)
- **Enable inter-service communication**
- **Deploy services using Docker and Kubernetes**

## Project Structure

The application consists of multiple microservices:

1. **Job Service** - Handles job postings.
2. **Company Service** - Manages company details.
3. **Review Service** - Allows users to review companies.
4. **API Gateway** - Central entry point for all microservices.
5. **Service Registry** - Uses Eureka for service discovery.
6. **Config Server** - Centralized configuration management.
7. **RabbitMQ Message Queue** - Implements asynchronous communication.
8. **Monitoring & Tracing** - Uses Zipkin and Micrometer for distributed tracing.

## Key Features Implemented

### 1. **Spring Boot Development**

- Built REST APIs for managing **jobs, companies, and reviews**.
- Implemented **CRUD operations** with **Spring Data JPA**.
- Used **H2 and PostgreSQL** for database management.

### 2. **Containerization with Docker**

- Containerized each microservice using **Docker**.
- Created multi-container environments using **Docker Compose**.

### 3. **Microservices Communication**

- Implemented **synchronous communication** using **RestTemplate**.
- Used **OpenFeign** for simplified service-to-service communication.

### 4. **Service Discovery & API Gateway**

- Registered microservices with **Eureka Service Registry**.
- Implemented **Spring Cloud Gateway** for routing requests.

### 5. **Configuration Management**

- Managed configurations centrally using **Spring Cloud Config Server**.
- Stored configurations in a **Git repository**.

### 6. **Resilience & Fault Tolerance**

- Integrated **Resilience4J** for:
  - Circuit Breaking
  - Retry Mechanisms
  - Rate Limiting

### 7. **Distributed Tracing & Monitoring**

- Implemented **Spring Boot Actuator** for application insights.
- Integrated **Zipkin** and **Micrometer** for tracing requests across microservices.

### 8. **Asynchronous Communication with RabbitMQ**

- Used **RabbitMQ** as a message broker for handling asynchronous events.
- Updated company ratings based on received messages.

### 9. **Deployment on Kubernetes**

- Deployed all microservices to **Kubernetes** using **Minikube**.
- Created **Kubernetes manifests** for services, deployments, and replicas.
- Configured PostgreSQL, RabbitMQ, and Zipkin on Kubernetes.

## Installation & Setup

### Prerequisites

Ensure you have the following installed:

- Java 17+
- IntelliJ IDEA / VS Code
- Docker & Docker Compose
- Kubernetes (Minikube or K8s)
- PostgreSQL
- RabbitMQ

### Steps to Run

1. **Clone the Repository**
   ```sh
   git clone https://github.com/yasarcandamli/JobAppMicroservice
   cd JobAppMicroservice
   ```
2. **Running with Docker**
   ```sh
   docker-compose up -d
   ```
3. **Access Services**
   - **Eureka Dashboard**: `http://localhost:8761`
   - **API Gateway**: `http://localhost:8084`
   - **Job Service**: `http://localhost:8081`
   - **Company Service**: `http://localhost:8082`
   - **Review Service**: `http://localhost:8083`
   - **Zipkin Service**: `http://localhost:9411`
   - **RabbitMQ Service**: `http://localhost:15672` (username: guest || password: guest)

### Deploying to Kubernetes

```sh
kubectl apply -f k8s/
```

## API Endpoints

API Endpoints are included in **`Microservice Spring Boot Copy.postman_collection.json`**, you can import them into **Postman**.

### Job Service

| Method | Endpoint     | Description   |
| ------ | ------------ | ------------- |
| GET    | `/jobs`      | Get all jobs  |
| GET    | `/jobs/{id}` | Get job by ID |
| POST   | `/jobs`      | Create a job  |
| PUT    | `/jobs/{id}` | Update a job  |
| DELETE | `/jobs/{id}` | Delete a job  |

### Company Service

| Method | Endpoint          | Description       |
| ------ | ----------------- | ----------------- |
| GET    | `/companies`      | Get all companies |
| GET    | `/companies/{id}` | Get company by ID |
| POST   | `/companies`      | Create a company  |
| PUT    | `/companies/{id}` | Update a company  |
| DELETE | `/companies/{id}` | Delete a company  |

### Review Service

| Method | Endpoint                         | Description                   |
| ------ | -------------------------------- | ----------------------------- |
| GET    | `/reviews?companyId={companyId}` | Get all reviews for a company |
| POST   | `/reviews/{reviewId}`            | Add a review                  |
| GET    | `/reviews/{reviewId}`            | Get a review by ID            |
| PUT    | `/reviews/{reviewId}`            | Update a review               |
| DELETE | `/reviews/{reviewId}`            | Delete a review               |

## Conclusion

This project demonstrates how to build **scalable, resilient, and production-ready microservices** using **Spring Boot, Docker, and Kubernetes**.
