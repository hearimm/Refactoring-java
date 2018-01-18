package com.company;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

  @Test
  public void name() {
    assertThat(1,is(1));
  }
}