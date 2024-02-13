ISSUES:

1) 	src/main/java/tacos/Classes/Ingredient.java	
		//@AllArgsConstructor 
		//@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
			С конструктором работает, с зависимостями без конструктора нет. Без конструктора -> JPA -> Entity + Lombok должно быть без конструктора.
1.1)	Ingredient без конструктора должен быть, но тогда проблема с данными со страницы. Со страницы получаем строку после нужно создать ингредиенты как объект.
		Придумать механизм или обёртку для данных со страницы (но зачем тогда без конструкторная реализация)
		
2)	src/main/java/tacos/Data/JdbcIngredientRepository.java
		Из книги не получается удалить, перестаёт работать.
	
3)	<dependency>
		<groupId>org.springframework.data</groupId>
		<artifactId>spring-data-jpa</artifactId>
	</dependency>
		
		ошибок много ->
		java.lang.IllegalStateException: Error processing condition on org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration$StringHttpMessageConverterConfiguration.stringHttpMessageConverter
		
		
		