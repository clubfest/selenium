// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.


package com.thoughtworks.selenium.corebased;

import com.thoughtworks.selenium.InternalSelenseTestBase;

import org.junit.Test;

public class TestOpen extends InternalSelenseTestBase {
  @Test
  public void testOpen() throws Exception {
    selenium.open("../tests/html/test_open.html");
    verifyTrue(selenium.getLocation().matches("^[\\s\\S]*/tests/html/test_open\\.html$"));
  }

  @Test
  public void testIsTextPresentCanDoExactAndRegexChecks() {
    selenium.open("../tests/html/test_open.html");
    verifyTrue(selenium.isTextPresent("This is a test of the open command."));
    verifyTrue(selenium.isTextPresent("glob:This is a test of the open command."));
    verifyTrue(selenium.isTextPresent("exact:This is a test of"));
    verifyTrue(selenium.isTextPresent("regexp:This is a test of"));
    verifyTrue(selenium.isTextPresent("regexp:T*his is a test of"));
    verifyFalse(selenium.isTextPresent("exact:XXXXThis is a test of"));
    verifyFalse(selenium.isTextPresent("regexp:ThXXXXXXXXXis is a test of"));
  }

@Test
  public void testCanOpenSlowLoadingPage() {
    selenium.open("../tests/html/test_page.slow.html");
    verifyTrue(selenium.getLocation().matches("^[\\s\\S]*/tests/html/test_page\\.slow\\.html$"));
    verifyEquals(selenium.getTitle(), "Slow Loading Page");
    selenium.setTimeout("5000");
    selenium.open("../tests/html/test_open.html");
    selenium.open("../tests/html/test_open.html");
    selenium.open("../tests/html/test_open.html");
  }

}
