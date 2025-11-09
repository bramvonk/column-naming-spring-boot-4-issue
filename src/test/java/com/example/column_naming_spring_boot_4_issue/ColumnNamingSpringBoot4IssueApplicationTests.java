package com.example.column_naming_spring_boot_4_issue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ColumnNamingSpringBoot4IssueApplicationTests {

    @Autowired
    private ExampleRepository exampleRepository;

	@Test
	void oldNamingShouldSucceed() {
        exampleRepository.getColumnWith1Number();
	}

    @Test
    void newNamingShouldFail() {
        DataAccessException thrown = assertThrows(
                DataAccessException.class,
                () -> exampleRepository.getColumnWith1NumberWithSpringBoot4Naming(),
                "Didn't expect an new column to exist"
        );

        Assertions.assertThatCharSequence(thrown.getMessage()).contains("Column \"COLUMN_WITH1_NUMBER\" not found");
    }

}
