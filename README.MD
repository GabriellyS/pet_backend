## Pet project Backend

This repository servers as the backend to the untitled pet project. It is built using Java 25 and Spring Boot 4, providing a RESTful API for managing pet-related data.

This backend is pretty simple, basically will serve as the CRUD for Pets and their Owners.


Here's the entities we have:

    User:
    - id (Long)
    - username (String)
    - password (String)
    - email (String)
    - firstName (String)
    - lastName (String)
    - phone (String)
    - address (String)
    - roles (Set<Role>)
    - pets (List<Pet>)

    Pet:
    - id (Long)
    - name (String)
    - type (String)
    - breed (String)
    - age (Integer)
    - owner (User)

    Appointment:
    - id (Long)
    - pet (Pet)
    - date (LocalDateTime)
    - reason (String)
    - notes (String)
    - status (String)
    - veterinarian (User)

    Role:
    - id (Long)
    - name (String)