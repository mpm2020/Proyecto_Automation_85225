# 🧪 Proyecto_Automation_85225

Framework básico de automatización de pruebas web con Java, Maven, TestNG y el patrón Page Object Model (POM).

---

## 🛠 Tecnologías

* **Lenguaje:** Java 17+
* **Gestor de dependencias:** Maven
* **Framework de tests:** TestNG
* **Automatización Web:** Selenium WebDriver

---

## 📁 Estructura del Proyecto

```text
├── src
│   └── test/java/
│       ├── pages/              # Page Objects (elementos y acciones)
│       └── tests/              # Casos de prueba (@Test)
├── testng.xml                  # Suite de ejecución TestNG
└── pom.xml                     # Dependencias del proyecto
```

---

## 🚀 Ejecución de Pruebas

1. **Clonar el proyecto:**
   ```bash
   git clone https://github.com/tu-usuario/tu-repositorio.git
   cd tu-repositorio
   ```

2. **Ejecutar todos los tests:**
   ```bash
   mvn clean test
   ```
