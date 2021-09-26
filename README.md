# sb_kotlin_tutorial

[스프링 공식 문서 튜토리얼 : Building web applications with Spring Boot and Kotlin](https://spring.io/guides/tutorials/spring-boot-kotlin/)

알게된 것들

* nullable 인 properties 들은 뒤쪽에 선언해야 생략할 수 있어 호출할 때 편리하다.

* 사실 namedParameter를 사용하는 것이 가장 좋아 보인다.(builder패턴과 유사하게 사용 가능)
* 확장함수를 통해 entity -> dto 변환은 꽤 좋아보인다.(근데 굳이 확장함수를 사용할 필요가 있나?)
* ?: 키워드는 nullable 인 객체가 null 일 경우 처리를 해줌 
* kotlin의 restController는 매우매우 심플함. entity를 그대로 리턴해도됨.(자동으로 변환해주는 듯하다.)
* kapt는 정확히 이해는 못했지만 사용 가능 범위가 꽤 넓어 보임.