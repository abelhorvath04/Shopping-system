# Online Shopping System

An intuitive and extensible **online shopping system** that allows users to browse products, manage a shopping cart, and complete the checkout process with flexible shipping options. The system is built with **clean architecture**, leveraging **OOP principles** and **design patterns** to ensure scalability and maintainability.

This project was developed as part of a **university coursework**, demonstrating strong **software design principles**. A **UML diagram** is included to illustrate the system's architecture and relationships between components.

## Key Features

### Product Management
- Supports multiple **product categories**:
    - **Electronics** (Smartphones, Laptops)
    - **Clothing** (Shirts, Pants)
    - **Books** (Novels, Textbooks)
- Uses an **elegant class hierarchy** for structured product representation.

### Shopping Cart
- Users can **add, remove, and view** products in their cart.
- Built for **efficiency and ease of use**.

### Smart Shipping Options (Strategy Pattern)
- **Standard Shipping**: Fixed-rate shipping.
- **Express Shipping**: Faster delivery at a premium rate.
- **Free Shipping**: Available for qualifying orders.

### User Management
- Each user has a **profile** with **name, email, and shipping address**.
- Supports **profile updates** for a seamless shopping experience.

### Product Factory (Factory Pattern)
- Dynamically creates product instances **based on user input**.
- Ensures **consistent product instantiation** across the system.

### Singleton Shopping System
- **Centralized management** ensures that only one instance of the system runs.
- Prevents **redundant data duplication** and enhances performance.

### Reliable & Tested
- **Unit tests** for core functionalities:
    - Shopping cart operations
    - Product factory behavior

### UML Diagram
A **detailed UML diagram** is provided to visualize the system architecture, class relationships, and design patterns used.
