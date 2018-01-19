package com.company;

public class NewReleasePrice extends Price {

  @Override
  int getPriceCode() {
    return Movie.NEW_RELEASE;
  }

  @Override
  double getCharge(int daysRented) {
    return daysRented * 3;
  }

  @Override
  int getFrequentRenterPoints(int daysRented) {
    // 적립 포인트를 1 포인트 증가
    // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
    if (daysRented > 1) {
      return 2;
    } else {
      return 1;
    }
  }
}
