# Trabajo de proyecto integrador (Realizar):

1. Asignación de roles
	* Líder del equipo
	* Responsable de análisis de métricas
	* Responsable de revision manual
	* Responsable de análisis estático

| Cargo | Nombre de la persona |
|------|---------------|
| Líder |  |
| Responsable de análisis de métricas |  |
| Responsable de revision manual | Jossue Játiva |
| Responsable de análisis estática |  |

2. Análisis del proyecto
	* Partir por un proyecto de Java (Proporciona la plantilla básica)
	* Realizar:
		- Revision inicial del código
		- Identificando problemas como:
			- Falta de legibilidad
			- Cohesión
			- Errores de estilo
			- Métricas no cumplidas

| Identificación de problema | Código Antiguo |
| --------| ----------------- |
| Tipo de lista no especifica | ```private List students = new ArrayList<>();``` |
|  | ```private List grades = new ArrayList<>();``` |
| Nombres no declaran objeto | ```private List students = new ArrayList<>();``` |
|  | ```private List<Double> grades = new ArrayList<>();``` |
| Nombres no son expresivos | ```public void addStudent(String s, double g)``` |
| Nombre de la instancia con falta de legibilidad | ```StudentManager sm = new StudentManager();``` |
| Todas las responsabilidades están en StudentManager.java | [StudentManager.java](src/main/java/StudentManager.java) |

3. Propuesta de mejora
    * Problemas identificados
    * Técnicas de calidad a implementar (SOLID, Clean Code, Análisis estático)
    * Métricas para evaluar la calidad (Cobertura de código y cumplimiento de estilos)

| Problema identificado | Técnica de calidad a implementar | Métrica para evaluar la calidad | Código nuevo |
| --------| ----------------- | ----------- | ----------- |
| No se especifica el tipo de lista | Clean Code | Cobertura de código y cumplimiento de estilos | ```private List<String> students = new ArrayList<>();``` |
|  | Clean Code | Cobertura de código y cumplimiento de estilos | ```private List<Double> grades = new ArrayList<>();``` |
| No se identifica que tipo de objeto es | Clean Code | Cobertura de código y cumplimiento de estilos | ```private List<Double> listStudents = new ArrayList<>();``` |
|  | Clean Code | Cobertura de código y cumplimiento de estilos | ```private List<Double> listGrades = new ArrayList<>();``` |
| Cambiar variables de addStudent | Clean Code | Cobertura de código y cumplimiento de estilos | ```public void addStudent(String student_name, double student_grade)``` |
| Cambiar nombre de la instancia de StudentManager | Clean Code | Cobertura de código y cumplimiento de estilos | ```StudentManager student_manager = new StudentManager();``` |
| Creación de responsabilidad única separando main de StudentManager | SOLID | Cobertura de código y cumplimiento de estilos | [Main.java](src/main/java/Main.java) |

4. Implementación:
	* Refactorización del código para cumplir con CleanCode y SOLID
	* Configuración de pipeline CI/CD básico en Github Actions para validar automáticamente las mejoras
	* Generar y analizar reportes de herramientas como Checkstyle, JaCoCo y SpotBugs

| Refactorización de código | Configuración de pipeline | Generar y analizar reportes |
| --------| ----------------- | ----------- |
|  |  |  |
|  |  |  |
|  |  |  |

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