/*
 * Created on Apr 23, 2012
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * 
 * Copyright @2012 the original author or authors.
 */
package org.assertj.core.error;

import java.util.List;

/**
 * Creates an <code>{@link AssertionError}</code> indicating that an assertion that verifies that two objects are
 * lenient equal by accepting fields failed.
 * 
 * @author Nicolas François
 * @author Joel Costigliola
 */
public class ShouldBeEqualByComparingOnlyGivenFields extends BasicErrorMessageFactory {

  /**
   * Creates a new </code>{@link ShouldBeEqualByComparingOnlyGivenFields}</code>.
   * 
   * @param actual the actual value in the failed assertion.
   * @param rejectedFields fields name not matching
   * @param expectedValues fields value not matching
   * @param acceptedFields fields on which is based the lenient equality
   * @return the created {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldBeEqualComparingOnlyGivenFields(Object actual, List<String> rejectedFields,
      List<Object> expectedValues, List<String> acceptedFields) {
    if (rejectedFields.size() == 1) {
      return new ShouldBeEqualByComparingOnlyGivenFields(actual, rejectedFields.get(0), expectedValues.get(0), acceptedFields);
    } else {
      return new ShouldBeEqualByComparingOnlyGivenFields(actual, rejectedFields, expectedValues, acceptedFields);
    }
  }

  private ShouldBeEqualByComparingOnlyGivenFields(Object actual, List<String> rejectedFields, List<Object> expectedValue,
                                                   List<String> acceptedFields) {
    super("\nExpecting values:\n  <%s>\nin fields:\n  <%s>\nof <%s>.\nComparison was performed on fields:\n  <%s>",
        expectedValue, rejectedFields, actual, acceptedFields);
  }

  private ShouldBeEqualByComparingOnlyGivenFields(Object actual, String rejectedField, Object rejectedValue,
                                                   List<String> acceptedFields) {
    super("\nExpecting value <%s> in field <%s> of <%s>", rejectedValue, rejectedField, actual, acceptedFields);
  }

}
