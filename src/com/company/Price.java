package com.company;

abstract class  Price {
  abstract int getPriceCode();

  double getCharge(int daysRented) {
    double result = 0;
    switch (getPriceCode()) {
      case Movie.REGULAR:
        result = geResultRegular(daysRented);
        break;
      case Movie.NEW_RELEASE:
        result += getResultNew(daysRented);
        break;
      case Movie.CHILDRENS:
        result = getResult(daysRented);
        break;
    }
    return result;
  }

  private double getResult(int daysRented) {
    double result = 0;
    result += 1.5;
    if (daysRented > 3) {
      result += (daysRented - 3) * 1.5;
    }
    return result;
  }

  private int getResultNew(int daysRented) {
    return daysRented * 3;
  }

  private double geResultRegular(int daysRented) {
    double result = 0;
    result += 2;
    if (daysRented > 2) {
      result += (daysRented - 2) * 1.5;
    }
    return result;
  }
}