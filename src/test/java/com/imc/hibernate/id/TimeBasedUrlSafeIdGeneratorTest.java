package com.imc.hibernate.id;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TimeBasedUrlSafeIdGeneratorTest {

  @Test
  void generateReturnsAString() {
    Serializable generatedId = new TimeBasedUrlSafeIdGenerator().generate(null, null);
    Assertions.assertTrue(generatedId instanceof String);
  }

  @Test
  void generateIgnoresParams() {
    Serializable generatedId = new TimeBasedUrlSafeIdGenerator().generate(null, null);
    Assertions.assertNotNull(generatedId);
  }

  @Test
  void generatedIdDoesNotContainDashes() {
    String generatedId = (String) new TimeBasedUrlSafeIdGenerator().generate(null, null);
    Assertions.assertFalse(generatedId.contains("-"));
  }

  @Test
  void generatedIdIsLowerCase() {
    String generatedId = (String) new TimeBasedUrlSafeIdGenerator().generate(null, null);
    Assertions.assertEquals(generatedId.toLowerCase(), generatedId);
  }

  @Test
  void generatedIdIs32Chars() {
    String generatedId = (String) new TimeBasedUrlSafeIdGenerator().generate(null, null);
    Assertions.assertEquals(32, generatedId.length());
  }

  @Test
  void generatedIdsAreOrderedAsStrings() {
    List<String> generatedIds = new ArrayList<>();
    TimeBasedUrlSafeIdGenerator generator = new TimeBasedUrlSafeIdGenerator();

    for (int i = 0; i < 1000; i++) {
      generatedIds.add((String)generator.generate(null, null));
    }

    List<String> sortedIds = new ArrayList<>(generatedIds);
//    Collections.copy(sortedIds, generatedIds);

    Collections.sort(sortedIds);

    Assertions.assertEquals(sortedIds, generatedIds);
  }
}