package com.company;

public class Movie {

  public static final int CHILDRENS = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;

  private String _title;
  private int _priceCode;
  private Price _price;

  public Movie(String _title, int _priceCode) {
    this._title = _title;
    setPriceCode(_priceCode);
  }

  public int getPriceCode() {
    return _price.getPriceCode();
  }

  public void setPriceCode(int arg) {
    switch (arg) {
      case REGULAR:
        _price = new RegularPrice();
        break;
      case CHILDRENS:
        _price = new ChildrensPrice();
        break;
      case NEW_RELEASE:
        _price = new NewReleasePrice();
        break;
      default:
        throw new IllegalArgumentException("가격 코드가 잘못됐습니다.");
    }
  }

  public String getTitle() {
    return _title;
  }


  double getCharge(int daysRented) {
   return _price.getCharge(daysRented);
  }

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
