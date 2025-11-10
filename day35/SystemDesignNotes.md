# 🧠 System Design Setup Notes

## Overview
System Design is how we architect large-scale backend systems so that they are:
- Scalable (handle millions of users)
- Reliable (resistant to crashes)
- Maintainable (easy to evolve over time)

---

## 1️⃣ Key Components

### 🧩 Client
Frontend or user app that makes requests to our backend.
- Examples: React app, Android/iOS app

### ⚙️ Backend (Spring Boot)
Handles:
- Routing (`@RestController`)
- Business logic (`@Service`)
- Data access (`@Repository`)

### 🗃️ Database
Stores persistent data (e.g. MySQL, PostgreSQL).
We ensure **indexing, normalization, and ACID compliance**.

### 🚀 Cache (Redis)
Stores frequently used queries to improve speed.
E.g., Caching recent API responses.

### 📬 Message Queue (Kafka/RabbitMQ)
Used for async communication — sending emails, processing uploads, etc.

### 🌐 Load Balancer
Distributes traffic across multiple backend servers to avoid overload.

---

## 2️⃣ Example Flow (API Request Journey)
1. User clicks “Login” on frontend.
2. Request → API Gateway → Backend.
3. Backend checks credentials → fetches from MySQL.
4. If valid, token is cached in Redis.
5. Response sent to client.

---

## 3️⃣ Backend Developer Role
As a backend engineer, you must:
- Design scalable APIs
- Optimize database queries
- Integrate caching + queues
- Understand system bottlenecks

---

## 4️⃣ Next Steps (Day 36)
We'll build a **Mini System Design Project Setup**:
- Spring Boot skeleton
- MySQL + Redis integration
- API + Cache example
