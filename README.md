# 🔐 JavaFX Employee Login System

![Language](https://img.shields.io/badge/Project-Java-blue?style=for-the-badge&logo=java)
![Status](https://img.shields.io/badge/Status-Prototype-orange?style=for-the-badge)
![Type](https://img.shields.io/badge/Type-Desktop%20App-lightgrey?style=for-the-badge)
![Focus](https://img.shields.io/badge/Focus-Authentication%20Management-orange?style=for-the-badge)

---

## 📦 Overview

This is a prototype JavaFX desktop application that demonstrates a basic **employee login system** with scene switching and database interaction. It uses FXML for UI layout and modular controller classes for logic separation.

---

## 🚀 Features

- 🔐 **Login Authentication**  
  Validates employee credentials against a database using `DBUtils.logInEmp()`

- 🔄 **Scene Switching**  
  Dynamically loads FXML files and switches views using `DBUtils.changeScene()`

- 👤 **Welcome Screen**  
  Displays personalized greeting after successful login

- 🧩 **Modular Architecture**  
  Separates logic into `Main`, `Controller`, `DBUtils`, and `LoggedInController`

---

## 🧠 How It Works

1. **Main.java** loads `sample.fxml` and starts the app
2. **Controller.java** listens for login button clicks and calls `DBUtils.logInEmp()`
3. **DBUtils.java** connects to the database, verifies credentials, and switches scenes
4. **LoggedInController.java** receives the employee ID and displays a welcome message

---

## ⚠️ Notes

- Database connection string in `DBUtils.java` is currently empty (`DriverManager.getConnection("")`) — update it with your DB credentials
- SQL query in `logInEmp()` is incomplete — you’ll need to finish the `WHERE` clause and parameter binding
- FXML files (`sample.fxml`, `logged-in.fxml`) must be placed correctly in the `resources` folder

---

## 📌 Future Improvements

- Add input validation and error handling
- Secure password storage (e.g., hashing)
- Expand to include employee roles and permissions
- Refactor hardcoded strings and paths

---

## 🛠️ Requirements

- Java 8+
- JavaFX SDK
- IDE like IntelliJ IDEA or VS Code
- JDBC-compatible database (e.g., MySQL, SQLite)

---

### 📁 `File Overview`
```
📦 Employee_Login_System/
 ┣ 📄 pom.xml  
 ┣ 📄 mvnw  
 ┣ 📄 mvnw.cmd  
 ┣ 📄 .gitignore  
 ┣ 📁 .idea/ (ignored)  
 ┣ 📁 .mvn/wrapper/  
 ┣ 📁 lib/  
 ┣ 📁 target/ (ignored)  
 ┗ 📁 src/  
   ┗ 📁 main/  
     ┣ 📁 java/  
     ┃ ┗ 📁 com/  
     ┃   ┗ 📁 example/  
     ┃     ┣ 📄 Main.java  
     ┃     ┣ 📄 Controller.java  
     ┃     ┣ 📄 DBUtils.java  
     ┃     ┗ 📄 LoggedInController.java  
     ┗ 📁 resources/  
       ┗ 📁 com/  
         ┗ 📁 example/  
           ┣ 📄 sample.fxml  
           ┗ 📄 logged-in.fxml  
```
