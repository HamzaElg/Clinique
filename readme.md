# Clinic Management System (Java - OOP Project)
##  Project Overview :
This project is a simple Clinic Management System developed in Java, designed to demonstrate & practice strong mastery of Object-Oriented Programming (OOP) concepts such as:
- Inheritance.
- Polymorphism.
- Encapsulation.
- Abstraction.
- Interfaces.
- Collections.
- Separation of responsibilities (Architecture).

The system simulates how a clinic manages **patients**, **doctors**, **appointments**, and **medical records**, while enforcing real-world business rules.

## Objectives :
- Model a real-world clinic using OOP principles.
- Apply clean architecture and separation of concerns.
- Handle business constraints through a central system class.
- Prepare a scalable base for future features (JDBC, GUI, persistence).

## Project Architecture :
src/

 ├── app/
 │    └── Main.java                 _→ Application entry point (CLI)_
 │
 ├── model/
 │    ├── Person.java              _ → Abstract base class_
 │    ├── Patient.java             _ → Inherits Person_
 │    ├── Doctor.java              _ → Inherits Person_
 │    ├── Appointment.java         _ → Relationship entity_
 │    ├── MedicalRecord.java        _→ Exists only inside Appointment_
 │
 ├── system/
 │    └── ClinicSystem.java        _ → Core business logic & rules engine_

# Core Design Principles :
## 1: Separation of Concerns :
- **Models** represent data and behavior.
- **ClinicSystem** controls business logic and rules.
- **Main** handles user interaction (CLI).
No class does more than it should.

## 2: Centralized Business Logic :
All rules are enforced inside ClinicSystem:
- No duplicate IDs.
- Appointment validation.
- Doctor availability.
- Weekly scheduling.
- Data consistency.
The UI **never manipulates data directly**.
undation-ready system.

