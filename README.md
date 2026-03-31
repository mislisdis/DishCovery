
# DishCovery – Ingredient-Based Recipe Recommendation System

A lightweight Java-based desktop application that recommends recipes based on available ingredients, designed to reduce food waste and simplify meal planning.



##  Project Summary

DishCovery is an **ingredient-first recipe recommendation system** that shifts the traditional search model (recipe → ingredients) to a more practical approach (ingredients → recipes).

Built as part of an academic project, it demonstrates **full-stack development skills**, including UI design, backend logic, data handling, and user authentication.



## Problem Solved

Many users struggle with:

* Deciding what to cook with limited ingredients
* Food waste due to unused items
* Complex recipe platforms requiring prior knowledge

DishCovery solves this by delivering **fast, relevant recipe suggestions using only what the user has**.


##  Tech Stack

* **Frontend:** JavaFX
* **Backend:** Java
* **Data Storage:** JSON (local dataset)
* **Database:** MySQL (authentication & user data)
* **API Integration:** PHP endpoints (favorites & meal plans)


##  Key Features

* Ingredient-based recipe matching
* Dietary filtering (Vegetarian, Vegan)
* Cook-time and difficulty filtering
* User authentication (login/signup with hashed passwords)
* Favorites system with persistent storage
* Meal planning functionality
* Light/Dark mode UI


## Technical Highlights

* Implemented **rule-based filtering logic** using Java Streams for efficient recipe matching
* Designed a **modular architecture** separating UI, business logic, and data layers
* Integrated **JSON parsing (Jackson)** for local dataset management
* Built a **responsive JavaFX UI** with reusable components
* Developed **session management and authentication system** with secure password hashing
* Created **scalable filtering system** supporting multiple constraints (ingredients, time, diet, difficulty)


##  Architecture Overview

```
JavaFX UI → Filter Engine (Java) → JSON Dataset → Filtered Results → UI Display
```

* Lightweight, offline-first design
* No dependency on external APIs for core functionality
* Optimized for speed and simplicity



##  Impact

* Reduces decision fatigue in meal planning
* Encourages efficient use of available ingredients
* Demonstrates practical application of **data filtering and user-centered design**


## Future Improvements

* AI-based recommendation engine
* Nutritional analysis and health insights
* Mobile (Android) version
* Cloud-based database and scalability



## Author

**Lisa Adisa Magada**



##  Why This Project Matters

This project showcases:

* End-to-end application development
* Strong problem-solving and system design skills
* Ability to build **practical, user-focused software solutions**


