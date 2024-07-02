# Highway Ticket Management System

## ITS 1018 – Software Architectures & Design Patterns II

### Graduate Diploma in Software Engineering

### Final Examination

---

### Total Marks: 100

### Assignment:

**Highway Ticket Management System Microservice Application**

---

## Business Scenario

In today's dynamic transportation landscape, managing highway tickets efficiently is crucial for ensuring smooth traffic flow and compliance with regulations. Our objective is to develop a robust microservice-based backend application for a Highway Ticket Management System. This system will streamline the handling of ticket issuance, vehicle registration, user management, and payment processing without relying on external payment gateways.

By leveraging Spring Boot and Spring Cloud technologies, including Eureka for service discovery, a Configuration Server for centralized configuration management, and a Spring Cloud Gateway for intelligent routing, the application will ensure scalability, resilience, and seamless integration of services. Through comprehensive testing using Postman, we aim to validate the functionality and reliability of each microservice, ensuring they meet stringent business requirements and provide a seamless user experience.

## Requirements

The assignment requires the implementation of several key components:

- **Service Registry and Discovery**: Utilizing Eureka for dynamic service registration and discovery.
- **Configuration Server**: Implementing a Spring Cloud Config Server for centralized configuration management.
- **API Gateway**: Utilizing Spring Cloud Gateway for efficient routing of client requests to appropriate microservices.
- **Microservices**: Developing individual services including Ticket Service, Vehicle Service, User Service, and Payment Service, each with specific functionalities tailored to the management of ticket data, vehicle information, user profiles, and internal payment transactions.

## Steps and Business Logic Explanation

### Service Registry and Discovery (Eureka):

- **Purpose**: Eureka enables microservices to register themselves and discover other services dynamically.
- **Implementation**: Each microservice registers with Eureka upon startup, facilitating communication without hardcoded dependencies.

### Configuration Server (Spring Cloud Config):

- **Purpose**: Centralize configuration management.
- **Implementation**: Microservices fetch configurations from the Config Server, allowing updates without redeployment.

### API Gateway (Spring Cloud Gateway):

- **Purpose**: Serve as a single-entry point for client requests.
- **Implementation**: Routes requests to appropriate microservices based on URI and HTTP method, leveraging Eureka for dynamic service discovery.

### Microservices:

#### Ticket Service:

- **Business Logic**: Manages ticket lifecycle.
- **Functions**: Creation, status updates, and retrieval of ticket information.

#### Vehicle Service:

- **Business Logic**: Handles vehicle operations.
- **Functions**: Registration, updates, and retrieval of vehicle details.

#### User Service:

- **Business Logic**: Manages user and owner information.
- **Functions**: Registration, profile updates, and credential verification.

#### Payment Service:

- **Business Logic**: Facilitates secure payment processing internally.
- **Functions**: Validate payment details, update ticket statuses upon successful payment confirmation.

## Testing Approach

- Use Postman to test all API endpoints.
- Focus exclusively on backend functionality, excluding user interface development.
- Ensure functionality and correctness across microservices.
- Validate error handling and edge cases.

## Submission Guidelines

### GitHub Repository:

1. Push your project to a GitHub repository.
2. Include a Postman collection JSON file in the main directory of your repository. This collection should contain all API endpoints with detailed requests and responses.

---

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher
- Postman (for testing the APIs)

### Setup and Run

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/highway-ticket-management-system.git
   cd highway-ticket-management-system
