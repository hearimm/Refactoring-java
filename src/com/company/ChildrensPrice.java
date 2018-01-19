package com.company;

public class ChildrensPrice extends Price {

  @Override
  int getPriceCode() {
    return Movie.CHILDRENS;
  }
}
