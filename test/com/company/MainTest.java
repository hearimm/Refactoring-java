package com.company;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MainTest {

  private Customer customer;

  @Before
  public void setUp() throws Exception {
    customer = new Customer("Hyuk");
  }

  @Test
  public void newMovie() {
    customer.addRental(new Rental(new Movie("1987", Movie.NEW_RELEASE), 3));
    assertThat(customer.statement(), is(
        "Hyuk 고객님의 대여 기록\n\t1987\t9.0\n누적 대여료: 9.0\n적립 포인트: 2"));
  }

  @Test
  public void newMovieDual() {
    customer.addRental(new Rental(new Movie("1987", Movie.NEW_RELEASE), 3));
    customer.addRental(new Rental(new Movie("코코", Movie.NEW_RELEASE), 3));
    assertThat(customer.statement(), is(
        "Hyuk 고객님의 대여 기록\n\t1987\t9.0\n\t코코\t9.0\n누적 대여료: 18.0\n적립 포인트: 4"));
  }

  @Test
  public void childrenMovie() {
    customer.addRental(new Rental(new Movie("포켓몬", Movie.CHILDRENS), 3));
    assertThat(customer.statement(), is("Hyuk 고객님의 대여 기록\n\t포켓몬\t1.5\n누적 대여료: 1.5\n적립 포인트: 1"));
  }

  @Test
  public void regularMovieMultiple() {
    customer.addRental(new Rental(new Movie("다크나이트", Movie.REGULAR), 1));
    customer.addRental(new Rental(new Movie("매트릭스", Movie.REGULAR), 2));
    customer.addRental(new Rental(new Movie("맨인블랙", Movie.REGULAR), 3));

    assertThat(customer.statement(),
        is("Hyuk 고객님의 대여 기록\n\t다크나이트\t2.0\n\t매트릭스\t2.0\n\t맨인블랙\t3.5\n누적 대여료: 7.5\n적립 포인트: 3"));
  }

  @Test
  public void newMovieHtml() {
    customer.addRental(new Rental(new Movie("1987", Movie.NEW_RELEASE), 3));
    assertThat(customer.htmlStatement(), is(
        "<H1><EM>Hyuk 고객님의 대여 기록</EM></H1><P>\n1987: 9.0<BR>\n<P>누적 대여료: <EM>9.0</EM><P>\n적립 포인트: <EM>2</EM><P>"));
  }

  @Test
  public void newMovieDualHtml() {
    customer.addRental(new Rental(new Movie("1987", Movie.NEW_RELEASE), 3));
    customer.addRental(new Rental(new Movie("코코", Movie.NEW_RELEASE), 3));
    assertThat(customer.htmlStatement(), is(
        "<H1><EM>Hyuk 고객님의 대여 기록</EM></H1><P>\n1987: 9.0<BR>\n코코: 9.0<BR>\n<P>누적 대여료: <EM>18.0</EM><P>\n적립 포인트: <EM>4</EM><P>"));
  }

  @Test
  public void childrenMovieHtml() {
    customer.addRental(new Rental(new Movie("포켓몬", Movie.CHILDRENS), 3));
    assertThat(customer.htmlStatement(), is("<H1><EM>Hyuk 고객님의 대여 기록</EM></H1><P>\n포켓몬: 1.5<BR>\n<P>누적 대여료: <EM>1.5</EM><P>\n적립 포인트: <EM>1</EM><P>"));
  }

  @Test
  public void regularMovieMultipleHtml() {
    customer.addRental(new Rental(new Movie("다크나이트", Movie.REGULAR), 1));
    customer.addRental(new Rental(new Movie("매트릭스", Movie.REGULAR), 2));
    customer.addRental(new Rental(new Movie("맨인블랙", Movie.REGULAR), 3));

    assertThat(customer.htmlStatement(),
        is("<H1><EM>Hyuk 고객님의 대여 기록</EM></H1><P>\n다크나이트: 2.0<BR>\n매트릭스: 2.0<BR>\n맨인블랙: 3.5<BR>\n<P>누적 대여료: <EM>7.5</EM><P>\n적립 포인트: <EM>3</EM><P>"));
  }

}