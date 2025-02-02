# Indice
1. [Roles](#roles)
2. [Análisis del proyecto](#análisis-del-proyecto)
	- [Tabla de análisis](#tabla-de-análisis)
3. [Propuesta de mejora](#propuesta-de-mejora)
	- [Tabla de propuestas](#tabla-de-propuestas)
4. [Implementación](#implementación)
	- **CHECKSTYLE**
		- [Análisis de cobertura](#análisis-de-cobertura-de-checkstyle)
		- [Descripción de cobertura](#descripción-de-los-datos-de-cobertura-checkstyle)
		- [Resumen de la cobertura](#resumen-del-análisis-checkstyle)
		- [Acciones a tomar para la cobertura](#acciones-a-tomar-para-mejorar-la-cobertura-checkstyle)
	- **JACOCO**
		- [Análisis de cobertura](#análisis-de-cobertura-de-código-con-jacoco)
		- [Descripción de cobertura](#descripción-de-los-datos-de-cobertura-jacoco)
		- [Resumen de la cobertura](#resumen-del-análisis-jacoco)
		- [Acciones a tomar para la cobertura](#acciones-a-tomar-para-mejorar-la-cobertura-jacoco)
	- **SPOTBUGS**
		- [Análisis de cobertura](#análisis-de-cobertura-de-código-con-spotbugs)

---

# Trabajo de proyecto integrador (Realizar):

## Roles
1. Asignación de roles
	* Líder del equipo
	* Responsable de análisis de métricas
	* Responsable de revision manual
	* Responsable de análisis estático

| Cargo | Nombre de la persona |
|------|---------------|
| Líder | Jossue Játiva |
| Responsable de análisis de métricas | Anthony Cochea |
| Responsable de revision manual | Jossue Játiva |
| Responsable de análisis estática | Matias Cedeño |

## Análisis del proyecto
2. Análisis del proyecto
	* Partir por un proyecto de Java (Proporciona la plantilla básica)
	* Realizar:
		- Revision inicial del código
		- Identificando problemas como:
			- Falta de legibilidad
			- Cohesión
			- Errores de estilo
			- Métricas no cumplidas

### Tabla de análisis
| Identificación de problema | Código Antiguo |
| --------| ----------------- |
| Tipo de lista no especifica | ```private List students = new ArrayList<>();``` |
|  | ```private List grades = new ArrayList<>();``` |
| Nombres no declaran objeto | ```private List students = new ArrayList<>();``` |
|  | ```private List<Double> grades = new ArrayList<>();``` |
| Nombres no son expresivos | ```public void addStudent(String s, double g)``` |
| Nombre de la instancia con falta de legibilidad | ```StudentManager sm = new StudentManager();``` |
| Todas las responsabilidades están en StudentManager.java | [StudentManager.java](src/main/java/StudentManager.java) |

## Propuesta de mejora
3. Propuesta de mejora
    * Problemas identificados
    * Técnicas de calidad a implementar (SOLID, Clean Code, Análisis estático)
    * Métricas para evaluar la calidad (Cobertura de código y cumplimiento de estilos)

### Tabla de propuestas
| Problema identificado | Técnica de calidad a implementar | Métrica para evaluar la calidad | Código nuevo |
| --------| ----------------- | ----------- | ----------- |
| No se especifica el tipo de lista | Clean Code | Cobertura de código y cumplimiento de estilos | ```private List<String> students = new ArrayList<>();``` |
|  | Clean Code | Cobertura de código y cumplimiento de estilos | ```private List<Double> grades = new ArrayList<>();``` |
| No se identifica que tipo de objeto es | Clean Code | Cobertura de código y cumplimiento de estilos | ```private List<Double> listStudents = new ArrayList<>();``` |
|  | Clean Code | Cobertura de código y cumplimiento de estilos | ```private List<Double> listGrades = new ArrayList<>();``` |
| Cambiar variables de addStudent | Clean Code | Cobertura de código y cumplimiento de estilos | ```public void addStudent(String student_name, double student_grade)``` |
| Cambiar nombre de la instancia de StudentManager | Clean Code | Cobertura de código y cumplimiento de estilos | ```StudentManager student_manager = new StudentManager();``` |
| Creación de responsabilidad única separando main de StudentManager | SOLID | Cobertura de código y cumplimiento de estilos | [Main.java](src/main/java/Main.java) |
| Cohesión Baja | SOLID | Número de responsabilidades por clase. | ```Separación en clases: StudentService (gestión de datos) y StudentView (I/O).```|
| Falta de Validaciones | Defensive Programming | Número de validaciones implementadas | ```isEmpty()```|
| Métodos Largos y Complejo | Clean Code | Longitud de métodos ≤20 líneas. | ```formatStudentData() (lógica) y printStudents() (I/O).``` |
| Dificultad para Extender Funcionalidades | SOLID | Facilidad para añadir nuevas clases. | ```Crear una interfaz StudentRepository: java public interface StudentRepository {void addStudent(Student student);} ``` |
| Falta de comentarios Javadoc | Checkstyle | Número de comentarios Javadoc añadidos | ```/** Comentario Javadoc */``` |
| Nombres de variables no coinciden con el patrón | Checkstyle | Nombres de variables ajustados al patrón | ```private List<String> studentsList;``` |
| Uso de números mágicos | Checkstyle | Reemplazo de números mágicos con constantes | ```private static final double DEFAULT_GRADE = 85.5;``` |
| Líneas largas | Checkstyle | Longitud de líneas ≤80 caracteres | ```Dividir líneas largas en varias líneas``` |
| Instrucciones no cubiertas | JaCoCo | Cobertura de código | ```Agregar pruebas unitarias``` |
| Método sin cobertura | JaCoCo | Cobertura de métodos | ```Agregar pruebas unitarias para el método``` |

## Implementación
4. Implementación:
	* Refactorización del código para cumplir con CleanCode y SOLID.
	* Configuración de pipeline CI/CD básico en GitHub Actions para validar automáticamente las mejoras.
	* Generar y analizar reportes de herramientas como Checkstyle, JaCoCo y SpotBugs.

### Tabla de implementación
| Plugin implementado | Refactorización de código       | Configuración de pipeline    | Generar y analizar reportes     |
|---|---------------------------------|-----------------------------|---------------------------------|
| Total de checkstyle antes de la implementación | | | 80% |

## Análisis de cobertura de Checkstyle

| Archivo                | Línea | Columna | Regla                          | Descripción                                                           |
|-----------------------|-------|---------|--------------------------------|-----------------------------------------------------------------------|
| `Main.java`            | 1     | -       | `JavadocPackage`               | Falta el archivo `package-info.java`.                                 |
| `Main.java`            | 1     | 1       | `HideUtilityClassConstructor`  | Clases de utilidades no deben tener un constructor público o por defecto. |
| `Main.java`            | 2     | 5       | `MissingJavadocMethod`         | Falta el comentario Javadoc para el método.                           |
| `Main.java`            | 2     | 29      | `FinalParameters`              | El parámetro `args` debería ser final.                                |
| `Main.java`            | 3     | 24      | `LocalVariableName`            | El nombre `student_manager` debe coincidir con el patrón `^[a-z][a-zA-Z0-9]*$`. |
| `Main.java`            | 4     | 48      | `MagicNumber`                  | El valor `85.5` es un número mágico, debe usarse una constante.       |
| `StudentManager.java`  | 1     | -       | `NewlineAtEndOfFile`           | El archivo no termina con un salto de línea.                          |
| `StudentManager.java`  | 5     | 5       | `JavadocVariable`              | Falta el comentario Javadoc para la variable.                         |
| `StudentManager.java`  | 6     | 5       | `JavadocVariable`              | Falta el comentario Javadoc para la variable.                         |
| `StudentManager.java`  | 8     | 5       | `DesignForExtension`           | La clase `StudentManager` parece diseñada para extensión, pero el método `addStudent` no tiene Javadoc que explique cómo hacerlo de manera segura. |
| `StudentManager.java`  | 8     | 5       | `MissingJavadocMethod`         | Falta el comentario Javadoc para el método.                           |
| `StudentManager.java`  | 8     | 28      | `FinalParameters`              | El parámetro `student_name` debería ser final.                        |
| `StudentManager.java`  | 8     | 35      | `ParameterName`                | El nombre `student_name` debe coincidir con el patrón `^[a-z][a-zA-Z0-9]*$`. |
| `StudentManager.java`  | 8     | 49      | `FinalParameters`              | El parámetro `student_grade` debería ser final.                       |
| `StudentManager.java`  | 8     | 56      | `ParameterName`                | El nombre `student_grade` debe coincidir con el patrón `^[a-z][a-zA-Z0-9]*$`. |
| `StudentManager.java`  | 14    | 5       | `DesignForExtension`           | La clase `StudentManager` parece diseñada para extensión, pero el método `listStudents` no tiene Javadoc que explique cómo hacerlo de manera segura. |
| `StudentManager.java`  | 14    | 5       | `MissingJavadocMethod`         | Falta el comentario Javadoc para el método.                           |
| `StudentManager.java`  | 16    | -       | `LineLength`                   | La línea tiene más de 80 caracteres (encontrado 100).                  |

### Descripción de los datos de cobertura CheckStyle

| **Métrica**            | **Valor en el reporte** | **Interpretación**                                                    |
|-----------------------|----------------------|----------------------------------------------------------------------|
| **Errores Totales**    | 18                   | Número total de errores encontrados por Checkstyle.                  |
| **Archivos Analizados**| 2                    | Número de archivos analizados por Checkstyle.                        |
| **Errores por Archivo**| 9                    | Promedio de errores por archivo.                                      |

### Resumen del análisis CheckStyle

- Se encontraron un total de **18 errores** en los archivos analizados.
- Los errores incluyen problemas de Javadoc, nombres de variables, números mágicos y longitud de línea.
- Se recomienda revisar y corregir cada error para mejorar la calidad del código y cumplir con las normas de estilo.

### Acciones a tomar para mejorar la cobertura CheckStyle:

1. **Agregar comentarios Javadoc:**  
   Asegurarse de que todos los métodos y variables tengan comentarios Javadoc adecuados.

2. **Renombrar variables:**  
   Cambiar los nombres de las variables para que coincidan con los patrones de nomenclatura establecidos.

3. **Eliminar números mágicos:**  
   Reemplazar los números mágicos con constantes descriptivas.

4. **Ajustar longitud de línea:**  
   Dividir las líneas largas para cumplir con el límite de 80 caracteres.

| Total de checkstyle después de la implementación | | | 100% |
|---| ---| --- | --- |

## Análisis de Cobertura de Código con SpotBugs
# Detección de Bugs (SpotBugs)

## Análisis de Archivos

| **Archivo**           | **Tamaño (Bytes)** | **Cantidad de Bugs** |
|-----------------------|--------------------|----------------------|
| `Main.java`           | 8                  | 0                    |
| `StudentManager.java` | 16                 | 0                    |

## Análisis de Clases

| **Nombre de la Clase** | **Archivo**         | **Tamaño (Bytes)** | **Bugs Encontrados** | **¿Es una Interfaz?** |
|------------------------|---------------------|--------------------|----------------------|-----------------------|
| `Main`                 | `Main.java`         | 8                  | 0                    | No                    |
| `StudentManager`       | `StudentManager.java` | 16                 | 0                    | No                    |

## Rendimiento de SpotBugs

| **Nombre de la Clase**                                         | **Promedio de Microsegundos por Invocación** | **Máximo de Microsegundos por Invocación** | **Desviación Estándar** | **Invocaciones** | **Total en Milisegundos** |
|---------------------------------------------------------------|---------------------------------------------|-------------------------------------------|-------------------------|------------------|--------------------------|
| `edu.umd.cs.findbugs.classfile.engine.ClassInfoAnalysisEngine` | 842                                         | 20840                                     | 1782                    | 546              | 460                      |
| `edu.umd.cs.findbugs.classfile.engine.ClassDataAnalysisEngine` | 345                                         | 5072                                      | 335                     | 548              | 189                      |
| `edu.umd.cs.findbugs.detect.FieldItemSummary`                 | 6225                                        | 22706                                     | 7122                    | 26               | 161                      |
| `edu.umd.cs.findbugs.detect.FindNoSideEffectMethods`          | 4079                                        | 17905                                     | 4936                    | 26               | 106                      |
| `edu.umd.cs.findbugs.OpcodeStack$JumpInfoFactory`             | 788                                         | 6408                                      | 1014                    | 131              | 103                      |
| `edu.umd.cs.findbugs.classfile.engine.bcel.MethodGenFactory`  | 15823                                       | 77108                                     | 30643                   | 5                | 79                       |
| `edu.umd.cs.findbugs.classfile.engine.bcel.JavaClassAnalysisEngine` | 1185                                       | 28878                                     | 4048                    | 54               | 64                       |
| `edu.umd.cs.findbugs.util.TopologicalSort`                    | 109                                         | 2194                                      | 212                     | 503              | 55                       |
| `edu.umd.cs.findbugs.detect.NoteDirectlyRelevantTypeQualifiers` | 1978                                       | 13122                                     | 2688                    | 26               | 51                       |
| `edu.umd.cs.findbugs.detect.FunctionsThatMightBeMistakenForProcedures` | 1695                                       | 10915                                     | 2591                    | 26               | 44                       |
| `edu.umd.cs.findbugs.detect.OverridingEqualsNotSymmetrical`  | 1421                                       | 19822                                     | 3755                    | 26               | 36                       |
| `edu.umd.cs.findbugs.detect.CalledMethods`                   | 1161                                       | 3961                                      | 1201                    | 26               | 30                       |

## Análisis de Cobertura de Código con JaCoCo
Se realizó un análisis de cobertura de código utilizando **JaCoCo**, obteniendo los siguientes resultados:

### Descripción de los datos de cobertura JaCoco

| **Métrica**            | **Valor en el reporte** | **Interpretación**                                                    |
|-----------------------|----------------------|----------------------------------------------------------------------|
| **Missed Instructions**| 3 of 65               | 3 instrucciones de código no fueron cubiertas por las pruebas (62 sí fueron ejecutadas). |
| **Coverage (Cov.)**     | 95%                    | Cobertura de instrucciones del 95% (buena cobertura, solo el 5% del código no probado). |
| **Missed Branches**     | 0 of 2                  | Todas las ramas de decisión fueron cubiertas (cobertura del 100%).    |
| **Complexity (Cxty)**   | 6                        | La complejidad ciclomatica total del código.                          |
| **Missed Lines**        | 1 of 16                  | 1 línea de código no fue ejecutada durante las pruebas.               |
| **Missed Methods**      | 1 of 5                   | Falta cubrir 1 método en las pruebas.                                 |
| **Missed Classes**      | 0 of 2                   | Todas las clases han sido cubiertas por las pruebas.                  |

---

### Resumen del análisis JaCoCo

- La cobertura de código alcanzada es del **95%**, con solo **3 instrucciones** no cubiertas y **1 línea de código** sin ejecutar.
- Se ha logrado una **cobertura del 100% de ramas**, lo que garantiza que todas las decisiones condicionales (if, else, switch) han sido evaluadas adecuadamente.
- Todas las clases fueron cubiertas, pero aún queda un método que no ha sido probado, por lo que se recomienda agregar pruebas adicionales para alcanzar una cobertura completa.

---

### Acciones a tomar para mejorar la cobertura JaCoCo:

1. **Revisar las instrucciones no cubiertas:**  
   Identificar las líneas específicas del código que no fueron ejecutadas y agregar pruebas unitarias correspondientes.

2. **Cobertura del método faltante:**  
   Analizar el método sin cobertura y escribir casos de prueba para asegurarse de su correcta ejecución.

3. **Automatización del análisis:**  
   Integrar JaCoCo en el pipeline de CI/CD para evaluar la cobertura automáticamente en cada commit.

---

5. Documentación
	* Plan de acción (Máximo 5 páginas):
		- Roles y responsabilidades
		- Problemas de calidad identificados
		- Estrategias y métricas propuestas

	* Informe Final (Máximo 10 páginas):
		- Proceso de implementación
		- Comparativa del proyecto antes y después
		- Reflexión grupal sobre el trabajo en equipo

6. Presentación (de 10 - 15 min a presentar):
	* Las mejores implementaciones
	* Resultados Obtenidos (comparativa del proyecto antes y después)
	* Reflexiones sobre el trabajo colaborativo

---
# Trabajo de proyecto integrador (Pruebas):

1. Plan inicial del equipo
	* Documento o sección que detalle los roles asignados a cada miembro, con una breve descripción de sus responsabilidades
	* Descripción de los objetivos del equipo y como planean alcanzarlos
	* Descripción de por que cada rol fue asignado a un miembro en especifico

2. Evidencia de trabajo colaborativo:
	* Registro de reuniones o discusiones grupales
	* Evidencia de discusiones colaborativas sobre decisiones clave (comentarios Github, Miro, Google docs, etc)
	* Capturas de actividades realizadas por cada miembro en el repositorio
	* Una breve reflexión individual que describa como integraron los puntos de vista de todos los miembros

3. Evidencia para el cumplimiento de objetivos
	* Código fuente refactorizado y mejorado con evidencia de cumplimiento de métricas (Reportes de herramientas)
	* Pipeline funcional de CI/CD que valide automáticamente los cambios en el repositorio
	* Comparación del proyecto antes y después de las mejoras implementadas, con las métricas que respalden el progreso
	* Indicar si los objetivos planteados al inicio fueron cumplidos, detallando cualquier ajuste que se hizo
	* Documentación final (Plan de acción e informe final que incluya los objetivos iniciales, pasos realizados y resultados obtenidos)

4. Reflexión individual
	* ¿Qué aprendiste sobre el trabajo en equipo durante este proyecto?
	* ¿Cómo influyó la asignación de roles en el cumplimiento de los objetivos?
	* ¿Qué mejorarías en la dinámica del grupo para futuros trabajos?