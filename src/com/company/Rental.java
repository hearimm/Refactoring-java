package com.company;

public class Rental {

  private Movie _movie;
  private int _daysRented;

  public Rental(Movie _movie, int _daysRented) {
    this._movie = _movie;
    this._daysRented = _daysRented;
  }

  public Movie getMovie() {
    return _movie;
  }

  public int getDaysRented() {
    return _daysRented;
  }

  double getCharge() {
    return _movie.getCharge(_daysRented);
  }

  int getFrequentRenterPoints() {
    // 적립 포인트를 1 포인트 증가
    // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
    if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
        getDaysRented() > 1) {
      return 2;
    } else {
      return 1;
    }
  }
}
