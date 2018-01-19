package com.company;

abstract class  Price {

  abstract int getPriceCode();
  abstract double getCharge(int daysRented);

  int getFrequentRenterPoints(int daysRented) {
    // 적립 포인트를 1 포인트 증가
    // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
    if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
      return 2;
    } else {
      return 1;
    }
  }
}